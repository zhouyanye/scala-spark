package chater04

object DogLegsDemo {
  // 定义单例对象 Dog
  object Dog {
    // 定义一个变量用来保存狗的腿的数量
    val legCount = 4
  }

  // 定义 main 方法作为程序的主入口
  def main(args: Array[String]): Unit = {
    // 直接打印狗腿的数量
    println(Dog.legCount)
  }
}
