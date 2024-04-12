package chater04

object CounterExample {
  def main(args: Array[String]): Unit = {
    val test3 = new Counter("Timer", 2)
    test3.info() // 显示计数器信息     设置了名称以及模式
    test3.increment(1) // 设置步长
    printf("Value= %d \n", test3.current)
  }

  class Counter(val name: String, val mode: Int) {
    // 带两个参数 name mode
    private var value = 0 // 存储计数器初始值
    // 三个方法
    // increment 方法用于增加计数器的值，
    // current 方法用于获取当前计数器的值
    // info 方法用于显示计数器的信息。
    def increment(step: Int): Unit = { value += step }
    def current(): Int = { value }
    def info(): Unit = { printf("name: %s  \t mode: %d \n", name, mode) }
  }

  /*
   上代码来使用主构造器来进行设置name和mode的值

  下面给计数器设置name和mode的例子 使用的是辅助构造器来对name和mode的值进行设置
    def main(args: Array[String]): Unit = {
        val test1=new Couter//主构造器
      val   test2=new Couter("Runner")//第一个辅助构造器  计算跑步步数
      val  test3=new Couter("Timer",2)//第二个辅助构造器 计数器名Timer来计算秒数
      test1.info()//显示计数器信息     没设置名称以及模式  输出默认值
      test1.increment(1)//设置步长
      printf("Value= %d \n",test1.current)
      test2.info()//显示计数器信息     设置了名称但未设置模式  默认模式为1
      test2.increment(2)//设置步长
      printf("Value= %d \n",test2.current)
        test3.info() //显示计数器信息     设置了名称以及模式
      test3.increment(3)//设置步长
      printf("Value= %d \n",test3.current)
    }
    class Couter{
      private  var value=0 //存储计数器初始值
      private  var name=""//计数器名称
      private var mode =1//mode用来加速器类型 1表示步数计数器 2表示时间计数器
      def this(name:String){  //第一个辅助构造器
        this()//调用主构造器
        this.name=name
      }
      def this (name: String,mode:Int){ //第二个辅助构造器
        this(name)//调用前面一个辅助构造器
        this.mode=mode
      }
      def increment(step:Int) :Unit={value+=step}
      def current():Int={value}
      def info():Unit={ printf("name: %s  \t mode: %d \n",name,mode) }
    }
  }

    辅助构造器 this
   *scala构造器包含一个主构造器和若干个 0或多个辅助构造器
   * 辅助构造器的名称为this 每个辅助构造器都必须调用一个此前已经定义的辅助构造器或者主构造器

   * scala每个类都有主构造器 但是scala主构造器和java有明显的不同
   * scala的主构造器是整个类体 需要在类名称后面罗列出构造器所需的所有参数 这些参数被编译成字段 字段的值就是创建对象时候传入的参数的值
   */
}
