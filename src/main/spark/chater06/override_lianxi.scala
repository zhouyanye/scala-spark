package chater06

object override_lianxi {
    //定义Person类 属性(姓名 属性)
  class Person{
      val name="张三" //val  值不能修改
      var age=19//var 值可以修改
      //sayHello方法
      def sayHello():Unit=println("hi Person")
    }
    //定义Student类 继承Person
  class Student extends  Person{
      //重写父类成员变量
      override val name : String = "小明"

      //override var age=20  因为父类中用var修饰的变量 子类不能重写
      //重写父类的成员方法
      override def sayHello () : Unit = {
        //调用父类的成员方法
        super.sayHello ()
        println("Hey  Student")
      }
    }

  def main (args : Array[String]) : Unit = {
    val s=new Student
    println(s.name,s.age) //小明 19
    s.sayHello()  //先Person父类  再Student子类
  }
}
