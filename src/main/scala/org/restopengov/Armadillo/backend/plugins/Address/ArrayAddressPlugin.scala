package org.restopengov.Armadillo.backend.plugins.Address

import org.restopengov.Armadillo.backend._
import org.restopengov.Armadillo.formatters.json.TokenFormatter._
import play.api.libs.json.Json

trait ArrayAddressPlugin extends Plugin {
	def parse(input: String): Token = { 
		val modified = input + " was received by ArrayAddressPlugin"
		Token(text = modified)
	}
}