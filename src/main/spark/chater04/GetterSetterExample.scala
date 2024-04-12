package chater04

object GetterSetterExample {
  def main(args: Array[String]): Unit = {
    val test = new Counter
    println(test.value) // 打印默认值 0，因为 private_value 初始值为 0
    test.value = 3 // 设置 value 的新值为 3，通过特殊的 setter 方法 value_= 来修改 private_value
    println(test.value) // 打印新值 3
    test.increment(1) // 步长为 1，每次增加 1，因此 private_value 变为 4
    println(test.current) // 打印当前值 4
  }

  class Counter {
    private var private_value = 0 // 私有字段 private_value，初始值为 0
    // 定义一个方法 value，用于获取私有字段 private_value 的值
    def value: Int = private_value
    // 定义特殊的 setter 方法 value_=，用于设置私有字段 private_value 的值
    def value_=(newValue: Int): Unit = {
      // 提供的新值是整数大于 0 才可以修改 private_value
      if (newValue > 0) private_value = newValue
    }
    // 定义一个方法 increment，用于按照给定步长增加 private_value 的值
    def increment(step: Int): Unit = { value += step }
    // 定义一个方法 current，用于获取当前 private_value 的值
    def current(): Int = { value }
  }
}
