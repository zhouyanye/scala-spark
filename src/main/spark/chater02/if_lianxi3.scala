package chater02

object if_lianxi3 {
  def main(args : Array[String]) : Unit = {
    println("请输入分数")
    val num= scala.io.StdIn.readDouble()
    if (num>=90&&num<=100){
      println("A")
    }
    else if(num>=80 & num<90){
      println("B")
    }else if (num>=70 & num<80) {
      println("C")
    }else if(num>=60 & num<70){
    println("D")
  }else if(num>=0 && num<60){
      println("E")
    }else{
      println("输入有误")
    }
    }
}
