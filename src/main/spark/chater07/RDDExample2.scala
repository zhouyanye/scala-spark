package chater07

import org.apache.spark.{SparkConf, SparkContext}
//单值RDD的转换和行动操作
object RDDExample2 {
  def main(args: Array[String]): Unit = {
    // 创建SparkContext对象
    val conf = new SparkConf().setAppName("RDDExample2").setMaster("local[2]")
    val sc = new SparkContext(conf)

    // 读取数据
    val input = sc.textFile("file:///G:\\spark\\spark\\out\\avgTemperature.txt")
    input.collect.foreach(println)

    // 数据预处理，生成键值对RDD形式 (城市名称, 温度)
    val data0 = input.map(
      x => {
        val words = x.split("\t")
        (words(0), words(1).toDouble)
      }
    )
    data0.collect foreach println


    // 停止 SparkContext
    sc.stop()
  }
}
