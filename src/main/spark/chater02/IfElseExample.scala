package chater02

/**
 * @Author： 小周
 * @Date： 2024/1/31 19:49
 * @Describe：
 */
object IfElseExample {
  def main(args: Array[String]): Unit = {
    val x = 10

    // 基本的 if-else 表达式
    if (x > 5) {
      println("x 大于 5")
    } else {
      println("x 小于等于 5")
    }

    // 多重条件
    val grade = 85
    val result = if (grade >= 90) "优秀"
    else if (grade >= 80) "良好"
    else if (grade >= 70) "一般"
    else "不及格"

    println(s"成绩评级：$result")

    // 三元运算符
    val data = if (x >= 5) "大于 5" else "小于等于 5"
    println(data)
  }
}
