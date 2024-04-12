package chater07

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author： 小周
 * @Date： 2024/1/31 22:21
 * @Describe：
 */
object RDDExample6 {
  def main(args: Array[String]): Unit = {
    // 1:创建SparkContext
    val conf = new SparkConf().setAppName("RDDExample6").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)

    // 2:使用parallelize创建RDD
    // parallelize[T: ClassTag](seq: Seq[T], numSlices: Int = defaultParallelism): RDD[T]
    /**
     * 查看RDD分区数 rdd变量.partitions.size
     * 查看RDD数据分布情况 rdd变量.glom.collect
     * 查看默认分区数 sc.defaultParallelism
     * 设置默认分区数 spark.defaultParallelism = num
     */
    // 创建一个包含1, 2, 3的RDD，如果未指定分区数，默认分区数等于CPU核心数
    val rdd1: RDD[Int] = sc.parallelize(List(1, 2, 3))
    rdd1.collect.foreach(println)

    /**从内存中已有的Seq集合创建RDD
     *通过preferredLocations可以根据位置信息查看每一个分区的值
     * 该函数的Seq集合元素必须是String
     * 调用makeRDD时候不可以直接指定RDD的分区个数 分区个数与Seq[String]的个数是保持一致的
     */

    // 3:使用makeRDD创建RDD
    // makeRDD[T: ClassTag](seq: Seq[T], numSlices: Int): RDD[T]
    // 创建一个包含1, 2, 3, 4, 5的RDD，指定分区数为6
    val rdd2 = sc.makeRDD(List(1, 2, 3, 4, 5), 6)
    rdd2.collect.foreach(println)
    println(s"rdd2的分区数: ${rdd2.partitions.size}")

    // 4:关于rdd3的一些说明
    val rdd3 = sc.makeRDD(Seq(
      (1, Seq("1", "张三", "290")),
      (2, Seq("2", "李四", "295")),
      (3, Seq("3", "王五", "298"))
    ))
    println(s"rdd3的分区数: ${rdd3.partitions.size}")
    println("rdd3每个分区上的数据分布：")
    for (i <- 0 to 2)
      println(s"分区号$i:${rdd3.preferredLocations(rdd3.partitions(i))}")

    // 5:flatMap和mapPartitionsWithIndex的使用示例
    val rdd4 = sc.makeRDD(List("a", "b", "c"))
    val rdd5: RDD[(Int, String)] = rdd4.mapPartitionsWithIndex(
      (index, num) => num.map((index, _))
    )
    rdd5.foreach(println)
    println("-" * 20)

    // 6:修改RDD元素的值示例
    // 创建包含任意10个整数的RDD，分为3个分区
    val rdd6 = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
    // 使用map操作，如果元素大于7，则加100
    val modifiedRDD = rdd6.map(x => if (x > 7) x + 100 else x)
    modifiedRDD.collect().foreach(println)
    println(s"rdd6的分区数: ${rdd6.partitions.size}")

    // 7:关闭SparkContext
    sc.stop()
  }
}
