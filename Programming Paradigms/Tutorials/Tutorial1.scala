package Tutorials

object Tutorial1 {

  def fib(n: Int): BigInt = n match {
    case 0 => 0
    case 1 => 1
    case _ => fib(n - 1) + fib(n - 2)
  }

  def tailRecFib(n: Int): BigInt = {
    @scala.annotation.tailrec
    // annotation lets us mark specific methods that we hope the compiler will optimise.
    // we get a warning if they are not optimised by the compiler.
    def fib(n: Int, a: BigInt, b: BigInt): BigInt = n match {
      case 0 => a
      case 1 => b
      case _ => fib(n - 1, b, a + b)
    }

    fib(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    println(fib(5))
    println(tailRecFib(2))
  }

}
