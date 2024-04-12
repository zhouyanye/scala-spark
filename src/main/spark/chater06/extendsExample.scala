package chater06

object extendsExample {
  //定义Person类 作为父类
  class Person{
    //定义公共的内容 姓名 年龄 吃饭
    var name=""
    var age=0
    def eat()=println("人要吃饭")
  }

  //定义老师类 继承Person 人类
  class Teacher extends  Person {
  }
  //定义学生类  继承Person 人类
  class Student extends  Person {
  }
  //main 方法
  def main (args : Array[String]) : Unit = {
    //测试老师类
    val t=new Teacher
    t.name="刘老师"
    t.age=29
    println(t.name,t.age)
    t.eat()

    println("-"*10)

    //测试学生类
    val s=new Student
    s.name="张三"
    s.age=19
    println(s.name,s.age)
    s.eat()
  }
}