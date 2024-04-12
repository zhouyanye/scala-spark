package chater02

object for_lianxi2 {
  def main(args : Array[String]) : Unit = {
    val word="Hello,boy"
    for (i<- 0 until word.length){
      val ch=word.charAt(i)
      println(ch)
    }
    println("-----")
    println(word)
  }
}
