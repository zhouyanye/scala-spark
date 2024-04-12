package chater04

object objectExample4 {
  def main(args: Array[String]): Unit = {
    val result1 = sum(1.0, 2.0, 3.0)
    println(s"和为: $result1") // 输出: 和为: 6.0
  }
  def sum(numbers: Double*): Double = {
    numbers.sum
  }
}
