package chater02

object for_lianxi4 {
  def main(args : Array[String]) : Unit = {
    val dogBreeds =List("Doberman","Terrier","Dachshund")
    for(breed <- dogBreeds)
      println(breed)
  }
}

