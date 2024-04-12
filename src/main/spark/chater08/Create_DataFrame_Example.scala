package chater08

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author： 小周
 * @Date： 2024/2/22 9:49
 * @Describe：
 */
object Create_DataFrame_Example {
  def main(args: Array[String]): Unit = {
    // 创建Spark配置
    val conf = new SparkConf().setAppName("Create_DataFrame_Example").setMaster("local[2]")
    // 创建Spark上下文
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder()
      .appName("Create_DataFrame_Example")
      .getOrCreate()
    val input = spark.sparkContext.textFile("hdfs://master:8020/sparkdatas/people.txt")
    val data = input.map(x => {
      val line = x.split(" ")
      People(line(0), line(1), line(2).toInt)
    })
    val df = spark.createDataFrame(data)
    df.show()
    df.printSchema()
  }

}

/**
 * spark sql 使用的数据抽象并非是RDD，而是DataFrame，DataFrame是Spark SQL的抽象，DataFrame是Spark SQL的查询结果，
 * DataFrame可以使用Spark SQL的语法，DataFrame可以使用Spark SQL的算子，DataFrame可以使用Spark SQL的函数
 * 在spark1.3.0之前,DataFrame被称为SchemaRDD
 * DataFrame使spark具备处理大规模结构化数据的能力
 * 在spark中 DataFrame是一种以RDD以基础的分布式数据集
 * DataFrame的结构类似传统数据库的二维表格,可以从很多数据源创建DataFrame,比如:
 * 结构化文件,CSV文件,ORC文件,Parquet文件,以及Hive表
 *
 * 创建DataFrame的两种基本方式
 * 1 通过spark读取数据源直接创建DataFrame SparkSession方式创建DataFrame  spark.read()
 * spark.read.text("people.txt") 读取txt文件创建DataFrame
 * spark.read.csv("people.csv") 读取csv文件创建DataFrame
 * spark.read.json("people.json") 读取json文件创建DataFrame
 * spark.read.parquet("people.parquet") 读取parquet文件创建DataFrame
 *
  scala> val txt=spark.read.text("/datas/people.txt")
txt: org.apache.spark.sql.DataFrame = [value: string]

scala> txt.show
+-------------+
|        value|
+-------------+
|1 zhangsan 20|
|    2 lisi 29|
|  3 wangwu 25|
| 4 zhaoliu 30|
|  5 tianqi 35|
|   6 jerry 40|
+-------------+


scala> txt.printSchema
root
 |-- value: string (nullable = true)

使用sparkSession 加载hdfs中的/datas/people.json文件保存DataFrame数据集 并打印输出
val json=spark.read.json("/datas/people.json")
json: org.apache.spark.sql.DataFrame = [age: bigint,name:string]
json.show
+-------+---+
|age|name|
+---+----+
| 20|zhangsan|
| 29|   lisi|
| 25| wangwu|
+---+----+
json.printSchema
root
 |-- age: long (nullable = true)
 |-- name: string (nullable = true)
使用sparkSession 加载hdfs中的/datas/people.csv文件保存DataFrame数据集 并打印输出
头部作为字段 true
val csv=spark.read.option("header","true").csv("/datas/people.csv")
csv: org.apache.spark.sql.DataFrame = [name: string,age: string...1 more field]
csv.show
+-------+---+---+
|  name|age|job|
+-------+---+----+
|zhangsan| 20|  IT|
|   lisi| 29|  IT|
| wangwu| 25|  IT|
+-------+---+----+
csv.printSchema

使用sparkSession 加载hdfs中的/datas/users.parquet文件保存DataFrame数据集 并打印输出
 val par=spark.read.parquet("/datas/users.parquet")
 par: org.apache.spark.sql.DataFrame = [age: bigint,name:string,job:string]
 par.show
 +---+----+----+
|age|name|job|
+---+----+----+
| 20|zhangsan|  IT|
| 29|   lisi|  IT|
| 25| wangwu|  IT|
+---+----+----+
par.printSchema
root
 |-- age: long (nullable = true)
 |-- name: string (nullable = true)
 |-- job: string (nullable = true)

同外部数据库创建的DataFrame
spark sql从数据库中读取数据,并转换为DataFrame
使用这种方式创建DataFrame,需要先创建SparkSession,然后使用SparkSession的sql方法,传入sql语句,得到DataFrame
spark.read.jdbc(url: String,table:String,properties: Properties)
url: String,数据库连接地址
table: String,数据库表名
properties: Properties,数据库连接属性
import java.util.Properties
val url="jdbc:mysql://master:3306/student"
val table="score"
val properties=new Properties()
properties.setProperty("user","root")
properties.setProperty("password","MyPassword20040620!")
val df=spark.read.jdbc(url,table,properties)
 *
 *
 * 2 将已存在转换RDD得到DataFrame 当已知RDD的schema时候可以toDF方法,当未知RDD数据结构,使用编程方式构建schema
 *
 */