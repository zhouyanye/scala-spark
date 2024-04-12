package chater04

// 演示定义伴生对象
object GeneralsDemo {

  // 定义伴生类 Generals
  class Generals {
    // 里面写的内容非静态
    // 定义 toWar() 方法表示打仗
    def toWar(): Unit = {
      println(s"武将拿着${Generals.armsName}武器，上阵杀敌")
    }
  }

  // 定义伴生对象 Generals
  object Generals {
    // 里面写的内容都是静态的
    // 定义一个私有的成员变量 用来保存武器的名称
    private val armsName = "青龙偃月刀"
  }

  // 定义 main 方法 程序的入口
  def main(args: Array[String]): Unit = {
    // 创建伴生类的对象
    val c = new Generals
    // 调用 toWar() 方法
    c.toWar()
  }
}
