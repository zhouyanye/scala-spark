package chater06

object ClassTraitExample {
  def main(args : Array[String]) : Unit = {
    val student1=new Student1("11","11","11","87")
    println(student1.sing())
    println(student1.dance())
    println(student1.like())
    println(student1.texual)
  println(student1.award("欺人太甚"))
  }

trait t1{
  def sing():String
  def dance():String
  def like():String=s"唱跳rap"
}
  class Student1(name:String,grade:String,dance:String,course:String)extends t1 with t2{
    override def dance() : String = s"班级: $grade 姓名 $name 喜欢唱跳rap"
    override def sing() : String = s"班级: $grade 姓名 $name 喜欢唱跳rap叫"

    override def texual : String = s"班级: $grade 姓名 $name 已经考证$course"
    override def award(title:String) : String = s"班级: $grade 姓名 $name 已经获奖$title"
  }
  trait  t2{
    def texual:String ="优秀干部"//考证
    def award(title:String):String //获奖
  }
}
