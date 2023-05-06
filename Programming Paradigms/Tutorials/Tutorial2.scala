package Tutorials

object Tutorial2 {

  @scala.annotation.tailrec
  def isSorted(list: List[Int])(implicit ord: Ordering[Int]): Boolean = list match {
    case Nil => true // empty list is sorted
    case x :: Nil => true // one element list is sorted
    case x :: xs => ord.lteq(x, xs.head) && isSorted(xs) // if the first two elements are ordered and the rest are sorted, the full list is sorted too
  }

  // 1 atm = 14.6956 psi = 760 torr = 1.01325 bar
  // input: atm
  // output: psi, torr, bar
  def convertUnits(atm: Double)(c: Double): Double = atm * c

  val psi: Double => Double = convertUnits(14.6956)
  val torr: Double => Double = convertUnits(760)
  val pascal: Double => Double = convertUnits(101325)
  val bar: Double => Double = convertUnits(1.01325)

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 6, 7)
    println(isSorted(list))
  }

}
