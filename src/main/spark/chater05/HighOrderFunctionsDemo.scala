package chater05

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:45
 * @Describe：
 */
object HighOrderFunctionsDemo {
  def main(args: Array[String]): Unit = {
    // 使用函数作为参数，定义一个高阶函数，使用匿名函数作为参数实现求周的周长或面积的功能
    def getCircle(r: Double, f: Double => Double): Double = {
      f(r)
    }

    println(getCircle(3, r => 2 * 3.14 * r))
    println(getCircle(3, r => 3.14 * r * r))
    println("-" * 20)

    // 函数作为参数
    def compute(a: Double, b: Double, f: (Double, Double) => Double): Double = f(a, b)

    val add1 = compute(1, 2, (x: Double, y: Double) => x + y)
    println(add1)

    val subtract1 = compute(1, 2, (x: Double, y: Double) => x - y)
    println(subtract1)

    // 函数作为返回值
    println("-" * 20)
  }
}
