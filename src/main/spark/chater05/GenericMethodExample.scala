package chater05

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:58
 * @Describe：
 */
object GenericMethodExample {
  def main(args: Array[String]): Unit = {
    val intList = List(1, 5, 3, 7, 2)
    val doubleList = List(2.5, 1.1, 3.7, 2.0)

    val maxInt = findMax(intList)
    val maxDouble = findMax(doubleList)

    println(s"Max integer: $maxInt")
    println(s"Max double: $maxDouble")
  }

  // 泛型方法：查找列表中的最大值
  def findMax[T: Ordering](elements: List[T]): T = {
    elements.max
  }
}
