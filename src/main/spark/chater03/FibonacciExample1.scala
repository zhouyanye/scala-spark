package chater03

//任务:计算出斐波那契数列前5项，去除重复项并计算各项之和。
// F(n)=F(n-1)+F(n-2)，n22，F(0)=0，F(1)=1
object FibonacciExample1 {
  def main(args : Array[String]) : Unit = {
    var list1:List[Int]= Nil
    list1=list1:+0 :+ 1
    for(i <- 2  to  10)
      list1=list1:+(list1(i-1)+list1(i-2))
      println(list1)
  }
}
