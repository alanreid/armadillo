package org.restopengov.Armadillo.backend

trait Plugin {
	def parse(input: String): Token
}

trait PluginContainer {
	def categorize(input: String): Token
}

case class Token(
  val category: String    = "undefined",
  val original: String    = "undefined",
  val text: String        = "undefined",
  val lat: Option[String] = None,
  val long: Option[String]= None,
  val tags: Seq[String]   = Seq[String]()
) 