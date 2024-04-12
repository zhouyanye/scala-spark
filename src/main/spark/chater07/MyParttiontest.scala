package chater07

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author： 小周
 * @Date： 2024/1/31 22:22
 * @Describe：
 */
object MyParttiontest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MyParttionTest").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //val input = sc.textFile("hdfs://master:8020/user.txt")
    //val input=sc.textFile("file:///G:\\spark\\spark\\user.txt")
    val input = sc.textFile("/user.txt")
    input.collect foreach println
    val data1 = input.map(line => {
      val data0 = line.split(",")
      (data0(0), data0(1))
    })
    data1.collect foreach println
    data1.partitionBy(new MyParttion(2)).saveAsTextFile("/mpt_output")
  }
}
