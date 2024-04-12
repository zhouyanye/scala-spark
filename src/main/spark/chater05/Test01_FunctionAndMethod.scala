package chater05

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:13
 * @Describe：
 */
object Test01_FunctionAndMethod {
  def main(args: Array[String]): Unit = {

    //def 关键字 sayHi 函数名 name参数名 String参数类型 Unit函数值返回值
    def sayHi(name: String): Unit = {
      println("hi" + name) //函数体
    }
    //调用函数
    sayHi("alice")
    //调用对象方法
    //    Test_01FunctionAndMethod.sayHi("bob")

    //获取方法返回值
    val result = Test01_FunctionAndMethod.sayHello("cary")

  }

  //def 关键字 sayHi 函数名 name参数名 String参数类型 Unit函数值返回值
  def sayHello(name: String): String = {
    println("Hello" + name) //函数体
    return "Hello"
  }
}
