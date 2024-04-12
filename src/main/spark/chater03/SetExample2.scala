package chater03

object SetExample2 {
  def main(args : Array[String]) : Unit = {
    //Set是没有重复对象的集合 所有元素都是唯一的 默认情况下
    //scala要使用不可变Set集合  可变需要导包 import scala.collection.mutable.Set
    //val set:Set[Int] =Set(1,2,3,4)

    val site=Set("itcatst","Google","Baidu")
    val nums : Set[Int] =Set()
  println("第一个网站",site.head)
    println("除了第一个网站",site.tail)
    println("查看集合site是否为空",site.isEmpty)
    println("查看nums是否为空",nums.isEmpty)
    println("查看site前两个网站",site.take(2))
    println("查看集合是否包含网站itcast",site.contains("itcast"))




  }
}
