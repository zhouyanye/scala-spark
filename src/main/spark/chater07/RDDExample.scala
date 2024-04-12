package chater07
object  RDDExample {
  def main(args: Array[String]): Unit = {
    // 导入 Spark 相关库
    import org.apache.spark.{SparkConf, SparkContext}

    // 创建 SparkConf 和 SparkContext
    val conf = new SparkConf().setAppName("RDDExample").setMaster("local")
    val sc = new SparkContext(conf)

    // 创建一个包含 1 到 10 的整数的 RDD
    val data = 1 to 10
    val rdd = sc.parallelize(data)

    // 对 RDD 进行一些操作，筛选出偶数并计算它们的平方
    val result = rdd.filter(_ % 2 == 0).map(x => x * x)

    // 打印结果
    result.foreach(println)

    // 停止 SparkContext
    sc.stop()
  }
}
