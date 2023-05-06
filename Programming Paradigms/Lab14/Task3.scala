package Lab14

/*
Write observable which emit next natural number every 20 seconds (start from 1)
For this observable write a method which return factorial for current value.
Try to optimize this code as much as you can (hint: you can use operators).
 */
import io.reactivex.rxjava3.core.Observable

import java.util.concurrent.TimeUnit

object Task3 {

  def factorial(n: Long): Long = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  def main(args: Array[String]): Unit = {
    Observable.interval(20, 20, TimeUnit.SECONDS)
      .map(x => x + 1) // Starting from 1
      .map(factorial) // Emit factorial of current value
      .doOnNext(x => println(s"Factorial: $x")) // Print the factorial of each emitted value
      .subscribe()
  }

}