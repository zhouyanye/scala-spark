package chater01

/**
 * @Author： 小周
 * @Date： 2024/1/31 19:20
 * @Describe：
 */
object mkStringExample {
  def main(args: Array[String]): Unit = {
    val numbers = Array(1, 2, 3, 4, 5)

    // 无参情况
    val result1 = numbers.mkString
    println(s"无参情况：$result1") // 输出：12345

    // 带一个分隔符参数
    val result2 = numbers.mkString(", ")
    println(s"带一个分隔符参数：$result2") // 输出：1, 2, 3, 4, 5

    // 带三个参数
    val result3 = numbers.mkString("[", ", ", "]")
    println(s"带三个参数：$result3") // 输出：[1, 2, 3, 4, 5]

  }

  /*
  def mkString: String
  def mkString(sep: String): String
  def mkString(start: String, sep: String, end: String): String
    1. 无参情况  mkString 无参数时，会将集合的所有元素直接连接成一个字符串。默认情况下，元素之间没有分隔符。
    2. 带一个分隔符参数 mkString(sep: String) 接受一个分隔符参数，用于在连接元素时在它们之间添加分隔符。
    3. 带三个参数 mkString(start: String, sep: String, end: String) 接受三个参数，分别是起始字符串、元素分隔符和结束字符串。它将起始字符串放在连接后的字符串的开头，将元素分隔符插入元素之间，最后将结束字符串放在字符串的末尾。
   */
}
