package chater02

object for_lianxi6 {
  def main(args : Array[String]) : Unit = {
    val res: List[String] = {
      val dogBreeds = List("Doberman", "Terrier", "Dachshund")
      for {breed <- dogBreeds
           if breed.contains("D")
           if breed.startsWith("Dach")} yield breed
    }
    println(res)
  }
}
