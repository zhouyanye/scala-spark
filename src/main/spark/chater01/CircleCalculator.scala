package chater01

/**
 * @Author： 小周
 * @Date： 2024/1/31 20:29
 * @Describe：
 */
object CircleCalculator {
  def main(args: Array[String]): Unit = {
    println("请选择要计算的内容：")
    println("1. 输入半径，计算周长和面积")
    println("2. 输入周长，计算半径和面积")
    println("3. 输入面积，计算半径和周长")

    val choice = scala.io.StdIn.readInt()
    val Pi = 3.14

    if (choice == 1) {
      val radius = scala.io.StdIn.readDouble()
      val circumference = 2 * Pi * radius
      val area = Pi * radius * radius
      println(s"周长为: $circumference, 面积为: $area")
    } else if (choice == 2) {
      val circumference = scala.io.StdIn.readDouble()
      val radius = circumference / (2 * Pi)
      val area = Pi * radius * radius
      println(s"半径为: $radius, 面积为: $area")
    } else if (choice == 3) {
      val area = scala.io.StdIn.readDouble()
      val radius = math.sqrt(area / Pi)
      val circumference = 2 * Pi * radius
      println(s"半径为: $radius, 周长为: $circumference")
    } else {
      println("无效选择")
    }
  }
}
