package chater03

import scala.collection.mutable.ArrayBuffer

object ArrayExample1{
  def main(args: Array[String]): Unit = {
    val intValueArr = new Array[Int](3) //声明一个长度为3的整形数据 每个数组元素的初始化为0
    intValueArr(0) = 12
    intValueArr(1) = 34
    intValueArr(2) = 56

    val myStrArr = new Array[String](3) //声明一个长度为3的字符串数组  数组初始化为null
    myStrArr(0) = "Haoop"
    myStrArr(1) = "Spark"
    myStrArr(2) = "Python"
    for (i <- 0 to 2) {
      println(myStrArr(i)) //循环遍历打印 hadoop spark python
    }

    //创建一个二维数组 第一维有1个元素 二维有1个元素
    val myMatrix = Array.ofDim[Int](1, 2)
    myMatrix(0)(0) = 1
    myMatrix(0)(1) = 2
    // 访问元素也是使用多级圆括号
    //val element = myMatrix(0)(1) // 获取第一行第二列的元素（值为2）
    println(myMatrix(0)(0) + "\n####")
    println(myMatrix(0)(1) + "\n#####")
    //可以使用多级圆括号来访问多维数组的元素 例如myMatrix(0)(1)来返回第一行第二列的元素

    // 创建一个3维的整型数组，第一维有1个元素，第二维有2个元素，第三维有3个元素
    val test = Array.ofDim[Int](1, 2, 3)
    println(test)

    // 创建一个3维的字符串数组，第一维有3个元素，第二维有2个元素，第三维有4个元素
    val myCube = Array.ofDim[String](3, 2, 4)
    myCube(0)(0)(1) = "Scala" // 获取第一层第一行第二列的元素（"Scala"）
    myCube(0)(1)(0) = "is" // 第一层第二行第一列设置为"is"
    myCube(0)(0)(2) = "Hadoop" // 第一层第一行第三列设置为"Hadoop"
    myCube(1)(1)(1) = "awesome" // 第二层第二行第二列设置为"awesome

    println(myCube(0)(0)(1) + "\n ###")
    println(myCube(0)(0)(2))

    /*
采用Array类型定义的数组属于定长数组 其数组长度在初始化不能改变如果要定义变长数组 需要使用
ArrayBuffer参数类型  需要导入import scala.collection.mutable.ArrayBuffer即可使用
     */
    val aMutableArr = ArrayBuffer(10, 20, 30)
    aMutableArr += 40 //10 20 30 40  后面添加元素
    println("数组添加一个元素", aMutableArr)
    aMutableArr.insert(2, 60, 40) //第2个元素后面插入60 40
    println(" 数组在指定第2个元素后面添加", aMutableArr)
    aMutableArr -= 40 //把第一个为40的删除
    println("删除一个显示为40的元素", aMutableArr)
    val temp = aMutableArr.remove(2) //第二个元素那些删除
    println("删除第二个", temp)

  }

}
