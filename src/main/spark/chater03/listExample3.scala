package chater03

object listExample3 {
  def main(args : Array[String]) : Unit = {
        // 定义列表1 字符串
        val list1: List[String] = "apple" :: "orange" :: "pear" :: Nil
        // 整型  val list1:List[Int]=List(1,2,3,4)
        println("定义列表1:" + list1)
        val list2: List[Nothing] = Nil
        val list3 = (1 :: 2 :: 3 :: 4 :: Nil) :: (1 :: 2 :: 3 :: 4 :: Nil) :: Nil
        println("定义空列表" + list2)
        println("定义二维列表" + list3)
        // 方法2 list对象定义
        val list11 = List("apple", "orange")
        val list22 = List()
        val list33 = List(List(1, 2, 3, 4), List(5, 6, 7, 8))
        println("定义列表2:" + list11)
        println("定义空列表:" + list22)
        println("定义二维列表:" + list33)

        println("列表list1第一个元素:" + list1.head)
        println("列表list1除去第一个元素:" + list1.tail)
        println("列表list1是否为空:" + list1.isEmpty)
        println("列表list1前三个元素：" + list1.take(3))
        print("列表list1是否包含1：" + list1.contains("1"))

        // 加法
        val x = "banana"
        val xs = List("apple", "orange")
        val newXsFront = x +: xs // 由序列xs的前方添加x所得的新序列
        val newXsBack = xs :+ x // 由序列xs的后方追加x所得的新序列

        println("新序列(前方添加x): " + newXsFront)
        println("新序列(后方追加x): " + newXsBack)

        // 排序
        val unsortedList = List(3, 1, 4, 2)
        val sortedList = unsortedList.sorted
        println("排序后的列表: " + sortedList)

        // 反转
        val reversedList = list1.reverse
        println("反转后的列表: " + reversedList)

        // 比较
        val xs1 = List(1, 2, 3, 4)
        val xs2 = List(1, 2, 3)
        val startsWith = xs1.startsWith(xs2)
        val endsWith = xs1.endsWith(xs2)
        val containsElement = xs1.contains(1)

        println("xs1 是否以 xs2 开头: " + startsWith)
        println("xs1 是否以 xs2 结束: " + endsWith)
        println("xs1 是否包含元素 1: " + containsElement)
      }

}
