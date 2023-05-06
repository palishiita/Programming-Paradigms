package Lab5

object Lab5 {

  /*
  1. Define a function which for each number k (1…n) converts lazy list to lazy list in which each
  element of input list occurs k times (3pts)
  */

  def lrepeat[T](k: Int)(list: List[T]): List[T] = {
    list.flatMap(element => List.fill(k)(element))
  }

  def lrepeat[T](k: Int)(list: LazyList[T]): LazyList[T] = {
    list.flatMap(element => LazyList.fill(k)(element))
  }

  // 2. Define function which generate Fibonacci Sequence in lazy way (3pts)
  def fib: LazyList[Int] = {
    LazyList(0, 1) #::: fib.zip(fib.tail).map { n => n._1 + n._2 }
  }

  /*
  3. For lazy binary tree:
  define function which generate infinity tree which as root has number n (parameter) and sub trees:
  Tree (2*n) and Tree(2*n+1)
  */
  trait lBT[+A]
  case object LEmpty extends lBT[Nothing]
  case class LNode[+A](elem: A, /* root*/
                       left: () => lBT[A], /*left subtree*/
                       right: () => lBT[A]) /*right subtree*/ extends lBT[A]


  /*
  def lazybinaryTree(n: Int): LNode[Int] = n match {
    case _ =>
      LNode(
      { println(n)
        n },
      { println(2*n)
        () => lazybinaryTree(2 * n) },
      { println(2 * n + 1)
        () => lazybinaryTree(2 * n + 1)
      })
  }
  */

  def lazybinaryTree(n: Int): LNode[Int] = n match {
    case _ => println(n)
      LNode(n , () => lazybinaryTree(2 * n) , () => lazybinaryTree(2 * n + 1))
  }



  def main(args: Array[String]): Unit = {

    println(lrepeat(2)(List(1, 2, 3, 4)))
    println()
    lrepeat(2)(LazyList(1, 2, 3, 4)).foreach(println)
    println()
    println(fib(6))
    println()

    lazybinaryTree(5).left().asInstanceOf[LNode[Int]].left()



  }


}
