package chater08

import org.apache.spark.sql.SparkSession


/**
 * @Author： 小周
 * @Date： 2024/3/28 8:58
 * @Describe：RDD转换DataFrame 使用反射机制
 */


case class Peoples(no:String,name:String,age:Int)

object RDDToDataFrameTest {

  def main(args: Array[String]): Unit = {
    //0:创建SparkSession环境
    val spark = SparkSession.builder().appName("RDDToDataFrameTest").master("local[2]").getOrCreate()

    val sc = spark.sparkContext
    //1:从HDFAS上读取people.txt，并且创建dataFrame对象。
    //    val peopleDF = spark.read.text("/data/people.txt")
    //    peopleDF.show
    //RDD转换位DataFrame 方法1：使用反射机制
    val people = sc.textFile("/sparkdatas/people.txt")
    val peopleRDD = people.map{  line =>
      val words = line.split(" ")
      Peoples(words(0),words(1),words(2).toInt)
    }
    import spark.implicits._
    val peopleDF = peopleRDD.toDF()
    peopleDF.show()

  }
}
