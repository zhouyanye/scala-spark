package chater03

object SetExample {
  def main(args: Array[String]): Unit = {
    var mySet = Set("Hadoop", "Spark")
    mySet += "Scala"
    println(mySet)

    //    val  MutableSet=Set("Database","BigData")
    //    MutableSet+="Cloud Computing"
    //    println(MutableSet)
  }

}
