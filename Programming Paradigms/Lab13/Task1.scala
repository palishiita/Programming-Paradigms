package Lab13

object Task1 {

  def makeNoise(animal: {def makeNoise(): String}): Unit = {
    println(animal.makeNoise())
  }

  class Duck {
    def makeNoise(): String = {
      "Quack"
    }
  }
  class Dog {
    def makeNoise(): String = {
      "Bark"
    }
  }
  class Cat {
    def makeNoise(): String = {
      "Meow"
    }
  }

  def main(args: Array[String]): Unit = {
    val myDuck = new Duck
    val myDog = new Dog
    val myCat = new Cat
    makeNoise(myDuck) // will print "Quack"
    makeNoise(myDog) // will print "Bark"
    makeNoise(myCat) // will print "Meow"
  }


}





