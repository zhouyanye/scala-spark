package chater07

import org.apache.spark.{SparkConf, SparkContext}
//键值对RDD的转换和行动操作
object RDDExample3 {
  def main(args: Array[String]): Unit = {
    // 创建SparkContext对象
    val conf = new SparkConf().setAppName("RDDExample3").setMaster("local[2]")
    val sc = new SparkContext(conf)

    val rdd5 = sc.makeRDD(Seq(("a", "1"), ("b", "2"), ("c", "3"), ("d", "4"), ("e", "5")))
    // 1. 收集并打印RDD5的所有元素。
    rdd5.collect() foreach println

    // 2. 按键分组后收集并打印所有数据，每行展示一个键及其对应的值集合。
    rdd5.groupBy(_._1).collect.foreach(println)

    // 3. 对键值对RDD按键进行分组，并收集所有分组结果，打印每个键及其对应的值序列。
    rdd5.groupByKey.collect foreach println

    // 4. 先按键分组，然后对每个键的值求和，最后收集并打印每个键及其对应的总和。
    rdd5.groupByKey.mapValues(_.reduce((_ + _))).collect() foreach println

    // 5. 按键对RDD的值进行加法求和，然后收集并打印每个键及其对应的总和。
    rdd5.reduceByKey(_ + _).collect foreach println

    // 停止 SparkContext
    sc.stop()
  }
}
