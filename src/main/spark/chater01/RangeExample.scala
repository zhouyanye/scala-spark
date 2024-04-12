package chater01

/**
 * @Author： 小周
 * @Date： 2024/1/31 19:28
 * @Describe：
 */
object RangeExample {
  def main(args: Array[String]): Unit = {
    val range1 = 1 to 10
    println(s"range1: ${range1.mkString("[", ", ", "]")}")
    val range2=1 until 10
    println(s"range2: ${range2.mkString("[", ", ", "]")}")
    val range3 = 1 until 10 by 3
    println(s"range3: ${range3.mkString("[", ", ", "]")}")
    val range4 = 1 to 10 by -3
    println(s"range4: ${range4.mkString("[", ", ", "]")}")
    val range5 = 1L to 10L by 3
    println(s"range5: ${range5.mkString("[", ", ", "]")}")
    val range6 = 1.1f to 10.3f by 3.1f
    println(s"range6: ${range6.mkString("[", ", ", "]")}")
    val range7 = 1.1f to 10.3f by 0.5f
    println(s"range7: ${range7.mkString("[", ", ", "]")}")
    val range8 = 1.1 to 10.5 by 3.1
    println(s"range8: ${range8.mkString("[", ", ", "]")}")
    val range9 = 'a' to 'g' by 3
    println(s"range9: ${range9.mkString("[", ", ", "]")}")
    val range10 = BigInt(1) to BigInt(10) by 3
    println(s"range10: ${range10.mkString("[", ", ", "]")}")
    val range11 = BigDecimal(1.1) to BigDecimal(10.3) by 3.1
    println(s"range11: ${range11.mkString("[", ", ", "]")}")
  }

}
