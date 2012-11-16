package armadillo.categorizer.plugins.wordlist

import armadillo.categorizer.formatters.json.SimpleTokenFormatter._
import armadillo.categorizer.SimpleToken

case class WordlistTokenFile(
  file: String              = "unknown file",
  tags: List[String]        = List(),
  tokens: List[SimpleToken] = List()
)

object WordlistTokenFile {

  def fromCSV(file: String): WordlistTokenFile = {
    WordlistTokenFile()
  }

}