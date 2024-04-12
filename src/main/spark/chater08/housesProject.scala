package chater08

/**
 * @Author： 小周
 * @Date： 2024/3/28 18:13
 * @Describe：
 */
package chater08

import org.apache.spark.sql.functions.{avg, col, desc, expr, quarter, to_date}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types.DataTypes

/**
 * @Author： 小周
 * @Date： 2024/3/28 10:06
 * @Describe：
 */
object housesProject {
  def main(args: Array[String]): Unit = {
    def AgeTitle(age: Int): String = {
      if (age >= 30) "old"
      else if (age <= 10) "new"
      else "middle"
    }

    val spark = SparkSession
      .builder()
      .config("hive.metastore.uris", "thrift://master:9083")
      .config("spark.sql.shuffle.partitions", "4")
      .appName("houseProject")
      .master("local[2]")
      .enableHiveSupport()
      .getOrCreate()

    // 读取数据
    println("开始读取")
    val house = spark.table("house.king_county_house")
    house.show()

    // 删除有缺失值的数据记录并转化日期格式
    val houseDate = house.na.drop()
      .withColumn("date", to_date(col("sale_data"), "yyyyMMdd"))
    println("删除有缺失值的数据记录并转化日期格式")
    houseDate.show()

    // 根据时间划分季节
    val houseQuarter = houseDate.withColumn("quarter", quarter(col("date")))
    println("根据时间划分季节")
    houseQuarter.select("date", "quarter").show()

    // 统计每个季节的房屋销量
    println("统计每个季节的房屋销量")
    houseQuarter.groupBy("quarter")
      .count()
      .sort("quarter")
      .show()

    // 统计每个季节的房屋销售额
    println("统计每个季节的房屋销售额")
    houseQuarter.groupBy("quarter")
      .sum("selling_price")
      .sort("quarter")
      .show()

    // 统计不同评分的房屋分布情况
    println("统计不同评分的房屋分布情况")
    houseQuarter.groupBy("housing_rating")
      .count()
      .sort(desc("count"))
      .show()

    // 房屋评分同房屋单位售价关系探索
    println("房屋评分同房屋单位售价关系探索")
    houseQuarter.groupBy("housing_rating")
      .agg(avg(col("selling_price") / col("housing_area")))
      .sort("housing_rating")
      .show()

    // 计算修缮过的房屋年龄
    println("计算修缮过的房屋年龄")
    val houseRepair = houseQuarter.filter("year_repair != 0").withColumn("houseAge",
      -(col("year_built").cast(DataTypes.IntegerType) - 2020))

    // 赋予标签
    val houseAgeTitle = houseRepair.withColumn("houseAgeTitle",
      expr("transform(array(houseAge), x -> IF(x >= 30, 'old', IF(x <= 10, 'new', 'middle')))"))
    println("赋予标签")
    houseAgeTitle.show()

    // 房龄分布统计
    println("房龄分布统计")
    houseAgeTitle.groupBy("houseAgeTitle")
      .count()
      .sort("count")
      .show()
  }
}
