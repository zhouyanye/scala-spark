package chater01

import scala.collection.mutable.ArrayBuffer
/**
 * @Author： 小周
 * @Date： 2024/1/31 19:41
 * @Describe：
 */
object MutableArrayExample {
  def main(args: Array[String]): Unit = {
    // 创建可变数组
    val numbers: ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, 4, 5)

    // 添加元素
    numbers += 6
    numbers += (7, 8, 9, 10)

    // 移除元素
    numbers -= 5

    // 在指定位置插入元素
    numbers.insert(2, 11, 12)

    // 更新元素
    numbers(3) = 99

    // 打印数组元素
    println("可变数组：" + numbers.mkString("[", ", ", "]"))
  }

}
