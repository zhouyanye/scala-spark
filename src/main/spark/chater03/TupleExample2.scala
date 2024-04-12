package chater03

object TupleExample2 {
  def main(args : Array[String]) : Unit = {
    //元组定义 自变量
    val tuple1 : (Int, Int, String, Double) =(1,2,"abc",12.34)
    //元组定义 tuple类定义
    val tuple2:(Int,Double,String)=Tuple3(3,3,"ccc")
    //读取
    println("元素tuple1第一个元素"+(tuple1._1))
    println("元素tuple1第二个元素"+(tuple1._2))
    println("元素tuple1第三个元素"+(tuple1._3))
    println("元素tuple1第四个元素"+(tuple1._4))
    //拉链与拉开
    val list1=List("chinese","math","english")
    val list2=List(90,99,89)
    val list12=list1.zip(list2)
    println("拉链："+list12)
    //拉开
    println("拉开"+list12.unzip)
  }
}
