package chater03

object TupleExample3 {
  //val tuple=(元素1,元素2)
  def main(args : Array[String]) : Unit = {
    val tuple=("itcast",3.14,65535)
    println(tuple)
    //元组种元素角标从1开始的
    print(tuple._1)
    println(tuple._2)
    //拉链操作
    val scores=Array(88,95,80)
    val names=Array("zhangsan","lisi","wangwu")
    println(names.zip (scores).toBuffer)
  }
}
