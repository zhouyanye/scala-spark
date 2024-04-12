package chater05

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:13
 * @Describe：
 */
object Test02_FunctionAndMethod {
  def main(args: Array[String]): Unit = {
    //无参 无返回值
    def f1(): Unit = {
      println("1 无参 无返回值")
    }

    f1()
    println(f1())
    println("=" * 20)

    //无参 有返回值
    def f2(): Int = {
      println("2 无参 有返回值")
      return 12
    }

    println(f2())
    println("=" * 20)

    //有参 无返回值
    def f3(name: String): Unit = {
      println("3 有参 无返回值" + name)
    }

    println(f3("alice"))
    println("=" * 20)

    //有参 有返回值
    def f4(name: String): String = {
      println("4 有参 有返回值" + name)
      return "hi," + name
    }

    println(f4("alice"))
    println("=" * 20)

    def f5(name1: String, name2: String): Unit = {
      println("5 多参 无返回值")
      println(s"${name1}和${name2}都是我的好朋友")
    }

    f5("alice", "bob")
    println("=" * 20)

    def f6(a: Int, b: Int): Int = {
      println("6 多参 有返回值")
      return a + b
    }

    println(f6(12, 37))
    println("=" * 20)

  }
}
