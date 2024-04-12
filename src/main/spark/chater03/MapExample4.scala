package chater03

object MapExample4 {
  //Map可迭代 键值对 键唯一 值不一定唯一 值通过键获取 
  def main(args : Array[String]) : Unit = {
  val map=Map("a"->1,"b"->2,"c"->3,"d"->4)
    //空
    val emptyMap=Map.empty[String,Int]
    val value=map("a")
    println(value)
  }
}
