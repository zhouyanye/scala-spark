package chater04

object objectExample3 {
  def main(args : Array[String]) : Unit = {
//    val sum1:(Int,Int)=>Int=(a:Int,b:Int)=>a+b
//    println(sum1(1,2))
    //基本语法格式 (参数列表)=>函数体
//List(1,2,3).foreach((x:Int)=>println(x))
   // Seq(1,2,4,3).foreach((x:Int)=>println(x*x))
//  val small=(x:Double,y:Double)=>(x+y)
//    println(small(1,2))

// 定义一个匿名函数，接收一个参数并返回参数的平方
//val square = (x: Int) => x * x
    // 调用匿名函数，并传入一个数值参数
//    val result = square(5)
    // 打印结果
//    println(result)
    // 定义序列
//    val num = List(1, 2, 3, 4, 5)
//    // 使用map函数对序列中的每个元素进行平方操作，并返回一个新的序列
//    val sum = num.map(x => x * x)
//    println(sum)
    val list=List(1,2,3)

    list.foreach(x=>x>0)
//    list.foreach((x)=>println(x))
//    list.foreach((x=>println(x)))
////    list.foreach(println())
  }
}
