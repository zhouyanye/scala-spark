package chater01

import scala.Array._
/**
 * @Author： 小周
 * @Date： 2024/1/31 19:13
 * @Describe：
 */
object ArrayMethodsExamples {
  def main(args: Array[String]): Unit = {
    // 定义两个数组
    val arr1: Array[Int] = Array(1, 2, 3)
    val arr2: Array[Int] = Array(4, 5, 6)

    // 使用 concat 方法连接两个数组
    val concatenatedArray: Array[Int] = concat(arr1, arr2)
    println(s"连接两个数组：${concatenatedArray.mkString("[", ", ", "]")}")

    // 使用 fill 方法创建指定长度和元素的数组
    val filledArray: Array[Int] = fill(5)(10)
    println(s"创建长度为 5，元素全为 10 的数组：${filledArray.mkString("[", ", ", "]")}")


    // 使用 range 方法创建指定范围的数组
    val rangeArray1: Array[Int] = range(1,10)
    println(s"创建范围为 1 到 10（不包含 10） 的数组：${rangeArray1.mkString("[", ", ", "]")}")

    val rangeArray2 = (1 until 10 by 2).toArray
    println(s"创建范围为 1 到 10（不包含 10），步长为 2 的数组：${rangeArray2.mkString("[", ", ", "]")}")
  }

}
