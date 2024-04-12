package chater03

object ListExample5{
  def main(args : Array[String]) : Unit = {
    //使用Nil定义空列表 使用::进行构建 向列表的头部追加数据 创建新列表
    //字符串列表
    val fruit="apple"::"orange"::("pears"::Nil)
    println(fruit)
    val num=Nil
    println("fruit的第一个"+fruit.head)
    println("fruit的最后一个"+fruit.tail)
    println("fruit是否为空"+fruit.isEmpty)
    println("num是否为空"+num.isEmpty)
    println("fruit的前面二个"+fruit.take(2))
    println("fruit是否包含某个元素"+fruit.contains("apple"))




  }
}
