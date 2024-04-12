package chater03

/**
 * @Author： 小周
 * @Date： 2024/1/31 20:20
 * @Describe：
 */
object FibonacciExample {
  def main(args: Array[String]): Unit = {
    // 计算斐波那契数列前5项
    val fibonacciSequence = fibonacci(5)

    // 去除重复项
    val distinctFibonacci = fibonacciSequence.distinct

    // 计算各项之和
    val sum = distinctFibonacci.sum

    // 打印结果
    println(s"斐波那契数列前5项：${fibonacciSequence.mkString(", ")}")
    println(s"去除重复项后：${distinctFibonacci.mkString(", ")}")
    println(s"各项之和：$sum")
  }

  // 计算斐波那契数列
  def fibonacci(n: Int): List[Int] = {
    if (n <= 0) List(0)
    else if (n == 1) List(0, 1)
    else {
      val fibList = scala.collection.mutable.ListBuffer(0, 1)

      for (i <- 2 until n) {
        val nextFib = fibList(i - 1) + fibList(i - 2)
        fibList += nextFib
      }

      fibList.toList
    }
  }
}
