package org.restopengov.Armadillo.backend.plugins

import org.restopengov.Armadillo.backend._
import org.restopengov.Armadillo.formatters.json.TokenFormatter._

class WordlistPlugin extends Plugin {
	
	def parse(input: String): Seq[Token] = { 
		Seq(new Token)
	}

}