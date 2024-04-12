package chater04

// 演示 如何在单例对象中定义成员方法
object PrintExample {

  // 定义单例对象
  object PrintUtil {
    // 在单例对象中定义成员方法 用来打印分割线
    def printSpliter(): Unit = println("-" * 15)
  }

  // 定义 main 方法作为程序的主入口
  def main(args: Array[String]): Unit = {
    // 调用单例对象的成员方法  打印分割线
    PrintUtil.printSpliter()
  }
}
