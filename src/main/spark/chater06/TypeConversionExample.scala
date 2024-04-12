package chater06

//演示isInstanceOf和asInstanceOf关键字
object TypeConversionExample {
  //定义Person类
  class Person{

  }
  //定义Student 继承Person 该类有一个自己的成员方法sayHello()
    class Student extends Person{
    def sayHello()=println("hi Student")
  }
  //main
  def main (args : Array[String]) : Unit = {
    //通过多态形式 创建Student类型的对象
    /*
    多态： 同一个事物再不同时刻表现出来的不同形态 状态
    优点:灵活和扩展性 代码重用  统一接口
    弊端 父类引用不能直接使用子类的特有成员
     */
    val p : Person = new Student //多态   通过val p: Person = new Student这行代码，
    // 我们创建了一个类型为Person变量p，但实际上它指向的是一个Student类型的对象。因为这是Student的Person子类，
    // 所以我们可以把Student对象赋值给Person类型的变量。
    //尝试调用Student类中的sayHello()方法
    // p.sayHello()  父类引用不能直接使用子类的特有成员

    //判断对象p是否是Student类型的对象
    if (p.isInstanceOf [Student]) {
    //如果是 就将其转换成Student类型的对象 然后调用sayHello()方法
      val s=p.asInstanceOf[Student]
      //相当于  val s:Student =new Student
      s.sayHello()
  }
  }
}
