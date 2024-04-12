package chater02

/**
 * @Author： 小周
 * @Date： 2024/1/31 21:33
 * @Describe：
 */
object IFexample {
  //控制语句结构
  def main(args: Array[String]): Unit = {
    //      var a=5
    //    if(a==5){
    //    println("a=5")
    //    }else if(a==10){
    //      println("a=10")
    //    }else{
    //      println("无法判断")
    //    }
    //    for(i<-0 to 9){
    //      print(i+" ")
    //    }
    //守卫模式
    //    for (i <- 0 to 9 if i%2==0; if i>5){
    //      print(i +" ")
    //    }
    //var x = 1
    //    while (x <= 10) {
    //      print (x + " ")
    //      x += 2
    //    }
    var b = 1
    do {
      print(b + " ")
      b += 1
    }
    while (b < 20)
  }
}
