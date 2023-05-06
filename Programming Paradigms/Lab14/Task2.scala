package Lab14

/*
There are two bank accounts. This time reactive streams represent current value of money on the account
($1000, $200, $1600).
Using reactive programming write a code which provide sum of both accounts on each change.
*/

import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.BehaviorSubject

object Task2 {
  def main(args: Array[String]): Unit = {
    val account1 = BehaviorSubject.createDefault(1000.0)
    val account2 = BehaviorSubject.createDefault(200.0)

    val sum = account1.zipWith(account2, (a:Double, b:Double) => a + b)

    sum.subscribe(new Observer[Double]{
      override def onNext(t: Double): Unit = println("Sum of both accounts: $" + t)
      override def onError(e: Throwable): Unit = e.printStackTrace()
      override def onComplete(): Unit = println("sum observable completed")
      override def onSubscribe(d: Disposable): Unit = {}
    })
    account1.onNext(500.0)
    account2.onNext(300.0)
  }
}
