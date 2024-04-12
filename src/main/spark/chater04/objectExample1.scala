package chater04

object objectExample1 {
  def main(args : Array[String]) : Unit = {

  }
//  def speed(distinct:Double,time:Int)={
//    println(distinct/time)
//  }
//  speed(time = 10,distinct = 50)
//def addInt(a:Int,b:Int):Int=a+b
//println(addInt(1,2))
//
//  def addIn(a:Int)(b:Int):Int=a+b
//  println(addIn(1)(2))
def signum(num: Int): Int = {
  if (num > 0) 1
  else if (num < 0) -1
  else 0
}
  println(signum(4))
}
