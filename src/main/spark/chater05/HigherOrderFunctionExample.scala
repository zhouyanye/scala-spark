package chater05

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:47
 * @Describe：
 */


  // 主函数
  object HigherOrderFunctionExample {
    def main(args: Array[String]): Unit = {
      val numbers = List(1, 2, 3, 4, 5)

      // 使用高阶函数，将操作函数传入，实现对整数列表的不同操作
      val squaredNumbers = operateOnList(numbers, square)
      val doubledNumbers = operateOnList(numbers, double)
      val incrementedNumbers = operateOnList(numbers, increment)

      // 打印结果
      println("原始列表：" + numbers)
      println("平方后的列表：" + squaredNumbers)
      println("翻倍后的列表：" + doubledNumbers)
      println("递增后的列表：" + incrementedNumbers)
    }

  // 定义一个高阶函数，接受一个函数和一个整数列表作为参数
  def operateOnList(numbers: List[Int], operation: Int => Int): List[Int] = {
    // 使用传入的函数对列表中的每个元素进行操作，并返回新的列表
    numbers.map(operation)
  }

  // 定义一些操作函数，用于演示高阶函数的使用
  def square(x: Int): Int = x * x

  def double(x: Int): Int = x * 2

  def increment(x: Int): Int = x + 1
  }

