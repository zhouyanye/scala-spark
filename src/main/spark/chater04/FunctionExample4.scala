package chater04

/**
 * @Author： 小周
 * @Date： 2024/1/31 20:56
 * @Describe：
 */
object FunctionExample4 {
  def main(args: Array[String]): Unit = {
    val p = new Person("zhangsan", 20)
    println(p.name)
    println(p.age)
    p.name = "wangwu"
    p.age = 30
  }

  class Person(var name: String, var age: Int)
}
