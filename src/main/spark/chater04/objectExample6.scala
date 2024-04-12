package chater04

object objectExample6 {
  def main(args: Array[String]): Unit = {
    val Mycouter=new Counter
   Mycouter.increment //Mycouter.increment()
    println(Mycouter.current)
  }
  //类
  class Counter{
    private  var value=0
    def increment():Unit={value+=1}// 方法 increment 用于增加计数器的值，Unit 表示没有返回值
    //  Unit后面的等号和大括号后面 包含了该方法要执行的具体操作语句   value值加1
    def current():Int={value}  // 方法 current 用于获取当前计数器的值，返回类型为 Int 返回value值
  }
}
//创建对象

/*给类增加字段和方法

*   class  Counter{//这里是定义类的字段和方法}
*         class Counter{
    private  var value=0
    def increment():Unit={value+=1}// 方法 increment 用于增加计数器的值，Unit 表示没有返回值
    //  Unit后面的等号和大括号后面 包含了该方法要执行的具体操作语句   value值加1
    def current():Int={value}  // 方法 current 用于获取当前计数器的值，返回类型为 Int 返回value值
  }
*  可以使用new关键词来生成对象  new  Counter 或者 new  Counter()
*  如果大括号里面只有一行语句 那么也可以去掉大括号
* class Counter{
    private  var value=0
    def increment(): Unit= value +=1
    def current():Int={value}
  }
  *   或者 还可以把返回值类型和等号 去掉只保留大括号
*   class Counter{
    private  var value=0
    def increment() {value+=1}
    def current():Int={value}
  }
*/