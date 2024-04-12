package chater06

import java.io.{BufferedWriter, File, FileWriter}

object WriteExample2 {
  def main(args: Array[String]): Unit = {
    val file = new File("scala1.txt")
    val str: String = "hello scala2 write to file"
    val writer = new BufferedWriter(new FileWriter(file))
    writer.write(str)
    writer.close()
    println("写入成功")
  }
}