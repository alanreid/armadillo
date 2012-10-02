package org.restopengov.Armadillo.backend.plugins
	
import org.restopengov.Armadillo.backend._

trait AddressPlugin extends PluginContainer {
	self: Plugin =>
		def categorize(input: String) = parse(input) 
}

trait UsigAddress extends Plugin {
	def parse(input: String): Seq[Token] = { 
		val modified = input + " pasó por el plugin de la USIG"
		val token = new Token(text=modified)
		Seq(token)
	}
}

trait ArrayAddress extends Plugin {
	def parse(input: String): Seq[Token] = { 
		val modified = input + " pasó por el plugin con arrays"
		val token = new Token(text=modified)
		Seq(token)
	}
}
