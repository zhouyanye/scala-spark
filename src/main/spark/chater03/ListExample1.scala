package chater03

object ListExample1 {
  def main(args: Array[String]): Unit = {
    val strList = List("BigData", "Hadoop", "Spark") //一变量 strList 列表不可变
    println(strList)
    println("strList的第一个元素是", strList.head)
    println("strList除外的元素有", strList.tail)
    val otherList = "Apache" :: strList
    println("在strList前面追加的", otherList)
    var intList = 1 :: 2 :: 3 :: Nil
    val hhList = List(1, 2, 3)
    println(intList)
    println(hhList)
  }

}
