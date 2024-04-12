package chater02


object AgeInfo {
  def main(args: Array[String]): Unit = {
    print("请输入您的年龄：")
    val age = scala.io.StdIn.readInt()

    val info = if (age < 18) {
      "未成年人"
    } else if (age >= 18 && age <= 65) {
      "成年人"
    } else {
      "老年人"
    }

    println(s"您是一个 $info")
  }

  /**
   *  1. 条件表达式（if-else）
   *  习题：
   *  编写一个程序，接受用户输入的年龄，然后根据年龄输出不同的信息：
   *  如果年龄小于 18，输出 "未成年人"；
   *  如果年龄介于 18 到 65 之间，输出 "成年人"；
   *  如果年龄大于等于 65，输出 "老年人"。
   */
}
