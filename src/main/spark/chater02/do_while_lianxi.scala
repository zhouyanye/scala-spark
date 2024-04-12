package chater02

object do_while_lianxi {
  def main (args : Array[String]) : Unit = {
    var a = 10
    do{
      println( "Value of a: " + a )
      a = a + 1 //a+=1
    }while( a < 20 )

  }

}
