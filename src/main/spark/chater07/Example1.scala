package chater07

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author： 小周
 * @Date： 2024/2/9 17:19
 * @Describe：
 */
object Example1 {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setAppName("Example1").setMaster("local[2]")
    val sc=new SparkContext(conf)
    //读取文件 并创建RDD
    val input=sc.textFile("/datas/online.retail.csv")
    //删除首行
    val drop_input=sc.textFile("/datas/online.retail.csv").mapPartitionsWithIndex((index,num)=>{
      if(index==0) num.drop(1)
      num
    })
    println("-"*10+"删除首行"+"-"*10)
    drop_input.take(1).foreach(println)
    val data=drop_input.map(x=>{
      val line=x.split(",")
      (line(0),line(1).toDouble)
    })
    println("-"*10+"数据处理"+"-"*10)
    data.take(2).foreach(println)
    println("-"*10+"统计行数"+"-"*10,data.count())//42481
//过滤是否空行
    val filter_data=data.filter(x=>x._1!="")
    println("-"*10+"统计行数"+"-"*10,data.count()) //26850
    /**
     * 1.使用filter方法过滤掉空行
     * 2.使用reduceByKey方法对每个客户的总消费金额进行求和
     */
    val sum_data=filter_data.reduceByKey((x,y)=>{x+y}.formatted("%.2f").toDouble)
    sum_data.take(10).foreach(println)
    //降序
    /**
     * 使用sortBy方法对每位客户的总消费金额进行降序排序，然后使用take方法获取前50名客户。
     */
    val sort_data=sum_data.sortBy(x=>x._2,false)
    sort_data.take(50).foreach(println)
  }


}
