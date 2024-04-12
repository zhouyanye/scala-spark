package chater07

import org.apache.spark.{SparkConf, SparkContext}
import java.io.StringWriter
import au.com.bytecode.opencsv.CSVWriter

case class Data(index: String, title: String, content: String)

object Save_Csv_Example {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Save_Csv_Example").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val input = sc.textFile("/tipdm/testcsv.csv")

    val result = input.map { line =>
      val parts = line.split(",")
      Data(parts(0), parts(1), parts(2))
    }

    result.mapPartitions { dataIterator =>
      val stringWriter = new StringWriter()
      val csvWriter = new CSVWriter(stringWriter)
      dataIterator.foreach { data =>
        csvWriter.writeNext(Array(data.index, data.title, data.content))
      }
      Iterator(stringWriter.toString)
    }.saveAsTextFile("/tipdm/csv_out")
  }
}
