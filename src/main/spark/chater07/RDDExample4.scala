package chater07

import org.apache.spark.{SparkConf, SparkContext}
//文件的读取和存储
object RDDExample4 {
  def main(args: Array[String]): Unit = {
    // 创建SparkContext对象
    val conf = new SparkConf().setAppName("RDDExample4").setMaster("local[2]")
    val sc = new SparkContext(conf)

    // 读取数据
    print("正在读取数据...")
    val input = sc.textFile("file:///G:\\spark\\spark\\out\\avgTemperature.txt")
    input.collect.foreach(println) // 打印原始输入数据的每一行


    // 保存结果
    print("正在保存结果...")
    // 假设有一个处理结果 result: RDD[(String, Double)]
    // result.saveAsTextFile("file:///G:\\spark\\spark\\data")

    // 停止 SparkContext
    sc.stop()
  }
}
