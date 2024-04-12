package chater05

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:12
 * @Describe：
 */
object LambdaTest2 {
  def main(args: Array[String]): Unit = {
    val sum1: (Int, Int) => Int = (x: Int, y: Int) => x + y
    println(sum1(10, 20))
    val num1: Int => Int = (x: Int) => x * x
    println("2的平方 " + num1(2))
    println("-" * 20)
    println("占位符")
    val sum2: (Int, Int) => Int = _ + _
    println(sum2(20, 20))
    //    val num2:Int=>Int(_*_)
    //    println("2的平方"+num2)
    println("-" * 20)
    val list = List(1, 2, 3)
    list.foreach((x: Int) => println(x))
    list.foreach((x) => println(x))
    list.foreach(x => println(x))
    list.foreach(println(_))
    println("-" * 28)
    val h: (Int, Int) => Int = (x: Int, y: Int) => x * y
    println(h(1, 2))
  }
}
