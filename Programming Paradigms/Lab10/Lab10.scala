package Lab10

import scala.collection.mutable

object Lab10 extends App {

  // Task 2.Define a generic invariant copy method for mutable  collections
  def copy[T](values: mutable.Seq[T], copyValues: mutable.Seq[T]): Unit = {
    require(copyValues.size >= values.size)
    for (i : Int <- values.indices) {
      copyValues(i) = values(i)
    }
  }

  val values = mutable.ArraySeq(1, 2, 4, 11, 8)
  println(values)
  val copyValues1 = mutable.ArraySeq(8, 7, 8, 9, 0, 10, 9, 8)
  println(copyValues1)
  copy(values, copyValues1)
  println(copyValues1)
  val copyValues2 = mutable.ArraySeq(8, 7, 8, 9, 0)
  println(copyValues2)
  copy(values, copyValues2)
  println(copyValues2)

}
