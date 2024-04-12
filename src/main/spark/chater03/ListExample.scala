package chater03

/**
 * @Author： 小周
 * @Date： 2024/1/31 20:01
 * @Describe：
 */
object ListExample {
  def main(args: Array[String]): Unit = {
    // 创建一个列表
    val numbers: List[Int] = List(1, 2, 3, 4, 5)

    // 访问列表元素
    println("列表元素： " + numbers.mkString("[", ", ", "]"))

    // 在列表头部添加元素
    val updatedNumbers: List[Int] = 0 :: numbers
    println("在头部添加元素： " + updatedNumbers.mkString("[", ", ", "]"))

    // 在列表尾部添加元素
    val appendedNumbers: List[Int] = numbers :+ 6
    println("在尾部添加元素： " + appendedNumbers.mkString("[", ", ", "]"))

    // 连接两个列表
    val combinedList: List[Int] = numbers ++ List(6, 7, 8)
    println("连接两个列表： " + combinedList.mkString("[", ", ", "]"))

    // 获取列表头部元素
    val headElement: Int = numbers.head
    println("列表头部元素： " + headElement)

    // 获取列表尾部元素（去掉头部）
    val tailElements: List[Int] = numbers.tail
    println("列表尾部元素： " + tailElements.mkString("[", ", ", "]"))

    // 检查列表是否为空
    val isEmpty: Boolean = numbers.isEmpty
    println("列表是否为空： " + isEmpty)

    // 遍历列表
    println("使用 foreach 遍历元素：")
    numbers.foreach(num => println(num))

    println("使用 for 循环遍历元素：")
    for (num <- numbers) {
      println(num)
    }

    // 列表推导：创建一个新列表，包含原列表每个元素的平方
    val squaredNumbers: List[Int] = numbers.map(num => num * num)
    println("列表推导： " + squaredNumbers.mkString("[", ", ", "]"))
  }
}
