package chater03

object Array_demo3 {
  def main(args : Array[String]) : Unit = {
    val arr=Array(1,2,3,4,5,6,7,8,9)
    //将整数取出来×10 再生成一个新数组
    val newArr=for(e<-arr if e%2==0)yield e*10
    println(newArr.toBuffer)
  }
}
