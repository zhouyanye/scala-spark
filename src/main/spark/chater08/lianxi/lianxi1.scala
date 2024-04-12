package chater08.lianxi

import org.apache.spark.sql.SparkSession

/**
 * @Author： 小周
 * @Date： 2024/4/11 15:47
 * @Describe：
 */
object lianxi1 {
  def main(args: Array[String]): Unit = {
    val spark= SparkSession.builder().appName("lianxi1").master("local[2]").getOrCreate()
    val lines=spark.read.json("file:///G:\\spark\\spark\\src\\main\\spark\\chater08\\lianxi\\user.json")
    lines.show()
  }

}
