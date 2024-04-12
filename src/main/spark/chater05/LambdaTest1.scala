package chater05

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:12
 * @Describe：
 */
object LambdaTest1 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3)
    list.foreach((x: Int) => println(x))
    println("-" * 20)
    //使用匿名函数传参的方式 编写程序实现对某一序列中的元素求平方
    // 并返回修改后的新序列
    val list1 = List(1, 2, 3, 4)
    list1.foreach((x1: Int) => println(x1 * x1)) //传参值给函数
    println("-" * 20)
    val sumll = (x: Double, y: Double) => x + y
    println(sumll(1, 2))
    println("-" * 27)
    //使用匿名函数赋值的方式
    // 编写程序实现对某个数求平方
    val res: Int => Int = (x: Int) => x * x //赋值给变量
    println("2的平方 " + res(2))
    println("-" * 20)

    def sum4(x: Int, y: Int): (Int, Int) => Int = (x: Int, y: Int) => x + y //作为函数的返回值

    sum4(12, 87)

  }

}
