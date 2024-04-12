package chater06

object ClassTraitExample3 {
 def main(args: Array[String]): Unit = {
  val p1 = new Point(1,2)
  val p2 = new Point(3,4)
  println(p1.isEqual(p2))
 }

}
trait Equal{
 def isEqual(p: AnyRef): Boolean
 def inNotEqual(p: AnyRef): Boolean = if (isEqual(p)) false else true
}
class Point(var x: Int, var y: Int) extends Equal{
 override def isEqual(p: AnyRef): Boolean = {
  p match {
   case point: Point if point.y == y && point.x == x => true
   case _ => false
  }
  //if (p.isInstanceOf[Point] && p.asInstanceOf[Point].x == x &&
  //    p.asInstanceOf[Point].y == y) true else false
 }
}

