package chater07

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author： 小周
 * @Date： 2024/1/31 22:22
 * @Describe：
 */
object EmployeeSalaryAnalysis {
  def main(args: Array[String]): Unit = {
    // 创建Spark配置
    val conf = new SparkConf().setAppName("EmployeeSalaryAnalysis").setMaster("local[2]")

    // 创建Spark上下文
    val sc = new SparkContext(conf)
    //加载数据 保存到RDD
    val first_half = sc.textFile("hdfs://master:8020/sparkdata/Employee_salary_first_half.csv")
    val second_half = sc.textFile("hdfs://master:8020/sparkdata/Employee_salary_second_half.csv")

    // 删除首行 如果分区号为0 删除他首行
    val drop_first = first_half.mapPartitionsWithIndex((index, num) => {
      if (index == 0) num.drop(1)
      num
    })
    val drop_second = second_half.mapPartitionsWithIndex((index, num) => {
      if (index == 0) num.drop(1)
      num
    })
    // 调试 取出第一行数据打印输出
    drop_first.take(1).foreach(println)
    drop_second.take(1).foreach(println)
    //获取(员工姓名，上半年薪资)和(员工姓名，上半年薪资)形式的数据集合
    val split_first = drop_first.map(
      line => {
        val data = line.split(",")
        (data(1), data(6).toInt)
      })
    /**
     * 结果将得到一个新的集合，其中每个元素都是一个二元组 (String, Int)，对应原始行中的第二个字段与第六个字段（转换为整数）的组合。
     */
    val split_second = drop_second.map(
      line => {
        val data = line.split(",")
        (data(1), data(6).toInt)
      })
    //调试输出
    println("-" * 10 + "员工姓名,上半年薪资" + "-" * 10)
    split_first.take(2).foreach(println)
    split_second.take(2).foreach(println)

    println("-" * 10 + "全年总薪资" + "-" * 10)
    // 获取(员工,全年总薪资）
    val all_salary = split_first.union(split_second).reduceByKey(_ + _)
    println("-" * 10 + " 员工 全年总薪资" + "-" * 10)
    all_salary.take(1).foreach(println)
    println("-" * 10 + "月均薪资" + "-" * 10)
    // 获取月均薪资
    val avg_salary = all_salary.map(x => (x._1, x._2.toDouble / 12)) // 计算月均薪资之和
    avg_salary.take(1).foreach(println)
    println("*" * 10 + "合并数据")
    //合并数据                  上半年薪资下半年薪资      总薪资       合并  月均薪资
    val total = split_first.join(split_second).join(all_salary).join(avg_salary)
    //    total.take(1).foreach(println) 数据类型
    //res15: Array[(String, (((Int, Int), Int), Double))] = Array((Karl Oconnor,(((61442,67540),128982),10748.5)))
    /*
    *  1. 先把两个RDD合并，得到一个RDD[(String, (Int, Int))], 其中每个元素都是一个二元组 (String, (Int, Int))，对应原始行中的第二个字段与第六个字段（转换为整数）的组合。
    *  2. 然后把合并后的RDD[(String, (Int, Int))]和另一个RDD[(String, Int)]合并，得到一个RDD[(String, ((Int, Int), Int))], 其
    *  3. 然后把RDD[(String, ((Int, Int), Int))]和RDD[(String, Double)]合并，得到一个RDD[(String, ((Int, Int), Int, Double))], 其中每个元素都是一个四元组 (String, ((Int, Int), Int, Double))，
     */
    println("*" * 10 + "合并数据")
    val result = total.map(x =>
      //x._1  员工姓名  x._2._1._1._1 上半年薪资  x._2._1._1._2 下半年薪资  x._2._1._2 总薪资  x._2._2 月均薪资
      Array(x._1,  x._2._1._1._1,  x._2._1._1._2, x._2._1._2, x._2._2).mkString(","))
    //打印输出 查看结果
    result.take(1).foreach(println)
    //保存hdfs 保存一个文件里
    result.repartition(1).saveAsTextFile("hdfs://master:8020/sparkdata/salary_result")

    // 关闭Spark上下文
    sc.stop()
  }
}
