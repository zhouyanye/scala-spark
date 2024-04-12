package chater08
import org.apache.spark.sql.SparkSession


/**
 * @Author： 小周
 * @Date： 2024/2/23 20:24
 * @Describe：
 */
object Create_DataFrame_Example1 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Create_DataFrame_Example1").master("local[*]").getOrCreate()
    // :paste
    import java.util.Properties
    val url = "jdbc:mysql://master:3306/student"
    val table = "score"
    val properties = new Properties()
    properties.setProperty("user", "root")
    properties.setProperty("password", "MyPassword20040620!")
    properties.setProperty("useSSL", "false") // 设置为 false 禁用 SSL
    val df = spark.read.jdbc(url, table, properties)
    df.show()
    df.printSchema()
  }
}
