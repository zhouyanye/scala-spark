package chater03

import scala.collection.mutable.ArrayBuffer

object Array_demo1 {
  //数组
  /*
  数组Array 存储数据类型相同元素
  scala 数组分为定长数组和变长数组
  定长数组new new Array[T](数组长度)
  变长数组 导包 ArrayBuffer[T]()  import scala.collection.mutable.ArrayBuffer
   */
  def main(args : Array[String]) : Unit = {
  //初始化一个长度为8的定长数组
    val arr1=new Array[Int](8)
    println(arr1)//打印数组的hashcode值
    //定义变长数组
    val arr2=ArrayBuffer[Int]()
    //向数组缓冲的尾部追加一个元素
    arr2+=1
    arr2+=(2,3,4,5)
    println(arr2)
    //添加一个数组++=
    arr2++=Array(6,7)
    println(arr2)
    //追加一个数组缓冲
    arr2++=ArrayBuffer(8,9)
    println(arr2)
    //在数组某个位置插入元素 使用insert 从某下标插入
    arr2.insert(0,-1,0)
    println(arr2)
    //删除数组某个位置的元素 使用remove 下标
    arr2.remove(0)
    println(arr2)
  }
}
