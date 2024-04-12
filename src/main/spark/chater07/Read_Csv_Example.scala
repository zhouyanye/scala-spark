package chater07

import java.io.StringReader
import au.com.bytecode.opencsv.CSVReader
import org.apache.spark.{SparkConf, SparkContext}

object Read_Csv_Example {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Read_Csv_Example").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val input = sc.textFile("/tipdm/testcsv.csv")

    val result = input.flatMap { line =>
      val reader = new CSVReader(new StringReader(line))
      reader.readNext()//可使用Option处理可能为空的情况  Option(reader.readNext())
    }
    result.collect().foreach(println)
     // result.foreach(arr => println(arr.mkString(", ")))
    //flatMap可以用于解决每一行数据可能解析为空的情况。
    //map 可以用于处理每一行数据，但是无法处理每一行数据可能为空的情况。
    //map 运行结果 [Ljava.lang.String;@e95595b
    //[Ljava.lang.String;@5a917723
  }
}
