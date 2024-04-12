package chater07

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}
//RDD持久化与分区
object RDDExample5 {
  def main(args: Array[String]): Unit = {
    // 创建SparkContext对象
    val conf = new SparkConf().setAppName("RDDExample5").setMaster("local[2]")
    val sc = new SparkContext(conf)

    // 创建RDD
    val rdd = sc.parallelize(Seq(1, 2, 3, 4, 5))

    // 持久化 RDD 到内存
    rdd.persist(StorageLevel.MEMORY_ONLY)

    // 获取 RDD 的分区数
    val partitions = rdd.getNumPartitions
    println(s"RDD 分区数: $partitions")

    // 停止 SparkContext
    sc.stop()
  }
}
