package Lab14

/*
There are two bank accounts.
Each is represented by stream of changes (+$100, -$200 etc.).
Using reactive programming write a code which provide sum of both accounts on each change.
Remember initial value of money on both accounts is $0.
*/

import io.reactivex.rxjava3.core._

object Task1 {

  def main(args: Array[String]): Unit = {
    // Streams representing the two bank accounts
    val account1 = Observable.just(100.0, -50.0, 250.0, -100.0)
    val account2 = Observable.just(200.0, -150.0, 100.0, -50.0)
    // Use the zip operator to combine the two streams and
    // calculate the sum of the current balance on both accounts
    val sum = account1.zipWith(account2, (a:Double, b:Double) => a + b)
    // Print the sum of the two accounts on each change
    sum.subscribe(x => println(x))
  }
}
