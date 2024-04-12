package chater08
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types._

object Create_DataFrame_Example3 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("DataFrame Example")
      .master("local")
      .getOrCreate()

    val peoplerdd = spark.sparkContext.textFile("/datas/people.txt")

    val rdd1 = peoplerdd.map(x => {
      val line = x.split(" ")
      Row(line(0), line(1), line(2).toInt)
    })

    val schema = StructType(Array(
      StructField("id", StringType, true),
      StructField("name", StringType, true),
      StructField("age", IntegerType, true)
    ))

    // 使用转换后的 RDD 创建 DataFrame
    val peopleDF = spark.createDataFrame(rdd1, schema)

    // 显示 DataFrame 内容
    peopleDF.show()

    // 停止 SparkSession
    spark.stop()
  }
}


/**
scala> import org.apache.spark.sql.Row
import org.apache.spark.sql.Row

scala> val input=sc.textFile("/datas/people.txt")
input: org.apache.spark.rdd.RDD[String] = /datas/people.txt MapPartitionsRDD[1] at textFile at <console>:24

scala>  val rdd1=input.map(x=>{
     |     val line=x.split(" ")
     |     Row(line(0), line(1), line(2).toInt)
     |   })
rdd1: org.apache.spark.rdd.RDD[org.apache.spark.sql.Row] = MapPartitionsRDD[2] at map at <console>:24

scala> import org.apache.spark.sql.types._
import org.apache.spark.sql.types._

scala>  val schema=StructType(Array(
     |     StructField("id", StringType, true),
     |     StructField("name", StringType, true),
     |     StructField("age", IntegerType, true)
     |   ))
schema: org.apache.spark.sql.types.StructType = StructType(StructField(id,StringType,true), StructField(name,StringType,
true), StructField(age,IntegerType,true))

scala>  val df1=spark.createDataFrame(rdd1,schema)
df1: org.apache.spark.sql.DataFrame = [id: string, name: string ... 1 more field]

scala> rdd1.collect
res0: Array[org.apache.spark.sql.Row] = Array([1,zhangsan,20], [2,lisi,29], [3,wangwu,25], [4,zhaoliu,30], [5,tianqi,35]
, [6,jerry,40])

scala> df1.show
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

 */

