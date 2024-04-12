package chater08

import org.apache.spark.sql.SparkSession


/**
 * @Author： 小周
 * @Date： 2024/3/31 19:35
 * @Describe：
 */
case class Persons(id:Int,name:String,age:Int)
object sparkSql_example {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder()
      .appName("sparkSql_example")
      .master("local[2]")
      .enableHiveSupport()
      .getOrCreate()
    val sc=spark.sparkContext

//sparkSession创建DataFrame 使用spark.read 不同类型的文件加载篡改就dataframe
   //读取txt 使用spark.read.text
    val personDF=spark.read.text("/sparkdatas/person.txt")
    personDF.printSchema()
    personDF.show()
    //读取csv 使用spark.read.csv
    //读取json 使用spark.read.json
   //读取parquet 使用spark.read.parquet

    //通过外部数据库创建DataFrame
    //spark.read.jdbc(url,table,properties)
    import java.util.Properties
    val url="jdbc:mysql://master:3306/student"
    val table="score"
    val properties=new Properties()
    properties.setProperty("user","root")
    properties.setProperty("password","MyPassword20040620!")
    properties.setProperty("useSSL","false")
    val jdbcDF=spark.read.jdbc(url,table,properties)
    jdbcDF.show
    //通过sql 查询语句 spark.sql()
    //table方法spark.read.table(tablename)
    //读取hive表中数据库的表数据
    val df1=spark.sql("select * from score")
    df1.show
    //RDD转换DataFrame两个方法
    //利用反射机制来推断包含特定类型对象的Schema 这种方法适用于对一直数据结构的RDD转换
    //import spark.implicits._ //支持隐式导入Schema
      //定义case class 样例类 样例类的参数名被利用反射机制变成列名
      //通过SparkContext对象读取文件生成一个RDD,RDD与样例类匹配 调用toDF方法将rdd转换DataFrame
//      val lineRDD=sc.textFile("/sparkdtas/people.txt").map(_.split(" "))
//      val personRDD=lineRDD.map(x=>Persons(x(0).toInt,x(1),x(2).toInt))
//      val personDF=personRDD.toDF()



    //通过编程接口鼓噪一个Schema 并将其用于在已知的RDD数据中


  }

}
