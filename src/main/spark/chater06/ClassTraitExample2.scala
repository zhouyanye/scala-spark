
package chater06

object ClassTraitExample2 {
  def main(args: Array[String]): Unit = {
    val td = new Dog2("泰迪")
    td.speak
    td.run
  }
  //抽象类 name参数
  abstract class Pet(name: String){
    def speak: Unit = println("$name can speak.")
    def run: Unit
  }
  class Dog(name: String) extends Pet(name){
    override def run: Unit = println(s"$name can run")
  }
  trait Pet2{
    def speak: Unit
    def run: Unit
  }
  class Dog2(name: String) extends Pet2{
    def speak: Unit = println(s"$name can 狗叫")
    override def run: Unit = println(s"$name can 狗刨")
  }
}
