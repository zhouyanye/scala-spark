package chater04

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:48
 * @Describe：
 */
object MethodVsFunctionExample {
  // 方法定义在类中
  class MyClass {
    def add(x: Int, y: Int): Int = x + y
  }

  // 函数定义
  val multiply: (Int, Int) => Int = (a, b) => a * b

  def main(args: Array[String]): Unit = {
    // 使用方法
    val myObj = new MyClass
    val resultFromMethod = myObj.add(3, 4)
    println("Result from method: " + resultFromMethod)

    // 使用函数
    val resultFromFunction = multiply(3, 4)
    println("Result from function: " + resultFromFunction)
  }
}
