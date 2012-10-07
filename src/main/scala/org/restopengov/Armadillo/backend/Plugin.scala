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
  val lat: Option[Double] = None,
  val long: Option[Double]= None,
  val tags: Seq[String]   = Seq[String]()
) 