package chater05

object FunctionPractice {
  def main(args: Array[String]): Unit = {
  }
  //  https://cloud.tencent.com/developer/article/2182712

  // 可变参数
  // def f1(str: String*): Unit = {
  //   println(str)
  //   // WrappedArray 底层会转变成一个集合类型，类似于Java中的数组
  // }

  // 带名参数 即默认值
  // def f2(name: String, id: Int = 19): Unit = {
  //   println(s"name: ${name} id: ${id}")
  // }

  // 高阶函数

  // 匿名函数 lambda 没名字的函数 不能有函数的返回值
  // name id：表示输入参数类型； String Int：表示输入参数类型；函数体
  // val f3 = (name: String, id: Int) => println(s"name: $name id: $id")
  // f3("zhangsan", 19)
  def addInt(f: (Int, Int) => Int, a: Int, b: Int): Int = f(a, b)

  println(addInt((a: Int, b: Int) => a + b, 1, 2))

  // 如果参数只出现一次，则参数省略且后面参数可以用_代替
  // 定义一个函数，以函数作为参数输入
  // def f(func: String => Unit): Unit = {
  //   func("lisi")
  // }
  // f((name: String) => { println(name) })
  // f(name => println(name))
  // f(println(_))
  // f(println)

  // def dualFunctionOneAndTwo(func: (Int, Int) => Int): Int = {
  //   func(1, 2)
  // }

  // 简化
  // println(dualFunctionOneAndTwo((a: Int, b: Int) => a + b))
  // println(dualFunctionOneAndTwo((a: Int, b: Int) => a - b))
  //
  // println(dualFunctionOneAndTwo((a, b) => a + b))
  // println(dualFunctionOneAndTwo((a, b) => a - b))
  //
  // println(dualFunctionOneAndTwo(_ + _))

  // Scala中的高阶函数有三种方式：函数作为值进行传递、函数作为参数传递、函数作为函数的返回值。
  // 定义一个函数
  // def f(n: Int): Int = {
  //   println("f调用")
  //   n + 1
  // }
  // 前面为参数类型 后面为返回值类型
  // val f1: Int => Int = f
  // 等价于
  // val f2 = f _  // f _ 表示f函数本身 方法转换为函数
  // println(f1)
  // println(f2)
  // println(f1 == f2) //false
}
