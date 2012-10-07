package org.restopengov.Armadillo.backend.plugins
	
import org.restopengov.Armadillo.backend._

trait AddressPlugin extends PluginContainer {
	self: Plugin =>
		def categorize(input: String) = parse(input) 
}

trait UsigAddressPlugin extends Plugin {
	def parse(input: String): Token = { 
		val modified = input + " pasó por el plugin de la USIG"
		new Token(
			original= input,
			text= modified,
			category= "Lugar",
			lat= Option(-52.123123123),
			long= Option(-36.123123123),
			tags= Seq("Ejemplo", "USIG", "Lugar")
		)
	}
}

trait ArrayAddressPlugin extends Plugin {
	def parse(input: String): Token = { 
		val modified = input + " pasó por el plugin con arrays"
		new Token(text=modified)
	}
}
