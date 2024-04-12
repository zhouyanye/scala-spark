package chater08

import org.apache.spark.{SparkConf, SparkContext}

object yy {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Score Statistics").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val lines = sc.textFile("/sparkdatas/examination2019.csv")
      .filter(!_.contains("分数线"))
    // 查询本科批的分数线
    val filteredData = lines
      .map(f => {
        val x = f.split(",")
        (x(1), x(1), x(2), x(3).toInt)
      })
      .filter(data => data._3 == "专科批" || data._3 == "本科一批" || data._3 == "本科二批")
      .filter(data => data._1 == "文科" || data._1 == "理科" )
    // 按照科类和批次分组，并计算平均分数
    val result = filteredData
      .groupBy(data => (data._1, data._3))
      .mapValues(values => {
        val scores = values.map(_._4)
        val avgScore = scores.sum.toDouble / scores.size
        avgScore
      })
    // 将统计结果输出到文件中
    result.map(data => s"${data._1._1} ${data._1._2}: ${data._2}")
      .repartition(1)
      .saveAsTextFile("/score_statistics")

    sc.stop()
  }
}
