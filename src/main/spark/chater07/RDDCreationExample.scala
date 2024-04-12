package chater07

import org.apache.spark.{SparkConf, SparkContext}

object RDDCreationExample {
  def main(args: Array[String]): Unit = {
    // 1: 创建SparkConf和SparkContext
    val conf = new SparkConf().setAppName("RDDCreationExample").setMaster("local[*]")
    val sc = new SparkContext(conf)

    try {
      // 2: 从外部存储读取数据创建RDD
      val externalFilePath = "file:///G:\\spark\\spark\\out\\avgTemperature.txt"
      val externalDataRDD = sc.textFile(externalFilePath)
      println("External Data RDD:")
      externalDataRDD.take(5).foreach(println)

      // 3: 使用内存已有RDD创建新RDD
      val existingData = List(1, 2, 3, 4, 5)
      val existingDataRDD = sc.parallelize(existingData)
      println("Existing Data RDD:")
      existingDataRDD.collect().foreach(println)

      // 4: 对已有RDD进行转换操作，创建新的RDD
      val squaredRDD = existingDataRDD.map(x => x * x)
      println("Squared RDD:")
      squaredRDD.collect().foreach(println)

      // 5: 外部存储中的数据预处理（示例：将每行字符串拆分为单词）
      val preprocessedRDD = externalDataRDD.flatMap(line => line.split("\\s+"))
      println("Preprocessed RDD:")
      preprocessedRDD.take(5).foreach(println)
    } finally {
      // 6: 关闭SparkContext
      sc.stop()
    }
  }
}
