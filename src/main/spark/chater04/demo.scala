package chater04

object demo {
  def main(args: Array[String]): Unit = {
    val people1 = new People()
    people1.name = "alice"
    people1.age = 19
    println(s"Name: ${people1.name}, Age: ${people1.age}")
  }

  class People {
    var name = ""
    var age = 0
  }
}
