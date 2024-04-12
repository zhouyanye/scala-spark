package chater07

import org.apache.spark.{SparkConf, SparkContext}

object SparkExample1{
  def main(args: Array[String]): Unit = {
    // 创建Spark配置
    val conf = new SparkConf().setAppName("SparkExample").setMaster("local")
    
    // 创建Spark上下文
    val sc = new SparkContext(conf)

    // 创建包含学生姓名和分数的pairRDD
    val studentScores = sc.parallelize(Seq(
      ("Alice", 80),
      ("Bob", 75),
      ("Alice", 90),
      ("Bob", 85),
      ("Charlie", 95)
    ))

    // 使用combineByKey计算每个学生的总分和考试次数
    val sumCountPairRDD = studentScores.combineByKey(
      (score: Int) => (score, 1),
      (acc: (Int, Int), score: Int) => (acc._1 + score, acc._2 + 1),
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2)
    )

    // 计算每个学生的平均分
    val averageScores = sumCountPairRDD.mapValues { case (totalScore, count) => totalScore / count.toDouble }

    // 打印结果
    println("Average Scores:")
    averageScores.foreach(println)

    // 停止Spark上下文
    sc.stop()
  }
}
