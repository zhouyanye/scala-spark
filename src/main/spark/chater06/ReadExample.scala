package chater06

import scala.io.Source

object ReadExample{
  def main(args : Array[String]) : Unit = {
    checkPhone()
  }
  def checkPhone(){
    val phone=for(line<-Source.fromFile("I:\\spark_notebooks\\src\\main\\scala\\2020phonelocation.txt").getLines) yield line
    val phoneList:List[String]=phone.toList
    var num:String=Console.readLine
    for(line <- phoneList;if line.contains(num)){println(line)}
  }
}