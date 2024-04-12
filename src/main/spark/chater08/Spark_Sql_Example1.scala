package chater08

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

/**
 * @Author： 小周
 * @Date： 2024/3/20 21:43
 * @Describe
 * */

object Spark_Sql_Example1 {
  def main(args: Array[String]): Unit = {
//创建SparkSession
    val spark = SparkSession
      .builder()
      .appName("Spark_Sql_Example1")
      .master("local[2]")
      //启用hive
//      .enableHiveSupport()
      .getOrCreate()
    val sc: SparkContext=spark.sparkContext
    //设置日志级别
    sc.setLogLevel("WARN")
    //读取文件
    val fileRDD=sc.textFile("file:///G:\\spark\\spark\\out\\spark-sql\\person.txt")
    val linesRDD=fileRDD.map(_.split(" ")) //空格分隔
    val rowRDD=linesRDD.map(line=>(
      line(0).toInt,line(1),line(2).toInt)
    )
    //RDD转换DataFrame
    import spark.implicits._
    val df=spark.createDataFrame(rowRDD).toDF("id","name","age")
    //打印前十条数据
    df.show(10)
    //打印元数据信息
    df.printSchema()
    //关闭资源
    sc.stop()
    spark.stop()


  }
}