package chater05

/* 定义
def functionName([形参列表]:)[return type]={}
调用
functionName([实参列表])
如果函数定义在一个类中  可通过类名.方法名([参数列表])方式调用
scala 可以根据=号右侧表达式推导出函数返回类型
scala 可以使用代码块 块的最后一个表达式就是函数的返回值
如果return 返回函数的值  那么就需要明确指定函数返回类型
 */
object FunctionExample1{
  def main(args : Array[String]) : Unit = {
    println(s"add(1,2)=${add(1, 2)}")
    println(s"avg(Array(1, 2, 3, 4, 5, 6))=${avg(Array(1, 2, 3, 4, 5, 6))}")
    println("5的阶乘"+function(5))
  }
  def add(x:Int,y:Int) : Int ={
    x+y
    x+y+100
    x+y+10000
    x+y+20000
  }//定义avg 求数组平均值
  def avg(array: Array[Double]) : Double ={
    return array.sum/array.length
  }
//定义一个递归函数 实现阶乘的计算
  def function(i:Int):Double={
    if(i==1)1
    else i*function(i-1)
  }

}
