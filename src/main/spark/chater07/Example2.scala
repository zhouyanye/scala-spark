package chater07

import org.apache.spark.{SparkConf, SparkContext}
/**
 * @Author： 小周
 * @Date： 2024/2/9 17:46
 * @Describe：spark变成计算个城市的平均气温
 */
object Example2 {
  def main(args: Array[String]): Unit = {
    // 创建 SparkConf 对象，设置应用名称和运行模式
    val conf = new SparkConf().setAppName("Example2").setMaster("local[2]")
    // 创建 SparkContext 对象
    val sc = new SparkContext(conf)

    // 使用 textFile 方法读取文件创建 RDD
    // 1. 读取文件并创建 RDD
    val input = sc.textFile("file:///G:\\spark\\spark\\out\\avgTemperature.txt")
    input.take(2).foreach(println)

    // 2. 转换数据 使用 map 方法
    val data = input.map({ x =>
      // 按制表符分割每一行
      val line = x.split("\\t")
      // 创建元组 (城市, 温度)
      (line(0), line(1).toDouble)
    })
    data.take(3).foreach(println)

    // 3. 过滤控制
    val filter_data = data.filter(x => x._1 != "")
    // 打印过滤空值后的结果的数量
    println("-"*10 + "过滤空值后的结果" + "-"*10, filter_data.count())

    // 4. 分组
    // 使用 groupBy 方法按照城市分组，得到每个城市对应的所有温度
    val res_data = filter_data.mapValues(x => (x, 1))
    res_data.take(3).foreach(println)

    val grp_data = res_data.groupBy(x => x._1)
    // 打印一组数据，以确保分组操作正确
    grp_data.take(1).foreach(println)

    // 5. 聚合
    val res14 = grp_data.mapValues(group => {
      // 使用 reduce 聚合每个组中的元素
      group.reduce((accumulated, current) => {
        // 计算总温度和总计数
        val sum = accumulated._2._1 + current._2._1
        val count = accumulated._2._2 + current._2._2
        // 返回聚合后的元组 (城市, (总温度, 总计数))
        (accumulated._1, (sum, count))
      })
    })

    // 打印聚合后的结果
    res14.take(1).foreach(println)

    // 6. 计算平均温度
    val avgTemperatures = res14.mapValues(x => {
      // 计算平均温度
      val avg = (x._2._1.toDouble / x._2._2).formatted("%.2f").toDouble
      // 返回元组 (城市, 平均温度)
      (x._1, avg)
    })

    // 打印每个城市的平均温度
    avgTemperatures.collect().foreach(println)
  }
}
