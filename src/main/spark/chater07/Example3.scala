package chater07

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author： 小周
 * @Date： 2024/2/14 20:51
 * @Describe：201
 */
object Example3 {
  def main(args: Array[String]): Unit = {
    // 创建 SparkConf 对象，设置应用名称和运行模式
    val conf = new SparkConf().setAppName("Example3").setMaster("local[2]")
    // 创建 SparkContext 对象
    val sc = new SparkContext(conf)
    // 使用 textFile 方法读取文件创建 RDD
    // 1. 读取文件并创建 RDD
    val input = sc.textFile("file:///G:\\spark\\spark\\out\\examination2019.csv")
    input.take(2).foreach(println)
    // 2. 转换数据 使用 map 方法
    val score = input.map({ x =>
      // 按逗号分割每一行
      val line = x.split(",")
      (line(0), line(1),line(2),line(3))
    })
    score.take(1).foreach(println)
    val drop_score=score.mapPartitionsWithIndex((index,num) =>{
      if(index==0) num.drop(1)
        num
  })
    println("-"*10+"删除首行后的数据" + "-"*10)
    drop_score.take(1).foreach(println)
    val bk_score=drop_score.filter(_._3.contains("本科批"))
    println(bk_score.count())
    bk_score.repartition(1).saveAsTextFile("hdfs://master:8020/out/examination2019")
    sc.stop()
 }

}
