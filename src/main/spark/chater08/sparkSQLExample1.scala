package chater08

import org.apache.spark.sql.SparkSession

/**
 * @Author： 小周
 * @Date： 2024/2/4 13:20
 * @Describe：
 */
object sparkSQLExample1 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("sparkSQLExample")
      .master("local[2]")
      .enableHiveSupport()
      .getOrCreate()
    spark.sql("show tables").show()
  }

}
