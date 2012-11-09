package org.restopengov.Armadillo.backend.plugins

import org.restopengov.Armadillo.backend._
import org.restopengov.Armadillo.formatters.json.TokenFormatter._
import play.api.libs.json.Json
import play.api.libs.json.{JsArray, JsObject}

class WordlistPlugin extends Plugin {
	
	def parse(input: String): Seq[Token] = { 

		val lines = scala.io.Source.fromFile("src/main/scala/org/restopengov/Armadillo/backend/plugins/Wordlist/tokenListSample.es.json").mkString
		val json = Json.parse(lines)

		val globalTags = json \ "tags"

		(json \ "tokens") match {
			case arr: JsArray => {
				arr.value.collect {
					case item if input.toLowerCase contains  => 
						new Token(
							original=input,
							text=(item \ "token").as[String].toLowerCase,
							lat=(item \ "geo" \ "lat").as[Option[String]],
							long=(item \ "geo" \ "lng").as[Option[String]]
						)
				}
			}
		}

	}

}