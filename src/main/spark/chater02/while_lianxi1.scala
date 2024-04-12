package chater02

import scala.io.StdIn

object while_lianxi1 {
  def main(args : Array[String]) : Unit = {
    var zhengshu = 0
    var fushu = 0
    var n=0
    do {
      print("请输入一个数字 n :  (0结束)")
      n = StdIn.readInt()//读取整数
      if (n > 0) {
        zhengshu += 1
      } else if (n < 0) {
        fushu += 1
      }
    } while (n != 0)
    println(s"正数个数: $zhengshu")
    println(s"负数个数: $fushu")


  }
}
