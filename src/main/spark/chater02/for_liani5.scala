package chater02

object for_liani5 {
  def main(args : Array[String]) : Unit = {
    //1-10 包括10
    //for(i <- 1 to 10)println(i)
    //1-10 不包括10
    //for(i<- 1 until 10)println(i)
    for (i <- 100 to 999) {
      val a : Int = i / 100 //获取百位
      val b : Int = (i % 100) / 10 //获取十位
      val c : Int = i % 10 //获取个位
      //a^3+b^3+c^3
      if (i == a * a * a + b * b * b + c * c * c) {
          println("水仙花数有",i)
      }
    }
  }
}
