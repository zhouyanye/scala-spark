package chater04

/*
使用命名参数允许你使用任意顺序传入参数
scala定义函数 允许指定参数的缺省值,从而允许在调用函数时不指明该参数 此时该参数使用缺省值
缺省值参数配合命名参数使用 缺省参数一般放在参数列表最后

多个参数列表 函数柯里化
函数柯里化是将接收多个参数的函数变化成接受单一参数 (最初函数的第一个参数)的函数
新的函数返回一个以原函数余下的参数为参数的函数
可以任意指定参数列表个数
 */
object FunctionExample3 {
  def main(args : Array[String]) : Unit = {
    speed(20,6)
    speed(time = 10,distinct = 50)
    println("-"*20)
    speed1(50) //使用了缺省参数值
    speed1(49,7)
    println("-"*20)
    println((addInt1(1, 6)))
    println("-"*20)
    println("柯里化"+addInt(1)(6))
  }
  def speed(distinct:Double,time:Int): Unit ={println(distinct/time)}
  def speed1(distinct:Double,time:Int=10): Unit ={println(distinct/time)}
  //定义两个整数相加的函数
 def addInt1(a:Int,b:Int):Int=a+b
  //使用函数柯里化
  def addInt(a:Int)(b:Int) : Int =a+b

}
/*
思考: 为什么允许多个参数列表?
(1) 代码更清晰、优雅和便捷。当最后一个参数列表只含有一个表示函数的参数时，
多个参数列表的形式拥有整齐的块结构语法，即参数列表两边的圆括号可以用花括号替代
 */
