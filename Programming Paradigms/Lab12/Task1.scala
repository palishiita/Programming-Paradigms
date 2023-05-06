package Lab12

import akka.actor.{Actor, ActorSystem, Props}

case class msg(value: "Anna")

class Task1 extends Actor {
  def receive: Receive = {
    case "msg(Anna)" => println("Hi Anna")
    case "msg(Tom)" => println("Hello Tom")
    case _ => println("Sorry, I don't recognize that name.")
  }
}

object Task1_Main extends App {
  val system = ActorSystem("WelcomeSystem")
  val welcomeActor = system.actorOf(Props[Task1], name = "welcomeActor")
  welcomeActor ! "msg(Anna)"
  welcomeActor ! "msg(Tom)"
  welcomeActor ! "msg(Unknown)"
  system.terminate()
}
