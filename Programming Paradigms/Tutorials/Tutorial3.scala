// file:///C:/Users/Nandita/Desktop/computerNetwork/Lab4/ppTut03.pdf
package Tutorials

object Tutorial3 {

  /*
  2. Define a function that filters items from a list of lists. The function is supposed to have two parameters:
  a list of lists and a value.
  Only those elements in which each element of the list is different from the specified value will remain in the result list.
  Example: [[1; 2; 3]; [3; 4]; [5; 6]]
            3 -> [[5; 6]]
  // listoflist.head = first list
  // listoflist.tail.head = second list
   */

  /*
  def filter(listOfList: List[List[Int]], value: Int): [List[Int]] = {
    // split list of list into multiple lists
    listOfList.tail.head
  }
  */

  def filter(listOfList: List[List[Int]], value: Int): List[List[Int]] = {
    listOfList.filter((l) => !l.contains(value) )
    //listOfList.filterNot(l => l.contains(value))
  }

  // 4. Create ADT (abstract data type) which represents dice (6 faces)

  // SUM TYPE: 1, 2, 3, 4, 5, 6 are (is-a) faces
  sealed trait Face
  case object One extends Face
  case object Two extends Face
  case object Three extends Face
  case object Four extends Face
  case object Five extends Face
  case object Six extends Face

  sealed trait FaceColor
  case object Blue extends FaceColor
  case object Green extends FaceColor
  case object Red extends FaceColor
  case object Yellow extends FaceColor

  // PRODUCT TYPE: Dice has (has-a) 6 faces and 4 colors
  case class Die(face: Face, color: FaceColor)

  def game(D: Face): String = D match {
    case One => "move 1 step forward"
    case Two => "move 2 steps backward"
    case Three => "move 3 steps forward"
    case _ => "go back to start"
  }

  def winner(first_roll: Face, second_roll: Face): String = (first_roll, second_roll) match {
    case (Six, Six) => "winner"
    case _ => "looser"
  }

  def decode(list:List[List[Any]]) : List[Any] = {
    val b = list.head.head.asInstanceOf[Int].toInt
    val items = List.fill(b)(list.head.tail)
    items
  }


  def main(args: Array[String]): Unit = {
    // task 2
    val list = List(List(1, 2, 3), List(3, 4), List(5, 6))
    println(filter(list,3))
    
    
    //val listOfList = List(List(1, 2, 3), List(3, 4), List(5, 6))
    //println(filter(listOfList, 3))
    //println();

    //println(game(One))
    //println();

    // 3. how does flatmap
    // Creating a list of numbers
    /*
    val list = List(2, 3, 4)
    def f(x:Int) = List(x-1, x, x+1)
    val result1 = list.map(y => f(y))
    val result2 = list.flatMap(y => f(y)) // consolidating into one single list
    println(result1)
    println(result2)
    */

    /*
    val list3 = List(3, 'a')
    val list2: List[List[Any]] = List(List(3, 'a'), List(4, 'b'), List(1, 'c'))
    decode(list2)
    */

    val list2: List[List[Any]] = List(List(3, 'a'), List(4, 'b'), List(1, 'c'))
    println(list2.head)
    println(list2.tail)



  }

}
