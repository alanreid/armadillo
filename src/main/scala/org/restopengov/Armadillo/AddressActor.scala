package org.restopengov.Armadillo

import akka.actor.Actor
import akka.actor.Props
import org.restopengov.Armadillo.backend.plugins._
 
class AddressActor extends Actor {

  def receive = { 		
    case msg: String => {

    	val addressPlugin = new AddressPlugin with UsigAddressPlugin
    	val tokenSeq = addressPlugin.categorize(msg)

    	sender ! tokenSeq(0).text
	}
    case _ => sender ! "Sorry, AddressActor couldn't understand this message :(" 
  }

}