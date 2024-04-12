package chater06

object ClassTraitExample1{
  def main(args : Array[String]) : Unit = {
    val caculate=new Caculate(3)
    while (caculate.hasxNext)
      caculate.pri
  }
  trait iterator1{
    var count:Int
    def hasxNext:Boolean
    def Next:Int=if(hasxNext){count+=1;count}else 0
  }
  trait iterator2{
    def pri:Unit
  }
  class Caculate(num:Int)extends iterator1 with iterator2{
    var count:Int=0

    override def hasxNext : Boolean = count < num

    override def pri : Unit =println(s"当前次数${Next}")
  }
}
