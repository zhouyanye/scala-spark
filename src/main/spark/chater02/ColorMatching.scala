package chater02

/**
 * @Author： 小周
 * @Date： 2024/1/31 20:00
 * @Describe：
 */
object ColorMatching {
  def main(args: Array[String]): Unit = {
    print("请输入颜色：")
    val color = scala.io.StdIn.readLine()

    val rgb = color match {
      case "红色" => "255,0,0"
      case "绿色" => "0,255,0"
      case "蓝色" => "0,0,255"
      case _ => "未知颜色"
    }

    println(s"颜色 $color 对应的 RGB 值为: $rgb")
  }
}