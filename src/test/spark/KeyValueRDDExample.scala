import org.apache.spark.{SparkConf, SparkContext}

object KeyValueRDDExample {
  def main(args: Array[String]): Unit = {
    // 创建Spark配置
    val conf = new SparkConf().setAppName("KeyValueRDDExample").setMaster("local[2]")

    // 创建Spark上下文，修改默认分区数为6
    val sc = new SparkContext(conf.set("spark.default.parallelism", "6"))

    // 定义一个键值对RDD，类型为[String, Int]
    val data = List(("A", 1), ("B", 2), ("C", 3), ("D", 4))
    val kvRDD = sc.parallelize(data)

    // 将RDD的每一个值都加上1000
    val transformedRDD = kvRDD.mapValues(value => value + 1000)

    // 显示转换后的RDD内容
    transformedRDD.collect().foreach(println)

    // 关闭Spark上下文
    sc.stop()
  }
}
