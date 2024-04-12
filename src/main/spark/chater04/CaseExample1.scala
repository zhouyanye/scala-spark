package chater04

object CaseExample1 {
  def main(args: Array[String]): Unit = {
    val personOpt = new PersonOpt("张三", 12)
    personOpt.oh
    println("-" * 20)
    val hh = personOpt("xiaoli", 88)
    hh.oh
  }

  class PersonOpt(var name: String, var id: Double) {
    def apply(str: String, id: Double) = new PersonOpt(name, id)

    def oh: Unit = {
      println(s"name $name  id $id")
    }
  }
}
