package chater05

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:53
 * @Describe：
 */
object LambdaTest3 {
  def main(args: Array[String]): Unit = {
    // 定义一个简单的Person类
    class Person1(val name: String, val age: Int)

    // 伴生对象，包含工厂方法和静态方法
    object Person1 {
      // 工厂方法，创建Person实例
      def apply(name: String, age: Int): Person1 = new Person1(name, age)

      // 静态方法，用于其他功能
      def printInfo(person: Person1): Unit = {
        println(s"${person.name} is ${person.age} years old.")
      }
    }

    // 使用伴生对象的工厂方法创建Person实例
    val alice = Person1("Alice", 25)

    // 使用伴生对象的静态方法打印信息
    Person1.printInfo(alice)
  }
}
