package chater02

object if_lianxi2 {
  def main(args : Array[String]) : Unit = {
    val x=10
    if(x>5){println("x大于5")}else{println("x小于5")}
    val result=if(x>5) "x大于5" else "x小于5"
    println(result)
    println("------------------------------------")
    val num1 = 10
    val num2 = 20
    if (num1 > 5) {
      if (num2 > 15) {
        println("num1 大于 5 并且 num2 大于 15")
      } else {
        println("num1 大于 5 但 num2 不大于 15")
      }
    } else {
      println("num1 不大于 5")}


  }

}
