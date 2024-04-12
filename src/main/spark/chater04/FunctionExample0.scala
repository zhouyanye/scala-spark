package chater04

object FunctionExample0 {
  def main(args: Array[String]): Unit = {
    val numbers = Array(1, 2, 3, 4, 5, 6)
    val average = avg(numbers)
    println("平均值是:"+average)
  }
  def avg(numbers: Array[Int]): Double = {
    if (numbers.isEmpty) {
      println("数组不能为空")
    }
    val sum = numbers.sum//toDouble一个整数转换为浮点数的sum的
    sum.toDouble / numbers.length
  }
}
