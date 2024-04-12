package chater03

object ListExample4 {
  /*
  集合三大类 List Set Map所有集合都扩展自Iterable特质
  scala集合分为可变mutable 不可变 immutable

   */
  def main(args : Array[String]) : Unit = {
  //List  list列表和数组类似 列表所有元素都具有相同类型
    //然后列表与数组不同的是 列表不可变 列表元素不能通过赋值
    //字符串
    val fruit : List[String] ="apples"::("orange"::("pears"::Nil))
    println(fruit)
    //整型
    val nums : List[Int] =List(1,2,3,4)
    println(nums)
    //空
    val empty : List[Nothing] =List()
    println(empty)
    //二维数组
    val dim : List[List[Int]] =List(
      List(1,2,3),
      List(4,5,6),
      List(7,8,9)
    )
    println(dim)
  }
}
