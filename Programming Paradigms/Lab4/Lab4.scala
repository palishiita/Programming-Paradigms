package Lab4

object Lab4 {

  // Task 1
  val primes: Int => List[Int] = (toN: Int) => {
    def findPrimes(sieve: List[Int]): List[Int] = sieve match {
      case head :: tail => head :: findPrimes(tail filter (x => x % head != 0))
      case Nil => Nil
    }

    findPrimes(List.range(2, toN))
  }

  // Task 2
  sealed trait Calculator
  case class Add(a: Int, b: Int) extends Calculator
  case class Negate(n: Int) extends Calculator

  def calculate(c: Calculator): Int = c match {
    case Add(a, b) => a + b
    case Negate(n) => -n
  }

  // Task 3
  enum CalculatorEnum:
    case Add(a: Int, b: Int)
    case Negate(n: Int)
  end CalculatorEnum

  //import enumCalculator.*
  def calculate(c: CalculatorEnum): Int = c match {
    case CalculatorEnum.Add(a, b) => a + b
    case CalculatorEnum.Negate(n) => -n
  }

  // Task 4
  sealed trait Bool

  case class AND(a: Boolean, b: Boolean) extends Bool

  case class OR(a: Boolean, b: Boolean) extends Bool

  case class XOR(a: Boolean, b: Boolean) extends Bool

  case class NAND(a: Boolean, b: Boolean) extends Bool

  case class NOR(a: Boolean, b: Boolean) extends Bool

  def boolean(b: Bool): Boolean = b match {
    case AND(a, b) => a && b
    case OR(a, b) => a || b
    case XOR(a, b) => (a && !b) || (!a && b)
    case NAND(a, b) => !(a && b)
    case NOR(a, b) => !(a || b)
  }


  // Task 5
  def checkArgument(arg: AnyVal): String = arg match {
    case _: Boolean => "Boolean"
    case _: Int => "Int"
    case _: Float => "Float"
    case _: Double => "Double"
    case _: Char => "Char"
  }

  def main(args: Array[String]): Unit = {
    // Task 1
    println(primes)
    println()
    // Task 2
    println(calculate(Add(1, 2)))
    println(calculate(Negate(-5)))
    println()
    // Task 3
    println(calculate(CalculatorEnum.Add(1, 2)))
    println(calculate(CalculatorEnum.Negate(-5)))
    println()
    // Task 4
    // AND (true, true) => true; _ => false;
    // OR (false, false) => false;
    // XOR (false, false) => false; (true, true) => false; _ => true;
    // NAND (true, true) => false; _ => true;
    // NOR (false, false) => true; _ => false;
    println(boolean(AND(true, true)))
    println(boolean(OR(true, true)))
    println(boolean(XOR(false, true)))
    println(boolean(NAND(true, false)))
    println(boolean(NOR(false, false)))
    println()
    // Task 5
    val bool: AnyVal = true
    println(checkArgument(bool))
    val int: AnyVal = 5
    println(checkArgument(int))
    val float: AnyVal = 7.0f
    println(checkArgument(float))
    val double: AnyVal = 2.76
    println(checkArgument(double))
    val char: AnyVal = 'A'
    println(checkArgument(char))
  }

}
