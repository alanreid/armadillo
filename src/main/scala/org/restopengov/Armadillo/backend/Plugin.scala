package org.restopengov.Armadillo.backend

import akka.actor.{Actor, ActorRef}

trait Plugin extends Actor {

	def receive = { 		
	    case msg: String => {
	    	val tokens = parse(msg)
	    	sender ! tokens
		}
  	}

	def parse(input: String): Token
}

case class Token(
  val category: String    = "undefined",
  val original: String    = "undefined",
  val text: String        = "undefined",
  val lat: Option[String] = None,
  val long: Option[String]= None,
  val tags: Seq[String]   = Seq[String]()
) 