package Lab6

object Lab6 {

  // #1. a) Functional way (using recurrence)
  def fib_func(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => fib_func(n - 1) + fib_func(n - 2)
  }

  // #1. b) Imperative way (using loop)
  def fib_imp(n: Int): Int = {
    var previouspreviousNumber = 0
    var previousNumber = 0
    var currentNumber = 1
    for (i <- 1 until n) {
      previouspreviousNumber = previousNumber
      previousNumber = currentNumber
      currentNumber = previouspreviousNumber + previousNumber
    }
    currentNumber
  }

  // #2. Write your own exception which will be thrown by method div when division by zero occurs
  def div(x: Int, y: Int): Int = {
    try {
      (x / y)
    } catch {
      case e: ArithmeticException => 0
    } finally {
      println("Calculation done!")
    }
  }

  def main(args: Array[String]): Unit = {
    println(fib_func(6))
    println(fib_imp(6))
    println(div(6, 0))
  }

}
