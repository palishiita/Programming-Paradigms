package Lab2

object Lab2 {

  // sum of odd numbers in list
  def SumOddList(list: List[Int]): Int = {
    val oddNumbers = list.filter(_ % 2 != 0)
    if (oddNumbers.isEmpty) 0
    else oddNumbers.head + SumOddList(oddNumbers.tail)
  }

  // count number of occurrences of specific element in the list
  def occurrenceOfNum[Element](list: List[Element]): Map[Element, Int] = {
    list.groupBy(element => element).map(e => (e._1, e._2.length))
  }

  // concatenate list of strings by separator
  def connectStrings(listOfString: List[String], separator: String): String = listOfString match {
    case head :: tail => tail.foldLeft(head)(_ + separator + _)
    case Nil => ""
  }

  // return nth fibonacci number
  def Fibonacci(n: Int): Int = {
    if (n <= 1) n
    else Fibonacci(n - 1) + Fibonacci(n - 2)
  }

  def main(args: Array[String]): Unit = {
    val numList = List(1, 2, 2, 1, 3, 4, 5, 7, 6, 6)
    println(SumOddList(numList)) //17
    println(occurrenceOfNum(numList))
    val stringList = List("a", "b", "c", "d")
    val separator = ","
    println(connectStrings(stringList, separator))
    println(Fibonacci(2))
  }

}
