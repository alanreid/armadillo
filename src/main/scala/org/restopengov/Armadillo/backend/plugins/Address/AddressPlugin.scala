package org.restopengov.Armadillo.backend.plugins.Address
	
import org.restopengov.Armadillo.backend._
import org.restopengov.Armadillo.backend.plugins.Address._
import org.restopengov.Armadillo.formatters.json.TokenFormatter._
import play.api.libs.json.Json


trait AddressPlugin extends PluginContainer {
	self: Plugin =>
		def categorize(input: String) = parse(input) 
}


