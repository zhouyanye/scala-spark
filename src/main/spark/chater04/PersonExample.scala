package chater04

object PersonExample {
  // 定义一个 Person 类 包含两个字段 姓名和年龄
  class Person(var name: String = "", var age: Int = 0)

  // 定义 Person 的伴生对象
  object Person {
    // 伴生对象中定义 apply 方法 实现创建 Person 对象的免 new 操作
    def apply(name: String, age: Int): Person = new Person(name, age)
    // apply 方法 自动调用
  }

  def main(args: Array[String]): Unit = {
    // 在 main 方法中创建该类的对象 并打印姓名和年龄
    val p = Person("张三", 23)
    println(p.name, p.age)
  }
}
