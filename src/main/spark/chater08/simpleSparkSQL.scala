package chater08

/**
 * @Author： 小周
 * @Date： 2024/2/1 11:11
 * @Describe：
 */
object simpleSparkSQL {
  /*
  * @Description: Spark SQL
  * @Version: 1.0
  * @Since: 2024-01-31 17:10
  * @LastEditors: 小周
  * @LastEditTime: 2024-01-31 17:10
  * @注意事项: 需要启动Metastore，Hadoop集群，HiveServer2
  */
  // 导入 SparkSession

  import org.apache.spark.sql.SparkSession
  def main(args: Array[String]): Unit = {
    // 创建 SparkSession
    val spark = SparkSession.builder.appName("SparkHiveExample").master("local[2]").enableHiveSupport().getOrCreate()

    // 运行 Spark SQL 查询
    val result = spark.sql("select 1")

    // 打印结果
    result.show()

    // 关闭 SparkSession
    spark.stop()

  }
}
