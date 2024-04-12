package chater07

import org.apache.spark.{SparkConf, SparkContext}

object SparkExample {
  def main(args: Array[String]): Unit = {
    // 创建Spark配置
    val conf = new SparkConf().setAppName("SparkExample").setMaster("local")
    
    // 创建Spark上下文
    val sc = new SparkContext(conf)

    // 创建一个包含1到10的整数的RDD，分成两个分区
    val rdd = sc.makeRDD(1 to 10, 2)

    // 打印RDD的内容
    println("makeRDD Example:")
    rdd.foreach(println)

    // 创建一个包含键值对的RDD
    val pairRDD = sc.parallelize(Seq(("a", 1), ("b", 2), ("a", 3), ("b", 4)))

    // 对具有相同键的值进行求和
    val sumByKey = pairRDD.reduceByKey(_ + _)

    // 打印结果
    println("\npairRDD Example:")
    sumByKey.foreach(println)

    // 停止Spark上下文
    sc.stop()
  }
}
