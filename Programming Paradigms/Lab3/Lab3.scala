package Lab3

import scala.annotation.tailrec

object Lab3 {

  // task 1: Write a function which will sum the values in a list using tail recursion. (1pt)
  def SumList(list: List[Int]): Int = {
    @tailrec
    def SumListRecur(list: List[Int], sum: Int): Int = list match {
      case head :: tail => SumListRecur(tail, sum + head)
      case _ => sum
    }
    SumListRecur(list, 0)
  }


  // task 2 Create a method reversing a list. (1pt)
  // a) regular recursion
  def reverseListRegular(list: List[Int]): List[Int] = list match {
    case Nil => list
    case head :: tail => reverseListRegular(tail) ::: List(head)
  }

  // b) tail recursion
  def reverseListTail(list: List[Int]): List[Int] = {
    @tailrec
    def reverseListTailRec(list1: List[Int], list2: List[Int]): List[Int] = list2 match {
      case Nil => list1
      case head :: tail => reverseListTailRec(head :: list1, tail)
    }

    reverseListTailRec(Nil, list)
  }

  // task 3: Create a method that merges two lists in such a way that elements of both lists alternate,
  // e.g. for lists [1, 2, 3] and [4, 5, 6] result is [1, 4, 2, 5, 3, 6].
  // If one of the lists have too many elements, add rest of them to the end of the result. (2pts)
  def mergeTwoList(list1: List[Int], list2: List[Int]): List[Int] = list1 match {
    case head :: tail => head :: mergeTwoList(list2, tail)
    case _ => list2
  }

  // task 4 Write a function which return n-th Fibonacci number and use tail recursion.
  // Compare the solution with the code from last tutorials.
  // In tail recursive method of finding nth Fibonacci the recursive call is the last thing done by the function.
  // In this example, we can see the tailRecFib call being applied in the last line of code.
  // Unlike normal recursion now there is no need to keep record of the previous states on the stack.
  def FibonacciNumber(n: Int): BigInt = {
    @tailrec
    def tailRecFib(n: Int, a: BigInt, b: BigInt): BigInt = n match {
      case 0 => a
      case 1 => b
      case _ => tailRecFib(n - 1, b, a + b)
    }

    tailRecFib(n, 0, 1)
  }
  def Fibonacci(n: Int): BigInt = n match {
    case 0 => 0
    case 1 => 1
    case _ => Fibonacci(n-2) + Fibonacci(n-1)
  }

  // task 5 Write function which split list to two lists: first include only odd numbers, second include only even numbers (2pts)
  def splitListOddEven(list: List[Int]): (List[Int], List[Int]) = {
    @tailrec
    def splitList(list: List[Int], i: Int, result: (List[Int], List[Int])): (List[Int], List[Int]) = list match {
      case Nil => (result._1.reverse, result._2.reverse)
      case head :: tail if i % 2 == 0 => splitList(tail, (i + 1), (head :: result._1, result._2))
      case head :: tail => splitList(tail, (i + 1), (result._1, head :: result._2))
    }

    splitList(list, 0, (List(), List()))
  }

  // task 6: Write a function which check that numbers in provided list are correctly sorted. Please use tail recursion (1pt)
  @tailrec
  def isSorted(list: List[Int])(implicit ordering: Ordering[Int]): Boolean = list match {
    case Nil => true
    case head :: Nil => true
    case head :: tail => ordering.lteq(head, tail.head) && isSorted(tail)
  }


  // task 7: Define the replaceNth function, which replace the n-th element of the list by given value.
  // do not use standard library functions here (2pts)
  // def replaceNth[A](list: List[A], index: Int, value: A): List[A] = { list.updated(index, value) }
  def replaceNth[A](list: List[A], index: Int, value: A): List[A] = list match {
    case head :: tail => if (index > 0) head :: replaceNth(tail, index - 1, value) else value :: list.tail
    case Nil => list
  }


  // task 8: Use curried representation and write system which convert pressure units.
  // Input: pressure in atm (atmosphere)
  // Outputs: PSI, bar, torr, pascal
  // atm= 14.6956 psi = 760 torr = 101325 Pa = 1.01325 bar. (1pt)
  def convertUnits(atm: Double)(c: Double): Double = atm * c

  val psi: Double => Double = convertUnits(14.6956)
  val torr: Double => Double = convertUnits(760)
  val pascal: Double => Double = convertUnits(101325)
  val bar: Double => Double = convertUnits(1.01325)


  def main(args: Array[String]): Unit = {

    val list1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val list2 = List(5, 6, 3, 2, 1)
    val list3 = List(1, 2, 3)
    val replace = List('a', 'b', 'c', 'd')
    print("task 1: ")
    println(SumList(list3))
    print("task 2a: ")
    println(reverseListRegular(list1))
    print("task 2b: ")
    println(reverseListTail(list1))
    print("task 3: ")
    println(mergeTwoList(list1, list2)) // 1, 5, 2, 6, 3, 3, 4, 2, 5, 1, 6, 7, 8, 9
    print("task 4: ")
    println(FibonacciNumber(12))
    print("task 5: ")
    println(splitListOddEven(list1))
    print("task 6: ")
    println(isSorted(list1))
    print("task 7: ")
    println(replaceNth(replace, 2, 'e'))
    println("task 8: ")
    println(psi(2))
    println(torr(4))
    println(pascal(1))
    println(bar(10))

  }

}
