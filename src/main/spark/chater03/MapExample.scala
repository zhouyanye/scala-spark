package chater03

object MapExample {
  def main(args: Array[String]): Unit = {
    val info = Map("name" -> "Xiaozhou", "sex" -> "男", "age" -> "19", "h" -> "ohh")
    // 指定打印输出键"name"对应的值
    val nameValue = info("name") //    println(info("name"))
    println("Name: " + nameValue) //   printf("我的名字是"+info("name"))

    // 指定打印输出键"sex"对应的值
    val schoolValue = info("sex")
    println("sex: " + schoolValue)

    // 指定打印输出键"age"对应的值
    val ageValue = info("age")
    println("Age: " + ageValue)

    val ohh = if (info.contains("hh")) info("hh") else 0
    println(ohh) //if (info.contains("hh")) 是用来检查映射 info 是否包含键为 "hh" 的键值对。这行代码使用了条件判断语句 if，根据 if 后面的条件来决定执行哪个分支。

  }
}
