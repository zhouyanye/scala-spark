package chater01

object variable {
  def main(args: Array[String]): Unit = {
    val x=3
    val y=5
    lazy val sum=x+y//使用lazy关键字可实现惰性求值特性，这允许用户延迟任何表达式的执行。
    // 当使用lazy关键字声明表达式时，它只会在显式调用时执行
    print(sum)

  }

}
