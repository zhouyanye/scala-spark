package chater07

import org.apache.spark.{SparkConf, SparkContext}
//创建RDD的方法
object RDDExample1 {
  def main(args: Array[String]): Unit = {
    // 创建SparkContext对象
    val conf = new SparkConf().setAppName("RDDExample1").setMaster("local[2]")
    val sc = new SparkContext(conf)

    // 创建RDD
    val rdd1 = sc.makeRDD(Seq(("name", "zs"), ("age", 20)))
    rdd1.collect foreach println

    val rdd2 = sc.makeRDD(Seq((1, 2, 3)))
    rdd2.map((_, 1)).collect foreach println

    val rdd3 = sc.makeRDD(Seq(("name", "张三"), ("sex", "女"), ("age", 20), ("score", 100)))
    rdd3.map((_, 1)).collect foreach println

    val rdd4 = sc.makeRDD(Seq(("name", 1), ("sex", 0), ("age", 20), ("score", 100)))
    val rddWithAddedValues = rdd4.mapValues(_ + 1000)
    rddWithAddedValues.foreach(println)

    val kvRDD = sc.makeRDD(Seq(("apple", 10), ("banana", 20), ("orange", 30)))
    kvRDD.map((x) => (x._1, (x._2, 1))).collect().foreach(println)

    // 停止 SparkContext
    sc.stop()
  }
}
