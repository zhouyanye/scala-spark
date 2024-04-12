package chater07

import org.apache.spark.{SparkConf, SparkContext}

import java.nio.file.{Files, Paths}
import scala.io.Source
/**
 * @Author： 小周
 * @Date： 2024/2/8 17:33
 * @Describe：
 */
object ObjectExample1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ObjectExample1").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5))
    rdd.foreach(println)
    rdd.saveAsObjectFile("/out/obj_out")
    val obj = sc.objectFile[Int]("/out/obj_out")
    obj.foreach(println)

  }
}
