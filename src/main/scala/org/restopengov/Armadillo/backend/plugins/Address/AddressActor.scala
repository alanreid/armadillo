package org.restopengov.Armadillo.backend.plugins.Address

import akka.actor.Actor
import akka.actor.Props
import org.restopengov.Armadillo.backend.plugins._
import org.restopengov.Armadillo.backend.plugins.Address._
 
class AddressActor extends Actor {

  def receive = { 		
    case msg: String => {

    	val addressPlugin = new AddressPlugin with UsigAddressPlugin
    	val tokens = addressPlugin.categorize(msg)

    	sender ! tokens
	}
  }

}