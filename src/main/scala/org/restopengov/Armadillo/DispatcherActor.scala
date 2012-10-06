package org.restopengov.Armadillo

import org.restopengov.Armadillo.backend.plugins._
import akka.actor.{Actor, ActorRef}
import akka.actor.Props
import akka.dispatch.{Await, Future}
import akka.pattern.ask
import akka.util.Timeout
import akka.util.duration._

case class DispatcherResponse(json: String)
 
class DispatcherActor extends Actor {

	private lazy val address = context.actorOf(Props[AddressActor], name = "address")
	implicit val timeout = Timeout(5 seconds)

	def receive = { 		
		case msg: String => {

			val futureAddress  = address ? msg
			val futureAddress2 = address ? msg

			val response = for {
		        result  <- futureAddress
		        result2 <- futureAddress2
		    } yield {
		        DispatcherResponse(result + "\n" + result2)
		    }

		    sender ! response

		}
		case _ => sender ! DispatcherResponse("Sorry, DispatcherActor couldn't understand this message :(")
	}

}