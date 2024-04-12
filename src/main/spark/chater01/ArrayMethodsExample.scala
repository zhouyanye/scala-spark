package chater01

/**
 * @Author： 小周
 * @Date： 2024/1/31 18:11
 * @Describe：
 */
object ArrayMethodsExample {
  def main(args: Array[String]): Unit = {
    // 定义数组
    val numbers: Array[Int] = Array(1, 2, 3, 4, 5)

    // 数组长度
    val length: Int = numbers.length
    println(s"数组长度：$length")

    // 第一个元素
    val firstElement: Int = numbers.head
    println(s"第一个元素：$firstElement")

    // 除第一个元素外的其他元素
    val tailElements: Array[Int] = numbers.tail
    println(s"除第一个元素外的其他元素：${tailElements.mkString("[", ", ", "]")}")

    // 是否为空
    val isEmpty: Boolean = numbers.isEmpty
    println(s"数组是否为空：$isEmpty")

    // 最后一个元素
    val lastElement: Int = numbers.last
    println(s"最后一个元素：$lastElement")

    // 除最后一个元素外的其他元素
    val initElements: Array[Int] = numbers.init
    println(s"除最后一个元素外的其他元素：${initElements.mkString("[", ", ", "]")}")

    // 是否包含某个元素
    val containsElement: Boolean = numbers.contains(3)
    println(s"数组是否包含元素 3：$containsElement")

    // 数组元素之和
    val sum: Int = numbers.sum
    println(s"数组元素之和：$sum")

    // 数组最大值
    val maxElement: Int = numbers.max
    println(s"数组最大值：$maxElement")

    // 数组最小值
    val minElement: Int = numbers.min
    println(s"数组最小值：$minElement")

    // 数组排序
    val sortedArray: Array[Int] = numbers.sorted
    println(s"数组排序结果：${sortedArray.mkString("[", ", ", "]")}")
  }
}