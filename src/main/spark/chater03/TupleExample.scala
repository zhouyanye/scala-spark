package chater03

/**
 * @Author： 小周
 * @Date： 2024/1/31 20:02
 * @Describe：
 */
object TupleExample {
  def main(args: Array[String]): Unit = {
    // 创建一个元组
    val person: (String, Int, Double) = ("Alice", 25, 175.5)

    // 访问元组元素
    val name: String = person._1
    val age: Int = person._2
    val height: Double = person._3

    // 打印元组元素
    println(s"姓名: $name, 年龄: $age, 身高: $height")
    println(s"姓名: ${person._1}, 年龄: ${person._2}, 身高: ${person._3}")
    for (i <- 0 until person.productArity) {
      println(s"第 ${i + 1} 个元素: ${person.productElement(i)}")
    }

  }
}
