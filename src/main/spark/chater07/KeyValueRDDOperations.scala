package chater07

import org.apache.spark.{SparkConf, SparkContext}

object KeyValueRDDOperations {
  def main(args: Array[String]): Unit = {
    // 创建SparkContext
    val conf = new SparkConf().setAppName("KeyValueRDDOperations").setMaster("local[*]")
    val sc = new SparkContext(conf)

    // 创建键值对RDD的方法
    val data = List(("Alice", 25), ("Bob", 30), ("Alice", 35), ("Bob", 20))
    val keyValueRDD = sc.parallelize(data)

    // 使用键值对RDD的keys和values方法
    val keys = keyValueRDD.keys
    val values = keyValueRDD.values

    println("Keys:")
    keys.collect().foreach(println)

    println("Values:")
    values.collect().foreach(println)

    // 使用reduceByKey方法
    val reducedByKey = keyValueRDD.reduceByKey(_ + _)

    println("Reduce by key:")
    reducedByKey.collect().foreach(println)

    // 使用groupByKey方法
    val groupedByKey = keyValueRDD.groupByKey()

    println("Group by key:")
    groupedByKey.collect().foreach { case (key, values) =>
      println(s"$key: ${values.mkString(", ")}")
    }

    // 创建第二个键值对RDD
    val otherData = List(("Alice", "HR"), ("Bob", "IT"))
    val otherKeyValueRDD = sc.parallelize(otherData)

    // 使用join方法连接两个RDD
    val joinedRDD = keyValueRDD.join(otherKeyValueRDD)

    println("Join:")
    joinedRDD.collect().foreach { case (key, (value1, value2)) =>
      println(s"$key: $value1, $value2")
    }

    // 使用zipWithIndex方法添加索引
    val indexedRDD1 = keyValueRDD.zipWithIndex().map { case ((key, value), index) => (index, (key, value))}
    val indexedRDD2 = otherKeyValueRDD.zipWithIndex().map { case ((key, value), index) => (index, (key, value))}

    // 使用join方法连接两个索引RDD
    val zippedRDD = indexedRDD1.join(indexedRDD2).map { case (index, ((key1, value1), (key2, value2))) =>
      (key1, value1, key2, value2)
    }

    println("Zip:")
    zippedRDD.collect().foreach(println)

    // 使用combineByKey方法合并相同键的值
    val combinedByKey = keyValueRDD.combineByKey(
      (value: Int) => (value, 1),
      (acc: (Int, Int), value: Int) => (acc._1 + value, acc._2 + 1),
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2)
    )

    println("Combine by key:")
    combinedByKey.collect().foreach { case (key, (sum, count)) =>
      val average = sum.toDouble / count
      println(s"$key: Average=$average")
    }

    // 使用lookup方法查找指定键的值
    val lookupValue = keyValueRDD.lookup("Alice")

    println("Lookup:")
    lookupValue.foreach(println)

    // 关闭SparkContext
    sc.stop()
  }
}
