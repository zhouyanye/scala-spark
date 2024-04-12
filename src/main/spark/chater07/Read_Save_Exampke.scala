package chater07

import org.apache.spark.api.java.JavaSparkContext.fromSparkContext
import org.apache.spark.sql.catalyst.dsl.expressions.intToLiteral
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author： 小周
 * @Date： 2024/2/6 13:41
 * @Describe：文件的读取与存储
 */
object Read_Save_Exampke {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Read_Save_Exampke").setMaster("local[*]")
    val sc = new SparkContext(conf)
    /**
     * 文本文件的读取与存储
     */
    //把RDD保存到HDFS中 saveTextFile(path:String)
    val data = sc.parallelize(List(1, 2, 3, 3))
    data.partitions.size.foreach(println) //rdd分区数跟part-xxx文件有关
    //data.saveAsTextFile("file:///G:\\spark\\spark\\src\\main\\spark\\chater07\\data")
//    data.saveAsTextFile("/user/root/result")
    data.saveAsTextFile("/out/text_out")
    //repartition(1)表示分区数为1 可以曾加或减少此RDD中并行级别 在内部,他使用shuffle重新分发数据
//    data.repartition(1).saveAsTextFile("/user/root/result1")
    data.repartition(1).saveAsTextFile("/out/text_out1")
    /**
     *  存储序列化文件 saveAsObjectFile(path:String) 将数据集作为Hadoop sequenceFile编写 只支持键值对RDD
     *  用来存储二进制式的[Key，Value]对而社交的一种平面文件 Flat File
     */
    //存储序列化文件 saveAsObjectFile(path:String) 将数据集作为Hadoop sequenceFile编写 只支持键值对RDD
    val rdd=sc.makeRDD(List(("Pandas", 3), ("Kay", 6), ("Snail", 2)))
//    val rdd = sc.parallelize(List(("Pandas", 3), ("Kay", 6), ("Snail", 2)))
    //rdd.saveAsSequenceFile("file:///G:\\spark\\spark\\src\\main\\spark\\chater07\\data1")
    rdd.saveAsSequenceFile("/user/root/sqf_result")
    //读取序列化文件 sequenceFile[K,V](path:String,keyClass:Class[K],valueClass:Class[V],minPartition:Option[Int])
    import org.apache.hadoop.io.{IntWritable, Text}
    //根据结果可查询 Text IntWritable                                                                            k   v
    val rdd1 = sc.sequenceFile("/user/root/sqf_result", classOf[Text], classOf[IntWritable]).map { case (x, y) => (x.toString, y.get()) }.collect()
    rdd1.foreach(println)
    //Csv文件的读取
    import java.io.StringReader
    import au.com.bytecode.opencsv.CSVReader
    val input = sc.textFile("/tipdm/testcsv.csv")
    val result = input.map { line =>
      val reader = new CSVReader(new StringReader(line));
      reader.readNext();
    }.collect() // 需要collect才能从分布式RDD获取到本地执行的结果
    result.foreach(println)

  }
}

/**
 * spark 支持一些常见的文件格式
 * 文本文件 结构化(否) 普通的文本文件每一行一条记录
 * SequeceFile 结构化(是) 二进制文件，每一行一个记录 一种用于键值对数据的常见Hadoop文件格式
 * Json 结构化(半结构化) 常见的基于文本的格式,半结构化;大多数要求每行一条记录
 * Csv 结构化(是) 非常常见的基于文本的格式，通常在电子表格应用中使用
 * 对象文件 结构化(是) 用来存储Spark作业中的数据,改变类时会生效，因为对新闻界依赖于java序列化
 */
