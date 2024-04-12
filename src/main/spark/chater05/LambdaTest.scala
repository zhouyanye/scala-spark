package chater05

object LambdaTest {
  def main(args: Array[String]): Unit = {
    val sum1: (Int, Int) => Int = (a, b) => a + b
    println(sum1(1, 2))
  }
  /*
  Scala中函数为一等公民，你不仅可以定义一个函数然后调用它，而且你可以写-个未命名的函数字面量，
  然后可以把它当成一个值传递到其它函数或是赋值给其它变量，还可以将函数作为其他函数的返回值
  基本语法格式
  (参数列表)=>函数体
  所谓一等函数 就是使用函数字面量 进行作为值进行传递
   */
}