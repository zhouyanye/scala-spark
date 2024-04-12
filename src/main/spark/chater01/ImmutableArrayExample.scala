package chater01

/**
 * @Author： 小周
 * @Date： 2024/1/31 19:39
 * @Describe：
 */
object ImmutableArrayExample {
  def main(args: Array[String]): Unit = {
    // 方式1：使用 Array 关键字
    val numbers1: Array[Int] = Array(1, 2, 3, 4, 5)

    // 方式2：使用 Array 类的工厂方法
    val numbers2: Array[Int] = Array.apply(6, 7, 8, 9, 10)
    // 方式3：使用 Array 类的 ofDim 方法
    val numbers3: Array[Int] = Array.ofDim[Int](5)
    numbers3(0) = 11
    numbers3(1) = 12
    numbers3(2) = 13
    numbers3(3) = 14
    numbers3(4) = 15

    // 打印数组元素
    println("方式1：" + numbers1.mkString("[", ", ", "]"))
    println("方式2：" + numbers2.mkString("[", ", ", "]"))
    println("方式3：" + numbers3.mkString("[", ", ", "]"))

  }
}
