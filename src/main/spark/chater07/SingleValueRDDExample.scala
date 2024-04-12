package chater07

import org.apache.spark.{SparkConf, SparkContext}

object SingleValueRDDExample {
  def main(args: Array[String]): Unit = {
    // 1: 创建SparkConf和SparkContext
    val conf = new SparkConf().setAppName("SingleValueRDDExample").setMaster("local[*]")
    val sc = new SparkContext(conf)

      // 2: 创建单值RDD
      val singleValueRDD = sc.parallelize(Seq(5))

      // 3: flatMap()方法转换数据
      val flatMapRDD = singleValueRDD.flatMap(value => Seq(value - 1, value, value + 1))
      println("flatMap() Result:")
      flatMapRDD.collect().foreach(println)

      // 4: sortBy()方法进行排序
      val sortByRDD = flatMapRDD.sortBy(identity)
      println("sortBy() Result:")
      sortByRDD.collect().foreach(println)

      // 5: take()方法查询某几个值
      val takeResult = sortByRDD.take(3)
      println(s"take(3) Result: ${takeResult.mkString(", ")}")

      // 6: union()方法合并多个RDD
      val anotherRDD = sc.parallelize(Seq(10, 20, 30))
      val unionResult = sortByRDD.union(anotherRDD)
      println("union() Result:")
      unionResult.collect().foreach(println)

      // 7: filter()方法过滤数据
      val filterResult = unionResult.filter(value => value % 2 == 0)
      println("filter() Result:")
      filterResult.collect().foreach(println)

      // 8: distinct()方法去重
      val distinctResult = unionResult.distinct()
      println("distinct() Result:")
      distinctResult.collect().foreach(println)

      // 9: 简单的集合操作
      val sum = distinctResult.reduce((a, b) => a + b)
      println(s"Sum of distinct values: $sum")

      // 10: 关闭SparkContext
      sc.stop()

  }
}
