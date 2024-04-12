package chater01

/**
 * @Author： 小周
 * @Date： 2024/1/31 17:57
 * @Describe：
 */

/**
 * Scala 数据类型示例
 *
 * 1. 整型（Int）
 *    - 描述：32 位有符号补码整数。
 *    - 数值范围：-2147483648 到 2147483647。
 *
 * 2. 浮点型（Float）
 *    - 描述：32 位 IEEE 754 单精度浮点数。
 *    - 数值范围：大约 ±3.40282347E+38F。
 *
 * 3. 双精度浮点型（Double）
 *    - 描述：64 位 IEEE 754 双精度浮点数。
 *    - 数值范围：大约 ±1.79769313486231570E+308。
 *
 * 4. 字符串（String）
 *    - 描述：不可变的字符序列。
 *
 * 5. 布尔型（Boolean）
 *    - 描述：表示逻辑值，只能为 true 或 false。
 *
 * 6. 单位类型（Unit）
 *    - 描述：表示不返回任何有用的值的类型，类似于 void。
 */

object DataTypesExample {
  def main(args: Array[String]): Unit = {
    // 1. 整型
    val intValue: Int = 42
    println(s"整型示例：$intValue")

    // 2. 浮点型
    val floatValue: Float = 3.14f
    println(s"浮点型示例：$floatValue")

    // 3. 双精度浮点型
    val doubleValue: Double = 3.14
    println(s"双精度浮点型示例：$doubleValue")

    // 4. 字符串
    val stringValue: String = "Hello, Scala!"
    println(s"字符串示例：$stringValue")

    // 5. 布尔型
    val boolValue: Boolean = true
    println(s"布尔型示例：$boolValue")

    // 6. 单位类型
    val unitValue: Unit = ()
    println("单位类型示例")
  }
}
