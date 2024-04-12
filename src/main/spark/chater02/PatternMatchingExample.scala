package chater02

/**
 * @Author： 小周
 * @Date： 2024/1/31 19:52
 * @Describe：
 */
object PatternMatchingExample {
  def main(args: Array[String]): Unit = {
    val day = "Monday"

    // 基本的模式匹配
    val result = day match {
      case "Monday" => "星期一"
      case "Tuesday" => "星期二"
      case "Wednesday" => "星期三"
      case _ => "其他"
    }

    println(s"基本模式匹配结果：$result")

    // 模式匹配中使用变量
    val x: Any = 42
    val description = x match {
      case i: Int => s"是一个整数: $i"
      case s: String => s"是一个字符串: $s"
      case _ => "未知类型"
    }

    println(s"变量模式匹配结果：$description")
  }
}
