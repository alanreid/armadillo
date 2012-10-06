package org.restopengov.Armadillo

import com.typesafe.play.mini._
import com.typesafe.mini._
import play.api.mvc._
import play.api.mvc.Results._
import play.api.libs.concurrent._
import akka.actor.{ ActorSystem, Props}
import akka.dispatch.{Await, Future}
import akka.pattern.ask
import akka.util.Timeout
import akka.util.duration._
import java.util.ArrayList

object Armadillo extends Application {

	private val system = ActorSystem("armadillo")
	private lazy val dispatcher = system.actorOf(Props[DispatcherActor], name = "dispatcher")
	implicit val timeout = Timeout(5 seconds)

	def route = {

		case GET(Path("/")) & QueryString(qs) => Action { 

			val input = QueryString(qs, "input").getOrElse(Array("")).asInstanceOf[ArrayList[String]].get(0)
			
	        val futureResponse = ask(dispatcher, input).mapTo[Future[Future[DispatcherResponse]]]
	        val dispatcherResponse = futureResponse flatMap { x => x }

	        AsyncResult {
				dispatcherResponse.mapTo[DispatcherResponse].asPromise.map { r => 
					Ok(r.json)
				}
 			}	

		}

		case GET(Path("/")) => Action { 
			Ok("ERROR: Please provide an input text") 
		}

	}

}