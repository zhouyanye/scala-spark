package chater06

// 演示 getClass 和 ClassOf 关键字
object TypeCheckingExample {
  // 1 定义 Person 类
  class Person
  // 2 定义 Student 类，继承 Person 类
  class Student extends Person

  // 3 main 主入口
  def main(args: Array[String]): Unit = {
    // 4 通过多态的形式创建 Student 类型的对象
    val p: Person = new Student
    // 5 测试使用 isInstance 判断该对象是否为 Person 类型
    println(p.isInstanceOf[Person]) // 只要传入 Person 类型或者其子类对象，返回值 true
    // 6 测试使用 isInstance 判断该对象是否为 Student 类型
    println(p.isInstanceOf[Student]) // 只要传入 Person 类型或者其子类对象，返回值 true
    // 7 测试使用 getClass 和 classOf 判断该对象是否为 Person 类型
    println(p.getClass == classOf[Person])
    // 8 测试使用 getClass 和 classOf 判断该对象是否为 Student 类型
    println(p.getClass == classOf[Student])
  }
}
