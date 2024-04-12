import org.apache.spark.{SparkConf, SparkContext}

object demo {
  def main(args: Array[String]): Unit = {
    // 创建 SparkConf 对象并设置应用程序的名称和运行模式
    val conf = new SparkConf().setAppName("demo").setMaster("local[2]")
    // 创建 SparkContext 对象
    val sc = new SparkContext(conf)
    // 创建包含两个字符串的列表
    val strlist = List("hello World！", "hello China!")
    // 将列表转换为 RDD
    val rdd1 = sc.makeRDD(strlist)
    // 对 RDD 中的每个字符串进行拆分并扁平化处理
    val rdd2 = rdd1.flatMap(_.split(" "))
    // 对每个单词生成一个键值对，并打印分隔线
    val rdd3 = rdd2.map(item => {
      println("*************")
      (item, 1)
    })
    // 对 rdd3 进行缓存
    rdd3.cache()
    // 对键值对进行聚合操作
    val rrdd = rdd3.reduceByKey(_ + _)
    // 打印聚合结果
    rrdd.collect().foreach(println)
    println()
    // 对键值对进行分组操作
    val grdd = rdd3.groupByKey()
    // 打印分组结果
    grdd.collect().foreach(println)
  }
}
