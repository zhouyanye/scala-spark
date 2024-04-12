package chater06

//import scala.language.implicitConversions

object ImplicitConversionExample {
  def main(args: Array[String]): Unit = {
    val intNumber = 42
    val doubleNumber = 3.14

    // 使用隐式转换，将整数类型转换为浮点数类型
    val result: Double = intNumber + doubleNumber

    println(s"Result: $result")
  }

  // 定义一个隐式转换，将整数类型转换为浮点数类型
  implicit def intToDouble(value: Int): Double = value.toDouble
}
