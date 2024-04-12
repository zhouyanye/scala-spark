package chater04

object objectExample {
  def main(args : Array[String]) : Unit = {
println(avg(Array(1,2,3,4)))
    println(sum(1,2))
  }
def sum(a:Int,b:Int):Int={
  a+b
  a+b+10
  a+b+100
}
  def avg (arr:Array[Double]):Double=arr.sum/arr.length
}
