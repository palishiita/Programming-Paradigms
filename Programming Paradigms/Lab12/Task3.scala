package Lab12

/*
Write a game between 3 actors: they send ball (as a message) to each other (randomly).
The ball is represented as:
case class Ball(count: Int)
where count is throwing counter which is increment by each actor who has a ball
*/

import akka.actor.{Actor, ActorRef, Props}

case class Ball(count: Int)

class Actor1 extends Actor {
  var actor2: ActorRef = _
  var actor3: ActorRef = _

  def receive: Receive = {
    case (a2: ActorRef, a3: ActorRef) =>
      actor2 = a2
      actor3 = a3
      self ! Ball(0)
    case ball: Ball =>
      val nextActor = scala.util.Random.shuffle(Seq(actor2, actor3)).head
      println(s"Lab12.Actor1 passed the ball (count: ${ball.count}) to ${nextActor.path.name}")
      nextActor ! Ball(ball.count + 1)
  }
}

class Actor2 extends Actor {
  var actor1: ActorRef = _
  var actor3: ActorRef = _

  def receive: Receive = {
    case (a1: ActorRef, a3: ActorRef) =>
      actor1 = a1
      actor3 = a3
    case ball: Ball =>
      val nextActor = scala.util.Random.shuffle(Seq(actor1, actor3)).head
      println(s"Lab12.Actor2 passed the ball (count: ${ball.count}) to ${nextActor.path.name}")
      nextActor ! Ball(ball.count + 1)
  }
}

class Actor3 extends Actor {
  var actor1: ActorRef = _
  var actor2: ActorRef = _

  def receive: Receive = {
    case (a1: ActorRef, a2: ActorRef) =>
      actor1 = a1
      actor2 = a2
    case ball: Ball =>
      val nextActor = scala.util.Random.shuffle(Seq(actor1, actor2)).head
      println(s"Lab12.Actor3 passed the ball (count: ${ball.count}) to ${nextActor.path.name}")
      nextActor ! Ball(ball.count + 1)
  }
}

object Task3_Main extends App {
  val actorSystem = akka.actor.ActorSystem("ball-game")
  val actor1 = actorSystem.actorOf(Props[Actor1], "Actor1")
  val actor2 = actorSystem.actorOf(Props[Actor2], "Actor2")
  val actor3 = actorSystem.actorOf(Props[Actor3], "Actor3")

  actor1 ! (actor2, actor3)
  actor2 ! (actor1, actor3)
  actor3 ! (actor1, actor2)
}
