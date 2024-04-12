package chater07

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author： 小周
 * @Date： 2024/2/1 13:48
 * @Describe：
 */
object EmployeeSalaryAnalysis_First {
  def main(args: Array[String]): Unit = {
    // 创建SparkContext
    val conf = new SparkConf().setAppName("EmployeeSalaryAnalysis_First").setMaster("local[*]")
    val sc = new SparkContext(conf)

    // 读取文件
    val input = sc.textFile("file:///G:\\spark\\spark\\out\\Employee_salary_first_half.csv")

    // 删除第一行字段名
//    val dataWithoutHeader = input.mapPartitionsWithIndex { (index, iterator) =>
//      if (index == 0 && iterator.hasNext) {
//        iterator.next()
//        iterator
//      } else {
//        iterator
//      }
//    }
val dataWithoutHeader = input.mapPartitionsWithIndex((index, num) => {
  if (index == 0) num.drop(1)
  num
})

    // 分割数据，提取需要的列，并转换数据类型
    val processedData = dataWithoutHeader.map { line =>
      val fields = line.split(",")
      val employeeId = fields(0).toInt
      val employeeName = fields(1)
      val actualSalary = fields(6).toInt
      (employeeId, employeeName, actualSalary)
    }
    //processedData.collect().foreach(println)

    // 按实际薪资降序排序
    //val sortedData = processedData.sortBy(x => x._3, ascending = false)
    val sortedData = processedData.sortBy { case (_, _, actualSalary) => -actualSalary }

    // 获取上半年实际薪资排名前三的员工信息
    val topThreeEmployees = sortedData.take(3)

    // 打印结果
    topThreeEmployees.foreach(println)

    // 关闭SparkContext
    sc.stop()
  }
}
