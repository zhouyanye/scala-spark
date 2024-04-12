package chater03

import scala.collection.mutable.Map
object MapExample3 {
  def main(args : Array[String]) : Unit = {
    //任务:修改商品价格
    //存储商品价格，如("computer"->3600,"iphone"->2000,"cup">10)
    //修改商品价格为原来的9折
    val map3 = Map("computer" -> 3600.0, "lpone" -> 2000.0, "cup" -> 10.0)
    for (myMap <- map3.keys)
      map3(myMap) = (map3(myMap) * 0.9)
    println(map3)
  }

}
