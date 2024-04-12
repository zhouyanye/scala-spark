package chater02

/**
 * @Author： 小周
 * @Date： 2024/1/31 20:28
 * @Describe：
 */
object case_lianxi {

  def main(args: Array[String]): Unit = {

    def normalizeBase(x: Char) = x match {
      case 'A' => "优秀"

      case 'B' => "良好"

      case 'C' => "及格"

      case _ => "输入有误"

    }

    println(normalizeBase('A'))
  }
}
