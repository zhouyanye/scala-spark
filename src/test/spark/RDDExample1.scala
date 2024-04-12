import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author： 小周
 * @Date： 2024/1/31 22:18
 * @Describe：
 */
object RDDExample1 {
  def main(args: Array[String]): Unit = {
    // 1. 创建SparkContext对象
    val conf = new SparkConf().setAppName("RDDExample1").setMaster("local[2]")
    val sc = new SparkContext(conf)

    // 2. 创建RDD的方法
    // 2.1 直接创建键值对RDD
    //    val rdd1 = sc.makeRDD(Seq(("name", "zs"), ("age", 20)))
    //    rdd1.collect.foreach(println)

    // 2.2 通过已有RDD转换键值对RDD
    val rdd2 = sc.makeRDD(Seq((1, 2, 3)))
    rdd2.map((_, 1)).collect.foreach(println)

    // 3. 习题
    val rdd3 = sc.makeRDD(Seq(("name", "张三"), ("sex", "女"), ("age", 20), ("score", 100)))
    rdd3.map((_, 1)).collect.foreach(println)

    // 4. 习题: 创建一个键值对RDD
    val rdd4 = sc.makeRDD(Seq(("name", 1), ("sex", 0), ("age", 20), ("score", 100)))
    // 每个值加1000 并且显示RDD的内容
    // rdd4.values.map(_ + 1000).collect().foreach(println)
    // mapValues映射值
    val rddWithAddedValues = rdd4.mapValues(_ + 1000)
    rddWithAddedValues.foreach(println)

    // 5. 元组操作
    val kvRDD = sc.makeRDD(Seq(("apple", 10), ("banana", 20), ("orange", 30)))
    kvRDD.map(x => (x._1, (x._2, 1))).collect().foreach(println)

    // 6. 常用方法: keys, values
    // mapValues, map 映射
    // 分组 groupByKey, groupBy
    val rdd5 = sc.makeRDD(Seq(("a", "1"), ("b", "2"), ("c", "3"), ("d", "4"), ("e", "5")))
    rdd5.collect() foreach println
    rdd5.groupBy(_._1).collect.foreach(println)
    rdd5.groupByKey.collect foreach println
    // 分组求和 reduce
    rdd5.groupByKey.mapValues(_.reduce((_ + _))).collect() foreach println
    rdd5.reduceByKey(_ + _).collect foreach println

    // 7. 习题: 读取数据
    print("正在读取数据")
    val input = sc.textFile("file:///G:\\spark\\spark\\avgTemperature.txt")
    input.collect.foreach(println) // 打印原始输入数据的每一行
    // 数据预处理，生成键值对RDD形式 (城市名称, 温度)
    val data0: RDD[(String, Double)] = input.map(
      x => {
        val words = x.split("\t")
        (words(0), words(1).toDouble)
      }
    )
    data0.collect foreach println // 打印处理后的键值对数据

    // 8. TOOD: join 合并
    val rdd6 = sc.makeRDD(Seq(("a", 1), ("b", 2), ("c", 3)))
    val rdd7 = sc.makeRDD(Seq(("a", 1), ("d", 2), ("c", 3)))
    rdd6.join(rdd7).collect.foreach(println)

    // 9. combineByKey方法用于将键相同的数据聚合，并且允许返回类型与输入数据的类型不同的返回值。
    // combineByKey()
    // 使用combineByKey()求按键分组求平均数
    val rdd1 = sc.makeRDD(Seq(("a", 1), ("b", 2), ("a", 10), ("b", 2), ("a", 3), ("b", 12)))
    val data = rdd1.combineByKey(
      v => (v, 1),
      (c: (Int, Int), v) => (c._1 + v, c._2 + 1),
      (c1: (Int, Int), c2: (Int, Int)) => (c1._1 + c2._1, c1._2 + c2._2)
    )
    data.collect foreach println
    data.mapValues(x => x._1 / x._2).collect foreach println
    //10. zip 组合
    val rdd8 = sc.makeRDD(List(("a", "b")))
    val rdd9 = sc.makeRDD(List(("c", "d")))
    rdd8.zip(rdd9).collect.foreach(println)
  }
}