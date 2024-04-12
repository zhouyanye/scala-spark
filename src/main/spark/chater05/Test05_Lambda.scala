package chater05

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:13
 * @Describe：
 */
object Test05_Lambda {
  def main(args: Array[String]): Unit = {
    val fun = (name: String) => {
      println(name)
    }
    fun("小周")
    println("=================")

    //定义一个函数 以函数作为参数输入
    def f(func: String => Unit): Unit = {
      func("小周")
    }

    f(fun)
    //匿名函数
    println("=" * 20)
    f((name: String) => {
      println(name)
    })
    println("================")

    //(1) 参数的类型可以省略，会根据形参进行自动的推导
    f((name) => {
      println(name)
    })
    // (2)类型省略之后，发现只有一个参数，则圆括号可以省略;其他情况: 没有参数和参数超过1的永远不能省略圆括号
    f(name => {
      println(name)
    })
    // (3)匿名函数如果只有一行，则大括号也可以省略
    f(name => println(name))
    //(4)如果参数只出现一次，则参数省略且后面参数可以用_代替
    f(println(_))
    //如果可推断出 当前传入println是一个函数体 而不是调用语句 可直接省略下划线
    f(println)
  }
}
