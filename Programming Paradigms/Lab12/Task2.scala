package Lab12

/*
This program uses Akka actors to simulate a ping-pong game. The Player class represents the players and the Ball case
class represents the message with the current match result. The game is finished when one of the players reaches a
score of 10. The game function controls the flow of the game by passing the ball back and forth between the actors,
and checking the score at each step. The Random class is used to generate a random hit or miss for each player.
*/
/*
case class Ball(name: String, score: Int)

class Player extends Actor {
  def receive: Receive = {
    case Ball(name, score) =>
      val random = new Random()
      val hit = random.nextBoolean()
      if (hit) {
        println(s"Player $name hit the ball. Score: ${score + 1}")
        sender() ! Ball(name, score + 1)
      } else {
        println(s"Player $name missed the ball. Score: $score")
        sender() ! Ball(name, score)
      }
  }
}

object PingPongGame extends App {
  val system = ActorSystem("PingPongGame")
  val player1 = system.actorOf(Props[Player], "player1")
  val player2 = system.actorOf(Props[Player], "player2")
  player1 ! Ball("player1", 0)
  @tailrec
  def game(player1: ActorRef, player2: ActorRef, ball: Ball): Unit = {
    if (ball.score < 10) {
      player1 ! ball
      game(player2, player1, ball)
    } else {
      println(s"Player ${ball.name} wins!")
      system.terminate()
    }
  }
  game(player1, player2, Ball("player1", 0))
}

 */

