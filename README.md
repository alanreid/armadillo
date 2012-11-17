Armadillo
===========

Armadillo is a small REST-based Webservice that extracts meaningful information from a single text input. This makes it useful for auto-tagging and data categorization.

#### What the hell does 'meaningful information' mean?
Well, in this case, what 'meaningful' information means is defined by the plugins you build. So it's really up to you. 

For instance, if your input is a blog post, you may want to extract and normalize street addresses, locations, theaters or movies contained in that text. That way you could make more sense of what tha post actually means. Each one of these would be a plugin, with it's own business logic. If you want to integrate it with some NLP framework, you could fine-tune the ontologies for each case.

#### How do these plugins work?
An Armadillo Plugin is basically an Akka Actor, which receives a text and returns a list of Tokens.
All plugins get the same input text and try to extract information of interest. Once something is found, each plugin returns a list of found items (Tokens).
All these lists are later joined, converted to JSON and returned as a HTTP response.

#### Tech
* Scala 
* Akka
* Play2-mini

#### Currently available plugins
* UsigAddressPlugin: Detection and geolocation of streets of the City of Buenos Aires
* WordlistPlugin: Detection and geolocalization of tokens in a dictionary. 

Current Wordlist dictionaries:
  * Neighbourhoods of Buenos Aires
  * Police Stations of Buenos Aires
  * Nightclubs and Discos of Buenos Aires
  * Football teams of Argentina
  * Hospitals of Buenos Aires
  * Argentine politicians
  * Places in Buenos Aires
  * Tags
  * Theaters in Buenos Aires

#### Getting started

```
sbt run
```

##### Example

Say we want to get some feedback from this text:
```
El general perón, baila en metropolis, la mejor disco de palermo, a metros del obelisco, y a pasitos de la bombonera 
(aunque el general era de river), pero siempre terminaba en la comisaria 12, donde lo ponen a reciclar paples
```
(nope, this text is doesn't make any sense at all :D )

All you do is make a GET HTTP request and pass it through the 'input' param:
```
curl http://localhost:9000/?input=El%20general%20perón,%20baila%20en%20metropolis,%20la%20mejor%20disco%20de%20palermo,%20a%20metros%20del%20obelisco,%20y%20a%20pasitos%20de%20la%20bombonera%20(aunque%20el%20general%20era%20de%20river),%20pero%20siempre%20terminaba%20en%20la%20comisaria%2012,%20donde%20lo%20ponen%20a%20reciclar%20paples
```

and you get the following response:
```
[{
    "lng": -99.2388237,
    "tags": [],
    "text": "Bosques de Palermo",
    "category": "sitios",
    "original": "palermo",
    "lat": 19.4296872
}, {
    "lng": -58.381581,
    "tags": ["monumento", "turismo"],
    "text": "El Obelisco",
    "category": "sitios",
    "original": "obelisco",
    "lat": -34.603722
}, {
    "lng": -58.36473439999999,
    "tags": ["fútbol", "turismo"],
    "text": "Estadio Boca Juniors",
    "category": "sitios",
    "original": "bombonera",
    "lat": -34.6366437
}, {
    "lng": -58.4494717,
    "tags": ["fútbol"],
    "text": "Estadio River Plate",
    "category": "sitios",
    "original": "river",
    "lat": -34.54667999999999
}, {
    "lng": null,
    "tags": ["fútbol"],
    "text": "River Plate",
    "category": "futbol",
    "original": "river",
    "lat": null
}, {
    "lng": -58.4305556,
    "tags": ["barrio"],
    "text": "PALERMO",
    "category": "barrios",
    "original": "palermo",
    "lat": -34.5888889
}, {
    "lng": -58.4481773,
    "tags": ["comisaria"],
    "text": "Comisaria 12",
    "category": "comisarias",
    "original": "comisaria 12",
    "lat": -34.6266216
}, {
    "lng": -58.4232799,
    "tags": ["entretenimiento", "disco"],
    "text": "Disco NEW METROPOLIS",
    "category": "disco",
    "original": "metropolis",
    "lat": -34.57971980000001
}, {
    "lng": null,
    "tags": ["ecologia"],
    "text": "ecología",
    "category": "tags",
    "original": "reciclar",
    "lat": null
}]
```


#### Projects using Armadillo
* [IdeasBA.org](http://ideasba.org) is a social brainstorming platform for cities.


#### Collaborators
Special props to [opensas](http://github.com/opensas) and [martinmoscovich](http://github.com/martinmoscovich), who are responsable for the last ton of improvements. 


#### Contact me
You can contact me at mail [at] alanreid.com.ar or get in touch on Twitter: [@alan_reid](http://twitter.com/alan_reid)

#### License
Apache 2.0: http://www.apache.org/licenses/LICENSE-2.0