package org.restopengov.Armadillo

import org.restopengov.Armadillo.backend.Token
import org.restopengov.Armadillo.backend.plugins._
import org.restopengov.Armadillo.formatters.json.TokenFormatter._
import akka.actor.{Actor, ActorRef}
import akka.actor.Props
import akka.dispatch.{Await, Future}
import akka.pattern.ask
import akka.util.Timeout
import akka.util.duration._
import play.api.libs.json.Json.toJson
import play.api.libs.json.JsValue

case class DispatcherResponse(json: JsValue)
 
class DispatcherActor extends Actor {

	private lazy val address = context.actorOf(Props[AddressActor], name = "address")
	implicit val timeout = Timeout(5 seconds)

	def receive = { 		
		case msg: String => {

			val futureAddress  = address ? msg
			val futureAddress2 = address ? msg

			val response = for {
		        result <- futureAddress
		        result2 <- futureAddress2
		    } yield {
		        DispatcherResponse(toJson(Seq(result.asInstanceOf[Token], result2.asInstanceOf[Token])))
		    }

		    sender ! response

		}
	}

}