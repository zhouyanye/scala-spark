package chater02

/**
 * @Author： 小周
 * @Date： 2024/1/31 19:59
 * @Describe：
 */
object PrintEvenNumbers {
  def main(args: Array[String]): Unit = {
    println("1 到 10 的偶数：")
    for (i <- 1 to 10 if i % 2 == 0) {
      println(i)
    }
  }
}