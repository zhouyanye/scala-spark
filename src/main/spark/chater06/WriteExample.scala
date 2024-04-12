package chater06

import java.io.{BufferedOutputStream, File, FileOutputStream}
//字节流
object WriteExample {
  def main(args : Array[String]) : Unit = {
    val file=new File("scala.txt")
    val str:String ="hello scala"
    val strBytes:Array[Byte]=str.getBytes
    val w=new BufferedOutputStream(new FileOutputStream(file))
    w.write(strBytes)
    w.close()
    println("写入成功")
  }
}
