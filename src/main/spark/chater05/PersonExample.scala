package chater05


/**
 * @Author： 小周
 * @Date： 2024/1/31 21:52
 * @Describe：
 */
// 定义一个对象
object PersonExample {
  // 定义一个简单的Person案例类
  case class Person(name: String, age: Int)

  def main(args: Array[String]): Unit = {
    // 创建Person实例
    val alice = Person("Alice", 25)
    val bob = Person("Bob", 30)

    // 访问案例类的属性
    println(s"${alice.name} is ${alice.age} years old.")
    println(s"${bob.name} is ${bob.age} years old.")
  }
}
