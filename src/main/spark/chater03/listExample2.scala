package chater03

object listExample2 {
  def main(args : Array[String]) : Unit = {
    //定义列表1 字符串
    var list1:List[String]="apple"::"orange"::"pear"::Nil
    //整型  val list1:List[Int]=List(1,2,3,4)
    println("定义列表1:"+list1)
    val list2:List[Nothing]=Nil
    val list3=(1::2::3::4::Nil)::(1::2::3::4::Nil)::Nil
    println("定义空列表"+list2)
    println("定义二维列表"+list3)
    //方法2 list对象定义
    val list11=List("apple","orange")
    val list22=List()
    val list33=List(List(1,2,3,4),List(5,6,7,8))
    println("定义列表2:"+list11)
    println("定义空列表:"+list22)
    println("定义二维列表:"+list33)

    println("列表list1第一个元素:"+list1.head)
    println("列表list1除去第一个元素:"+list1.tail)
    println("列表list1是否为空:"+list1.isEmpty)
    println("列表list1前三个元素："+list1.take(3))
    print("列表list1是否包含1："+list1.contains(1))

    //加法
    list1=list1:+"xy"
    println("列表list1追加元素xy"+list1)
    list1="xy"+:list1
    println("列表list1添加元素xy"+list1)
    //排序
    val list5=List(2,3,4,5,6,1,0)
    println("排序后的列表: " + list5.sorted)
    //反转 逆序
    println("降序后的列表: " + list5.reverse)

    // 比较
    val list6 = List(2,3)
//    println("list6 是否以 list5 开头: " + list6.startsWith(list5))
//    println("list5 是否以 list6 开头: " + list5.startsWith(list6))
//
//    println("list6 是否以 list5 结尾: " + list6.endsWith(list5))
//    println("list5 是否以 list6 结尾: " + list5.endsWith(list6))

    //多集合操作
    println("list6与list5的交集"+list6.intersect(list5))
    println("list6与list5的差集"+list6.diff(list5))
    println("list5与list6的差集"+list5.diff(list6))
    println("list6与list5的并集"+list5.union(list6))
    println("list6与list5的并集(去重)"+list5.union(list6).distinct)

    //连接列表 :::方法或者List.concat()方法
    val list7=List(7,8,9)
    val list8=list5:::list6:::list7 //中缀表达式的方式  等价于:::()
    println("连接列表list5,list6,list7"+list8)
    println( "连接列表list5,list6,list7"+ list5.:::(list6).:::(list7))
    println("连接列表list5,list6,list7,list8"+List.concat(list5, list6, list7, list8))
  }
}
