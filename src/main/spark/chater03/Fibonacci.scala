package chater03

object Fibonacci {
  //任务:计算出斐波那契数列前5项，去除重复项并计算各项之和。
  // F(n)=F(n-1)+F(n-2)，n2，F(0)=0，F(1)=1
  def F(n: Int): Int = {
    if (n <= 2) 1
    else F(n - 1) + F(n - 2)
  }

  def main(args: Array[String]): Unit = {
    // 计算斐波那契数列前5项
    val fibonacciSequence = (1 to 5).map(F).toList
    // 去除重复项
    val uniqueFibonacciSequence = fibonacciSequence.distinct
    // 计算各项之和
    val sum = uniqueFibonacciSequence.sum

    println("斐波那契数列前5项：" + fibonacciSequence.mkString(", "))
    println("去除重复项后的斐波那契数列：" + uniqueFibonacciSequence.mkString(", "))
    println("各项之和：" + sum)
  }
}

