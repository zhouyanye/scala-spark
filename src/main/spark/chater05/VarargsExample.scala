package chater05

/* 可变参数指的是 最后一个参数可以重复 变长参数 从而允许函数调用者使用变长参数列表来调用该函数
scala中使用*来指明该参数为重复参数
*/

object VarargsExample {
  def main(args: Array[String]): Unit = {
    function1("小周")
    function1("小强")
    function1("哈哈")
    function1("1", "2", "3", "4", "5", "6")
    println("1-5求和" + function2(1, 2, 3, 4, 5))
  }

  def function1(name: String*): Unit = {
    for (arg <- name) {
      println(arg)
    }
  }

  def function2(nums: Double*): Double = {
    var s: Double = 0
    for (n <- nums) s += n
    s
  }

}
