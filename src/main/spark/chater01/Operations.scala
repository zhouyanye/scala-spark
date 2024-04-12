package chater01

/**
 * @Author： 小周
 * @Date： 2024/1/31 17:45
 * @Describe：
 */
object Operations {
  def main(args: Array[String]): Unit = {
    // 算术操作符
    val a: Int = 5
    val b: Int = 3
    val sum: Int = a + b
    val difference: Int = a - b
    val product: Int = a * b
    val quotient: Double = a.toDouble / b.toDouble

    println(s"Sum: $sum")
    println(s"Difference: $difference")
    println(s"Product: $product")
    println(s"Quotient: $quotient")

    // 比较操作符
    val isEqual: Boolean = a == b
    val isNotEqual: Boolean = a != b
    val isGreater: Boolean = a > b
    val isLess: Boolean = a < b

    println(s"Is equal: $isEqual")
    println(s"Is not equal: $isNotEqual")
    println(s"Is greater: $isGreater")
    println(s"Is less: $isLess")

    // 逻辑操作符
    val andResult: Boolean = true && false
    val orResult: Boolean = true || false
    val notResult: Boolean = !true

    println(s"AND result: $andResult")
    println(s"OR result: $orResult")
    println(s"NOT result: $notResult")
  }
}