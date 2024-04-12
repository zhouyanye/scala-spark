package chater03

object MapExample2 {
  def main(args : Array[String]) : Unit = {
    //定义map 默认不可变
    val map1=Map("name"->"zhangsan","age"->20,"score"->100)
    //map1("name")="zhou"  这是不可变的

    //可变的
    import scala.collection.mutable.Map
    val map2=Map("name"->"zhangsan","age"->20,"score"->100)
    map2("score")=95
    println("修改后的成绩"+map2("score"))
    //常用操作方法
    println("是否包含健名sex:"+map1.contains("sex"))
        //存在打印值  不存在打印 不存在键名
    println(map1.getOrElse("name", "不存在键名"))
    println("map1所有的键值"+map1.keys)
    println("map2所有的键值"+map2.keys)
  }
}
