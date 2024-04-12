package chater03

//import
object ArrayExample {
  def main(args : Array[String]) : Unit = {
    //定义1
var arr1=new Array[Int](3)
val arr2=Array(1,2,3)
    arr1.foreach(println(_)+"")
    println("*"*20)
    arr1 = arr2
    arr1.foreach(print(_)+" ")
    println("*"*20)
    println(arr1.length)
    println(arr2.length)

    /**
     * // 定义1
     *  var arr1 = new Array[Int](3)
     *  val arr2 = Array(1, 2, 3)
     *
     *  arr1.foreach(println(_)) // 这里使用 foreach 打印数组的每个元素
     *  println("*" * 20)
     *
     *  // 将 arr2 赋值给 arr1
     *  arr1 = arr2
     *
     *  // 使用 mkString 方法将数组的元素连接成字符串，然后打印
     *  println(arr1.mkString(" "))
     *  println("*" * 20)
     *
     *  // 使用 length 方法获取数组的长度
     *  println("arr1 的长度：" + arr1.length)
     *  println("arr2 的长度：" + arr2.length)
     */
  }

}
