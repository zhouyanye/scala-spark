package chater04

object objectExample2 {
  def main(args : Array[String]) : Unit = {
def sayHello(name:String):Unit={
  //定义函数
  println("hello"+name)
}
    sayHello("孙强")//调用函数
    objectExample2.sayHello("Tom")//调用对象的方法
  }
  //定义对象的方法
def sayHello(name:String):Unit={
  println("hello"+name)
}
}
