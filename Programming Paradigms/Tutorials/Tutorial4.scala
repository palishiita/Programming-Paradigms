// file:///C:/Users/Nandita/Desktop/computerNetwork/Lab4/ppTut04.pdf

package Tutorials

object Tutorial4 {

  //1. sum type vs product type: https://blog.rockthejvm.com/algebraic-data-types/
  sealed trait Color
  case object White extends Color
  case object Black extends Color

  sealed trait Name
  case object Pawn extends Name
  case object Rook extends Name
  case object Knight extends Name
  case object Bishop extends Name
  case object Queen extends Name
  case object King extends Name

  def chooseColor(c: Color): String = c match {
    case White => "moves first"
    case _ => "moves next"
  }

  case class ChessPiece(color: Color, name: Name)
  def isTheMostImportantPiece(c: ChessPiece): Boolean = c match {
    case ChessPiece(_, King) => true
    case _                   => false
  }

  // 2. Create ADT which represents days of week and functions isWeekendDay(), isWorkDay() for this structure.
  // What type of ADT is better to use for this task (sum/product)?
  // sum: “is a” relationship
  sealed trait DaysOfWeek
  case object Monday extends DaysOfWeek
  case object Tuesday extends DaysOfWeek
  case object Wednesday extends DaysOfWeek
  case object Thursday extends DaysOfWeek
  case object Friday extends DaysOfWeek
  case object Saturday extends DaysOfWeek
  case object Sunday extends DaysOfWeek

  def isWeekendDay(Day: DaysOfWeek): Boolean = Day match {
    case Saturday => true
    case Sunday => true
    case _ => false
  }

  def isWorkDay(Day: DaysOfWeek): Boolean = Day match {
    case Saturday => false
    case Sunday => false
    case _ => true
  }

  // 3. Explain why we call it hybrid ADT:
  // put together both the above types into something new that we call Hybrid types
  // Email, SMS, VoiceRecording are (is-a) notification
  // Email (has-a) has a sender, title and a body
  sealed trait Notification
  final case class Email(sender: String, title: String, body: String) extends Notification
  final case class SMS(caller: String, message: String) extends Notification
  final case class VoiceRecording(contactName: String, link: String) extends Notification


  /* 6. start */
  // https://stackoverflow.com/questions/13337338/call-by-name-vs-call-by-value-in-scala-clarification-needed
  // What will be printed when we call
  def something() = {
    println("calling something") // string value
    1 // return value
  }
  // as parameter of functions
  def callByValue(x: Int) = { // ":" used
    println("x1=" + x)
    println("x2=" + x)
  }
  def callByName(x: => Int) = { // "=>" used
    println("x1=" + x)
    println("x2=" + x)
  }
  /* 6. end */


  // 7.
  object Main extends App {
    val fibs: LazyList[BigInt] =
      BigInt(0) #:: BigInt(1) #:: // 0 1 printed
        fibs.zip(fibs.tail).map{ n =>
          println(s"Adding ${n._1} and ${n._2}")
          n._1 + n._2
        }
  }


  def main(args: Array[String]): Unit = {
    /* 6. */
    // answer: https://stackoverflow.com/questions/13337338/call-by-name-vs-call-by-value-in-scala-clarification-needed
    // call by value
    callByValue(something());
    println()

    // call by name
    callByName(something());
    println()

    /* output: https://stackoverflow.com/questions/13337338/call-by-name-vs-call-by-value-in-scala-clarification-needed
    scala> callByValue(something())
    "side effect happens once, becuase it compute the passed-in expression's value before calling the function,
    thus the same value is accessed every time."
    calling something
    x1=1
    x2=1

    scala> callByName(something())
    "side effect happens twice, recompute the passed-in expression's value every time it is accessed."
    calling something
    x1=1
    calling something
    x2=1
     */


    /* 7.*/
    Main.fibs.take(5).foreach(println) // 0 1 1 2 3
    Main.fibs.take(6).foreach(println) // 0 1 1 2 3 5
  }

}
