package Lab13

import scala.collection.mutable

object Task4 {

  def wordCounter(text: String): mutable.Map[String, Int] = {
    val wordCount = mutable.Map[String, Int]()
    for (word <- text.split(" ")) {
      if (wordCount.contains(word)) {
        wordCount(word) += 1
      } else {
        wordCount(word) = 1
      }
    }
    wordCount
  }

  def main(args: Array[String]): Unit = {
    val text = "Hi hello, hi Hi"
    val wordCount = wordCounter(text)
    println(wordCount)
  }

}

