package chater04

object objectExample5 {
  def main(args : Array[String]) : Unit = {
    equalsing("equal1");equalsing2("equala2")
    commas("equal1","commas1")

   def equalsing(s:String): Unit =
    {println("equalsign:"+s)}

  def equalsing2(s: String)={
    println("equalign2:"+s)
  }
  def commas(s1:String,s2:String)=Console.println("comma:"+s1+","+s2)
}
}
