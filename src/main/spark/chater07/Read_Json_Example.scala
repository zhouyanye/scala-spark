package chater07

import org.apache.spark.sql.execution.streaming.FileStreamSourceOffset.format
import org.apache.spark.{SparkConf, SparkContext}
import org.json4s._
import org.json4s.jackson.JsonMethods._

case class Person(name: String, age: Int)

object Read_Json_Example {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Read_Json_Example").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val input = sc.textFile("/testjson.json")
//    val persons = input.map { line =>
//      val formats = DefaultFormats
//      parse(line).extract[Person]
//    }
//    persons.foreach(println)
    implicit val format = DefaultFormats
    val in_json = input.collect.map { x => parse(x).extract[Person] }
    in_json.foreach(println)
  }

}



/**
import org.apache.spark.sql.execution.streaming.FileStreamSourceOffset.format
import org.apache.spark.{SparkConf, SparkContext}
import org.json4s._
import org.json4s.jackson.JsonMethods._

case class Person(name: String, age: Int)

object Read_Json_Example {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Read_Json_Example").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val input = sc.textFile("/testjson.json")

    val persons = input.map { line =>
      parse(line).extractOpt[Person]
    }.filter(_.isDefined).map(_.get)

    persons.foreach(println)
  }
}


 import org.apache.spark.{SparkConf, SparkContext}
import org.json4s._
import org.json4s.jackson.JsonMethods._

import scala.util.Try

case class Person(name: String, age: Int)

object Read_Json_Example {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Read_Json_Example").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val input = sc.textFile("/testjson.json")

    val persons = input.flatMap { line =>
      val formats = DefaultFormats
      implicit val localFormatsFn: () => DefaultFormats = () => formats
      implicit val localFormats: DefaultFormats = localFormatsFn()
      Try(parse(line).extract[Person]).toOption
    }

    persons.foreach(println)
  }
}

package chater07
import org.apache.spark.{SparkConf, SparkContext}
import org.json4s._
import org.json4s.jackson.JsonMethods._

import scala.util.Try

case class Person(name: String, age: Int)

object Read_Json_Example {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Read_Json_Example").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val input = sc.textFile("/testjson.json")

    val persons = input.flatMap { line =>
      val formats = DefaultFormats
      implicit val localFormatsFn: () => DefaultFormats = () => formats
      implicit val localFormats: DefaultFormats = localFormatsFn()
      Try(parse(line).extract[Person]).toOption
    }

    persons.foreach(println)
  }
}






 */