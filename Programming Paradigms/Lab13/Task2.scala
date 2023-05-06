package Lab13

/*
Here, both Foo and Bar classes extend a trait HasMethod which defines a method method(input: String) which both
classes implement. Now, the variable foo is of type HasMethod which means that it can hold any type that extends
HasMethod, hence it can hold both instances of Foo and Bar. This way, the code will work as expected.
 */

object Task2 {

  trait HasMethod {
    def method(input: String): String
  }

  class Foo extends HasMethod {
    def method(input: String): String = input
  }

  class Bar extends HasMethod {
    def method(input: String): String = input
  }

  var foo: HasMethod = new Bar(); // <- this line now works

}
