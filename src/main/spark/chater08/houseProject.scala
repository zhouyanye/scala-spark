package chater08

import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import org.apache.spark.sql.types._
import java.io.Serializable
/**
 * @Author： 小周
 * @Date： 2024/3/28 10:06
 * @Describe：房价信息分析
 */
object houseProject  extends Serializable{
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .config("hive.metastore.uris", "thrift://master:9083") //hive元数据地址
      .appName("houseProject")
      .config("spark.sql.shuffle.partitions", "4")
      .config("spark.some.config.option", "some-value")
      .master("local[2]")
      .enableHiveSupport()
      .getOrCreate()
    //读取数据
    println("开始读取")
    val house = spark.table("house.king_county_house") //读取house.king_county_house表
    house.show() //展示数据

    //统计缺失值数量
    //    def null_count(data: DataFrame, columnName: String): Unit = {
    //      println(s"${columnName}缺失值数量为：${data.count() - data.na.drop().count()}")
    //    }
    //
    //    //字段值分布统计 最大值最小值平均值标准差
    //    def max_min_mean_stddev(data: DataFrame, columnName: String): Unit = {
    //      println(columnName + ":")
    //      data.selectExpr("max(" + columnName + ") as max")
    //        .foreach(line => println("max:" + line.toString()))//获取最大值
    //      data.selectExpr("min(" + columnName + ") as min")
    //        .foreach(line => println("min" + line.toString()))//获取最小值
    //      data.selectExpr("mean(" + columnName + ") as mean")
    //        .foreach(line => println("mean" + line.toString()))//获取平均值
    //      data.selectExpr("stddev(" + columnName + ") as stddev")
    //        .foreach(line => println("stddev" + line.toString()))//获取标准差
    //    }
    //    println("数据统计：")
    // import spark.implicits._
    //    val dataCoulumnName=house.columns.toList //获取列名
    //    for (i<-dataCoulumnName) {
    //      if (i == "sale_data" || i == "year_built" || i == "year_repair") {
    //        println(i + ":")
    //        null_count(house, i)
    //        println("----------------")
    //      }
    //      else{
    //        max_min_mean_stddev(house, i)
    //      }
    //    }
    //删除有缺失值的数据记录并转化日期格式  销售日期为日期格式
    //  删除有缺失值的数据记录               转化日期格式
    val houseDate = house.na.drop()
      .withColumn("date", to_date(col("sale_data"), "yyyyMMdd")) //yyyy-MM-dd会出现null spark3x不支持YYYY-MM-dd
    println("删除有缺失值的数据记录并转化日期格式")
    houseDate.show()

    //根据时间划分季节
    val houseQuarter = houseDate.withColumn("quarter", quarter(col("date")))
    println("根据时间划分季节")
    houseQuarter.select("date", "quarter").show()
    //统计每个季节的房屋销量 升序
    println("统计每个季节的房屋销量")
    val houseQuarterCount: Unit = houseQuarter.groupBy("quarter")
      .count()
      .sort("quarter")
      .show()
    //统计每个季节的房屋销售额
    println("统计每个季节的房屋销售额")
    val houseQuarterSum: Unit = houseQuarter.groupBy("quarter")
      .sum("selling_price")
      .sort("quarter")
      .show()
    //统计不同评分的房屋分布情况
    println("统计不同评分的房屋分布情况")
    val houseRating: Unit = houseQuarter.groupBy("housing_rating")
      .count()
      .sort(desc("count"))
      .show()
    //房屋评分同房屋单位售价关系探索
    println("房屋评分同房屋单位售价关系探索")
    val houseRatingPrice: Unit = houseQuarter.groupBy("housing_rating")
      .agg(avg(col("selling_price") / col("housing_area")))
      .sort("housing_rating")
      .show()

    //计算修鳝过的房屋年龄
    println("计算修缮过的房屋年龄")
    val houseRepair = houseQuarter.filter("year_repair != 0").withColumn(
      "houseAge",-(col("year_built").cast(DataTypes.IntegerType)-2020))
    //为houseAge字段的值贴上标签
    def AgeTitle(age: Int): String = {
      if (age >= 30) {
        "old"
      } else if (age <= 10) {
        "new"
      } else {
        "middle"
      }
    }

    val houseAgeTitleUdf = udf((x: Int) => AgeTitle(x))

    val houseAgeTitle = houseRepair.withColumn( "houseAgeTitle", houseAgeTitleUdf(col("houseAge")))
    houseAgeTitle.show()
    //房龄分布统计
    println("房龄分布统计")
    //房龄分布统计
    println("房龄分布统计")
    houseAgeTitle.groupBy("houseAgeTitle")
      .count()
      .sort("count")
      .show()

  }
}
