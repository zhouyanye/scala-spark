package chater03

//元组
object TupleExample1 {
  def main(args: Array[String]): Unit = {
    val tuple = ("BigData", 2023, 37.5)
    //tuple: (String, Int, Double) = (BigData,2023,37.5) scala解释器返回的执行结果
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)
  }
}
