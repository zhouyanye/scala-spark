package chater03

object Array_demo4 {
  def main (args : Array[String]) : Unit = {
    //创建数组
    val arr:Array[Int]=new Array[Int](5)
    //方法2
    val arr2=Array(1,2,3,4)
    //访问元素
    println(arr(0))
    println(arr(1))
    println(arr(4))
//    println(arr(5))
    arr(0)=12
    arr(4)=57
    println(arr(0))
    println(arr(1))
    println(arr(4))
    println("==================")
    //数组的遍历
    //普通for
  for (i<-0 until  arr.length){
    println(arr(i))
  }
    for(i<- arr.indices){
      println(arr(i))
    }
    println("===========")
    //2) 直接遍历所有元素 增强for循环
    for(elem<-arr2)println(elem)
    //3)迭代器
    val iter=arr2.iterator
    while(iter.hasNext)
      println(iter.next())
    println("----------------")
    //4)foreach循环
  arr2.foreach((elem:Int)=>println(elem))
  arr.foreach(println)
    //5)
    println(arr2.mkString("--"))

    //添加元素 后面
    val newArr=arr2.:+(73)
    println(arr2.mkString("--"))
    println(newArr.mkString("--"))
    //添加元素 前面
    val newArr2=newArr.+:(30)
    println(newArr2.mkString("--"))

    // 理论：后缀调用法
    // 实践：
    val greeting = "Hello, World!"
    println(greeting.length)  // 正常调用
    println(greeting length)  // 后缀调用法，省略点号和括号

  }
}
