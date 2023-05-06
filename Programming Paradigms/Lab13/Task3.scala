package Lab13

object Task3 {

  case class Person(firstName: String, sureName: String) extends Ordered[Person] {
    def compare(that: Person): Int =
      if (this.sureName == that.sureName) {
        this.firstName compare that.firstName
      } else {
        this.sureName compare that.sureName
      }
  }

}
