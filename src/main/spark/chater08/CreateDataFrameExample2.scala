package chater08

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SparkSession}

/**
 * @Author： 小周
 * @Date： 2024/2/23 20:59
 * @Describe：
 */

case class People(id: String, name: String, age: Int)

object CreateDataFrameExample2 {
  def main(args: Array[String]): Unit = {
    // 创建Spark配置
    val conf = new SparkConf().setAppName("EmployeeSalaryAnalysis").setMaster("local[2]")

    // 创建Spark上下文
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder()
      .appName("Create_DataFrame_Example2")
      .master("local[*]")
      .getOrCreate()

    // 读取数据文件并转换为DataFrame
    val input = spark.sparkContext.textFile("/sparkdatas/people.txt")
    val data = input.map(x => {
      val line = x.split(" ")
      People(line(0), line(1), line(2).toInt)
    })

    // 使用 createDataFrame 方法将 RDD 转换为 DataFrame
    val df = spark.createDataFrame(data)

    // 显示DataFrame数据
    df.show()
    // 打印DataFrame的Schema
    df.printSchema()

    spark.stop()

  }
}




/**
 * scala> val db=spark.read.table("user.user_info")
24/02/23 21:18:33 WARN HiveConf: HiveConf of name hive.metastore.event.db.notification.api.auth does not exist
24/02/23 21:18:33 WARN HiveConf: HiveConf of name hive.server2.active.passive.ha.enable does not exist
24/02/23 21:18:33 WARN HiveConf: HiveConf of name hive.optimize.dynamic.partition.pruning does not exist
24/02/23 21:18:33 WARN HiveConf: HiveConf of name hive.log.perf.output does not exist
24/02/23 21:18:33 WARN HiveConf: HiveConf of name hive.server2.thrift.heap.size does not exist
db: org.apache.spark.sql.DataFrame = [id: string, name: string ... 1 more field]

scala> db.show
+---+-------+---+
| id|   name|age|
+---+-------+---+
|  4|  David| 42|
|  6|   Fran| 50|
|  2|    Bob| 27|
|  1|  Alice| 28|
|  3|Charlie| 65|
|  5|     Ed| 55|
+---+-------+---+

 已知数据结构的RDD转换为DataFrame
 导入import org.spark.implicits._  //用于支持隐式导入Schema
 定义一个case class样例类 参数名会被利用反射机制制作为列名
通过sparkContext对象读取文件生成一个RDD，将RDD与样例类匹配
 调用toDF方法将RDD转换为DataFrame
 val input=sc.textFile("/datas/people.txt")
input: org.apache.spark.rdd.RDD[String] = /datas/people.txt MapPartitionsRDD[9] at textFile at <console>:23
 scala> case class People(id:String,name:String,age:Int)
defined class People
 scala> val data=input.map( x =>{
     | val line=x.split(" ");
     | People(line(0),line(1),line(2).toInt);
     | })
data: org.apache.spark.rdd.RDD[People] = MapPartitionsRDD[10] at map at <console>:25
 scala> val result=data.toDF
result: org.apache.spark.sql.DataFrame = [id: string, name: string ... 1 more field]

scala> result.show
+---+--------+---+
| id|    name|age|
+---+--------+---+
|  1|zhangsan| 20|
|  2|    lisi| 29|
|  3|  wangwu| 25|
|  4| zhaoliu| 30|
|  5|  tianqi| 35|
|  6|   jerry| 40|
+---+--------+---+

scala> result.printSchema
root
 |-- id: string (nullable = true)
 |-- name: string (nullable = true)
 |-- age: integer (nullable = false)


 未知数据结构的RDD通过编程方式定义Schema
 当case类不能提前定义Schema时,就采用编程定义Schema信息 实现RDD转换DataFrame的两种方式
 1 通过SparkSession的createDataFrame方法 基于StructType类型来创建Schema 来实现rdd转换成dataframe
 import org.apache.spark.sql.Row
 val peoplerdd=sc.textFile("/datas/people.txt").map( x => {
 })



 */