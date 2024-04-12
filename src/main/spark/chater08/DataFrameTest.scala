package chater08

import org.apache.spark.sql.SparkSession

import java.util.Properties

/**
 * @Author： 小周
 * @Date： 2024/3/21 11:18
 * @Describe：
 */
object DataFrameTest {
  def main(args: Array[String]): Unit = {
    //配置SsparkSession配置环境变量
    val spark = SparkSession
      .builder()
      .config("hive.metastore.uris", "thrift://master:9083")
      .appName("DataFrameTest")
      .master("local[2]")
      .enableHiveSupport()
      .getOrCreate()



    //1读取hdfs 上面的student_info.txt生成的DataFrame 查询学号后面2位大于50的学号姓名性别保存hdfs
    val input = spark.read.format("csv").option("header", "true").load("/datas/student_info.txt")
    //保存hdfs
    val result = input.filter("substring(stu_no,9,2)>50").select("stu_no","stu_name","stu_sex")
     //result.write.mode("overwrite").option("header","true").csv("/res_csv_out1")

    //保存mysql
    val url = "jdbc:mysql://master:3306/student"
    val table = "students_info"
    val properties = new Properties()
    properties.setProperty("user", "root")
    properties.setProperty("password", "MyPassword20040620!")
    properties.setProperty("useSSL", "false") // 设置为 false 禁用 SSL
//    result.write.jdbc(url, table, properties)


    //保存hive
//    result.write.saveAsTable("student_info")
    spark.sql("select * from student_info").show()

  }

}
