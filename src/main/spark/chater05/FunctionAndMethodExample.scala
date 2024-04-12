package chater05

object FunctionAndMethodExample {
  def main(args: Array[String]): Unit = {
    // 定义函数
    def sayHello(name: String): Unit = {
      println("hello " + name)
    }
    sayHello("GGBond") // 调用函数
    FunctionAndMethodExample.sayHello("Tom") // 调用对象方法
  }

  def sayHello(name: String): Unit = {
    println("hello " + name)
  }
}
