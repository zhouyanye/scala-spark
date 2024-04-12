import org.apache.spark.{SparkConf, SparkContext}

object ReadFileExample {
  def main(args: Array[String]): Unit = {
    // 1: 创建SparkConf和SparkContext
    val conf = new SparkConf().setAppName("ReadFileExample").setMaster("local[*]")
    val sc = new SparkContext(conf)

    try {
      // 2: 读取文件路径
      val filePath = "file:///G:\\spark\\spark\\out\\user.txt"

      // 3: 使用SparkContext的textFile方法读取文本文件
      val textRDD = sc.textFile(filePath)

      // 4: 对读取的数据进行一些操作，例如打印前几行
      textRDD.take(5).foreach(println)
    } finally {
      // 5: 关闭SparkContext
      sc.stop()
    }
  }
}
