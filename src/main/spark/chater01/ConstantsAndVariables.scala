package chater01

/**
 * @Author： 小周
 * @Date： 2024/1/31 17:45
 * @Describe：
 */

object ConstantsAndVariables {
  // 定义常量
  val PI: Double = 3.14159

  // 定义变量
  var counter: Int = 0

  def main(args: Array[String]): Unit = {
    // 打印常量
    println(s"PI: $PI")

    // 修改变量值
    counter += 1
    println(s"Counter after increment: $counter")
  }
}
