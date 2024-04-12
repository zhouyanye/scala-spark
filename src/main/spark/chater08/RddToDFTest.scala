package chater08

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}




case class  People1(stu_no:String, stu_name:String, stu_age:Int)


object RddToDFTest {
  def main(array: Array[String]):Unit = {
    //0:创建SparkSession运行环境
    val spark = SparkSession.builder().appName("RddToDFTest").master("local[2]").enableHiveSupport().getOrCreate()
    val sc = spark.sparkContext

    import spark.implicits._
    //RDD TO DataFrame
    //方法1： 构建一个样例类，将RDD的元素转换为case类类型。调用toDF转换。 适用于预先已经知道数据结构的文件
    //1:读取HDFS上的people.txt
    //    val text = sc.textFile("/data/people.txt")
    //    val text2 = text.map{ line =>                           //01 zs 20
    //      val words = line.split(" ")
    //      People1(words(0), words(1), words(2).toInt)
    //    }
    //    val peopleDF = text2.toDF
    //    peopleDF.show

    //方法2: 使用接口方式，实现RDD 转换为DataFrame
    //1。创建一个schema
    val schema1 = StructType(Seq(StructField("stu_no", StringType, true),
      StructField("stu_name", StringType, true),
      StructField("stu_age", IntegerType, true)))
    //2.创建一个RDD[Row] 对象
    val text = sc.textFile(path ="/sparkdatas/people.txt") //rdd [String]
//RDD转换为DataFrame 使用接口编程方式 1.创建一个schema 2.创建一个RDD[Row] 3.使用createDataFrame创建DataFrame RDD[Row]+schema => DataFrame
    val text2 = text.map { line => //  rdd[Row] 01 ZS 20
      val words = line.split(" ")
      Row(words(0),words(1), words(2).toInt)
    }
    //3: 使用createDataFrame创建DataFrame
    val peopleDF = spark.createDataFrame(text2, schema1)
    peopleDF.show


  }
}