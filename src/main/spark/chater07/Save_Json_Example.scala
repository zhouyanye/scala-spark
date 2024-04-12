package chater07

import org.apache.spark.{SparkConf, SparkContext}
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonDSL._

object Save_Json_Example {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Save_Json_Example").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val input = sc.textFile("/testjson.json")
    implicit val format = DefaultFormats
    val in_json = input.collect.map { x => parse(x).extract[Person] }
    in_json.foreach(println)

    val json = in_json.map { x =>
      ("name" -> x.name) ~ ("age" -> x.age)
    }

    val jsons = json.map { x => compact(render(x)) }
    jsons.foreach(println)

    sc.parallelize(jsons).repartition(1).saveAsTextFile("/json")
  }
}
