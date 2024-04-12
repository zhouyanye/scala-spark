package chater02

object for_lianxi3 {
  def main(args : Array[String]) : Unit = {
    println("to 循环")
    for (i<- 0 to 10){println(i)}
    println("---------------")
    println("until循环")
    for(i<- 0 until 10){println(i)}
    println("-------------------")
    println("守卫模式 选择偶数 大于4")
    for(i<- 1 to 10;if i%2==0;if i>=4){println(i)}
    println("---------------------")
    println("公差为2的范围在从1到10内的等差数列")
    for(i<- 1 to 10 by 2){println(i)}
    println("-------------")
    println("10-1的倒序")
    for(i<-10 to 1 by -1){println(i)}
    println("-----------------")
  }

}
