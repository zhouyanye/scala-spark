package chater05

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:50
 * @Describe：
 */
object LambaExample {
  def main(args: Array[String]): Unit = {
    // 定义整数列表
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // 使用匿名函数计算所有偶数的平方和
    val evenSquaredSum = numbers.filter((x) => x % 2 == 0).map((x) => x * x).sum

    // 打印结果
    println(s"The sum of squares of even numbers is: $evenSquaredSum")

  }
}
