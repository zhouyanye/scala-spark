package chater07

import org.apache.spark.{SparkConf, SparkContext}

object EmployeeSalaryAnalysis_1{
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("EmployeeSalaryAnalysis_1").setMaster("local[2]")
    val sc = new SparkContext(conf)

    // 读取两个CSV文件并删除首行
    val drop_first = sc.textFile("file:///G:\\spark\\spark\\out\\Employee_salary_first_half.csv")
      .zipWithIndex()
      .filter { case (_, index) => index > 0 }
      .filter { case (line, _) => line.split(",")(6).toDouble > 200000 }
      .map { case (line, _) => line.split(",")(1) }

    val drop_second = sc.textFile("file:///G:\\spark\\spark\\out\\Employee_salary_second_half.csv")
      .zipWithIndex()
      .filter { case (_, index) => index > 0 }
      .filter { case (line, _) => line.split(",")(6).toDouble > 200000 }
      .map { case (line, _) => line.split(",")(1) }

    // 合并两个RDD的员工姓名并去重
    val uniqueNames = drop_first.union(drop_second).distinct()

    // 打印结果
    println("上半年和下半年实际薪资大于20万元的员工姓名：")
    uniqueNames.foreach(println)

    // 关闭SparkContext
    sc.stop()
  }
}
