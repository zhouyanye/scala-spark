package chater06

import scala.collection.mutable
import scala.io.{Source, StdIn}

object PhoneLocationLookup {
  def main(args: Array[String]): Unit = {
    def four(): Unit = {
      val file = Source.fromFile("I:\\spark_notebooks\\src\\main\\scala\\2020phonelocation.txt").getLines()
      // 2, 数据预处理：手机号 -> 省份：所在城市
      import scala.collection.mutable.Map
      val phone = mutable.Map[String, String]()
      for (line <- file) {
        val date = line.split(",")
        phone(date(1)) = date(2) + ":" + date(3)
      }
      // 3, 业务逻辑处理
      val phoneKey = StdIn.readLine
      println(phone.getOrElse(phoneKey, "此号码不存在"))
    }

    four()
  }
}
