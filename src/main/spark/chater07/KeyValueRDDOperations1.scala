package chater07

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author: 小周
 * @Date: 2024/2/1 16:00
 * @Description: 键值对 RDD 操作示例
 */
object KeyValueRDDOperations1 {
  def main(args: Array[String]): Unit = {
    // 创建 SparkContext
    val conf = new SparkConf().setAppName("KeyValueRDDOperations1").setMaster("local[*]")
    val sc = new SparkContext(conf)

    // 创建一个键值对 RDD
    val rdd1 = sc.parallelize(Seq(("a", 1), ("b", 2), ("c", 3), ("d", 4), ("e", 5), ("f", 6), ("g", 7), ("h", 8), ("i", 9), ("j", 10)))

    // 返回一个只有键的 RDD
    println("Keys")
    rdd1.keys.collect().foreach(println)

    // 返回一个只有值的 RDD
    println("Values")
    rdd1.values.collect().foreach(println)

    // mapValues(func) 针对键值对 (Key, Value) 类型的数据中的 Value 进行 map 操作而不对 Key 进行处理
    println("MapValues")
    rdd1.mapValues(x => (x, 1)).collect().foreach(println)

    // groupByKey() 将相同 Key 的值归并到一起
    println("GroupByKey")
    val rdd2 = sc.parallelize(List("a", "b", "c", "c")).map(x => (x, 1))
    // 统计每个键出现的次数
    rdd2.groupByKey().collect().foreach(println)

    // join() 把键值对数据相同键的值整合起来，join 返回的也是元组，元组中 value 位置返回的是所有单值的集合，其他连接有 leftOuterJoin(), rightOuterJoin(), and fullOuterJoin()
    println("Join")
    val rdd3 = sc.parallelize(Seq(("a", 1), ("b", 2), ("c", 3), ("d", 4), ("e", 5), ("f", 6), ("g", 7), ("h", 8), ("i", 9), ("j", 10)))
    val rdd4 = sc.parallelize(Seq(("a", 1), ("b", 2), ("c", 3), ("d", 4), ("e", 5), ("f", 6), ("g", 7), ("h", 8), ("i", 9), ("j", 10)))
    rdd3.join(rdd4).collect().foreach(println)

    // Zip
    val rdd5 = sc.makeRDD(1 to 5, 2)
    val rdd6 = sc.makeRDD(Seq("A", "B", "C", "D", "E"), 2)

    // Zip 操作
    println("Zip")
    rdd5.zip(rdd6).collect().foreach(println)

    // 反向 Zip 操作
    println("Zip 反向")
    rdd6.zip(rdd5).collect().foreach(println)

    // combineByKey() 返回形式 RDD [String, (Int, Int)] 其元素形式是 (键, (值，键出现次数))
    println("CombineByKey")
    val rdd7 = sc.parallelize(Seq(("a", 1), ("b", 2), ("a", 3), ("b", 4), ("c", 5), ("a", 6)))

    // 使用 combineByKey 操作，计算每个键的平均值和键出现的次数
    val combinedRDD = rdd7.combineByKey(
      (value: Int) => (value, 1),                      // createCombiner: 初始组合器，将值转换为期望的组合器格式
      (acc: (Int, Int), value: Int) => (acc._1 + value, acc._2 + 1),   // mergeValue: 将新值合并到组合器
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2)   // mergeCombiners: 合并两个组合器
    )

    combinedRDD.collect().foreach(println)

    // lookup(Key: K) 返回一个值的 RDD，返回的 RDD 中的元素是 (键, 值)，如果键不存在则返回空 RDD
    println("Lookup")
    val rdd8 = sc.parallelize(Seq(("a", 1), ("b", 2), ("c", 3), ("d", 4), ("e", 5)))

    // 使用 lookup 操作，查找指定键的值
    val lookupResult = rdd8.lookup("b")
    println(s"Key 'b' 的值为: $lookupResult")


    // 关闭 SparkContext
    sc.stop()
  }
}
