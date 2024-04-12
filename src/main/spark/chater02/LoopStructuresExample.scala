package chater02

/**
 * @Author： 小周
 * @Date： 2024/1/31 19:51
 * @Describe：
 */
object LoopStructuresExample {
  def main(args: Array[String]): Unit = {
    // while 循环
    var i = 0
    while (i < 5) {
      println(s"while 循环：$i")
      i += 1
    }

    // for 循环
    for (j <- 0 until 5) {
      println(s"for 循环：$j")
    }

    // for 循环的高级用法（使用 yield）
    val squares = for (k <- 1 to 5) yield k * k
    println(s"for 循环高级用法：${squares.mkString("[", ", ", "]")}")
  }
}
