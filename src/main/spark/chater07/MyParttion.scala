package chater07

import org.apache.spark.Partitioner

class MyParttion(num:Int) extends Partitioner{
  override def numPartitions: Int = num //分区数

  override def getPartition(key: Any): Int = {
   if(key.toString.toInt %2 ==0) 0 else 1 //根据KEY获取分区

  }
}
