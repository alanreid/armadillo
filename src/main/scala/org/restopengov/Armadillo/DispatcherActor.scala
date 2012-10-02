package org.restopengov.Armadillo

import akka.actor.{Actor, ActorRef}
import akka.actor.Props
import akka.dispatch.{Await, Future}
import akka.pattern.ask
import akka.util.Timeout
import akka.util.duration._
import org.restopengov.Armadillo.backend.plugins._
 
class DispatcherActor extends Actor {

	private lazy val address = context.actorOf(Props[AddressActor], name = "address")
	implicit val timeout = Timeout(5 seconds)

	def receive = { 		
		case msg: String => {

			val results = List(
				executeActor(address, msg),
				executeActor(address, msg)
			).reduceLeft(_ + "\n" + _)

			sender ! results
		}
		case _ => sender ! "Sorry, DispatcherActor couldn't understand this message :(" 
	}

	def executeActor(actor: ActorRef, message: String) = {
		Await.result(actor ? message, timeout.duration).asInstanceOf[String]
	}

}