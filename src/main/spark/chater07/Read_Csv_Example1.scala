package chater07

import scala.collection.JavaConversions._
import au.com.bytecode.opencsv.CSVReader
import org.apache.spark.{SparkConf, SparkContext}

import java.io.StringReader

object Read_Csv_Example1 extends Serializable {
  case class Data(index: String, title: String, content: String) extends Serializable

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Read_Csv_Example1").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val input = sc.wholeTextFiles("/tipdm/testcsv.csv")
    val result = input.flatMap { case (_, txt) =>
      val reader = new CSVReader(new StringReader(txt))
      reader.readAll().map(x => Data(x(0), x(1), x(2)))
    }
    result.foreach(println)
  }
}
