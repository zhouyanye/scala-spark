package chater07

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author： 小周
 * @Date： 2024/1/31 22:22
 * @Describe：
 */
object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)
    System.setProperty("hadoop.home.dir", "F:\\hadoop\\hadoop-3.1.4")
    val input = "file:///G:\\spark\\spark\\out\\avgTemperature.txt"
    val count = sc.textFile(input).flatMap(
      x => x.split(" ")).map(x => (x, 1)).reduceByKey((x, y) => x + y)
    count.foreach(x => println(x._1 + "," + x._2)
    )
  }
}
