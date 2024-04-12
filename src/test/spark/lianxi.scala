object lianxi {
  def main(args: Array[String]): Unit = {
    val getAge: Map[String, Int] => Int = (map: Map[String, Int]) => map("age")
    print(getAge(Map("name" -> 1, "age" -> 20)))
  }
}
