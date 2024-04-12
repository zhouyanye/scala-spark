package chater01

/**
 * @Author： 小周
 * @Date： 2024/1/31 17:52
 * @Describe：使用算术运算符来进行计算,计算圆的周长和面积，根据周长计算半径和面积，以及根据面积计算半径和周长的功能：
 */
import scala.io.StdIn

object CircleCalculations {
  val pi: Double = 3.14

  def main(args: Array[String]): Unit = {
    // 输入圆的半径
    println("请输入圆的半径：")
    val radius: Double = StdIn.readDouble()

    // 计算周长和面积
    val circumference: Double = 2 * pi * radius
    val area: Double = pi * radius * radius

    println(s"圆的周长为：$circumference")
    println(s"圆的面积为：$area")

    // 输入圆的周长
    println("请输入圆的周长：")
    val inputCircumference: Double = StdIn.readDouble()

    // 计算半径和面积
    val calculatedRadius: Double = inputCircumference / (2 * pi)
    val calculatedArea: Double = pi * calculatedRadius * calculatedRadius

    println(s"根据输入的周长计算得到的半径为：$calculatedRadius")
    println(s"对应的面积为：$calculatedArea")

    // 输入圆的面积
    println("请输入圆的面积：")
    val inputArea: Double = StdIn.readDouble()

    // 计算半径和周长
    val calculatedRadiusFromArea: Double = Math.sqrt(inputArea / pi)
    val calculatedCircumferenceFromArea: Double = 2 * pi * calculatedRadiusFromArea

    println(s"根据输入的面积计算得到的半径为：$calculatedRadiusFromArea")
    println(s"对应的周长为：$calculatedCircumferenceFromArea")
  }
}