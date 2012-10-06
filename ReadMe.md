Armadillo
===========

Armadillo is a small REST-based Webservice that extracts meaningful information from a single text input. 

Spoilers: No NLP is involved, that's up to your implementation.

#### What the hell does 'meaningful information' mean then?
Well, in this case, what 'meaningful' information means is defined by the plugins you build. So it's really up to you. 

For instance, if your input is a blog post, you may want to extract and normalize street addresses, locations, theaters or movies contained in that text. That way you could make more sense of what tha post actually means. Each one of these would be a plugin, with it's own business logic. If you want to integrate it with some NLP framework, you could fine-tune the ontologies for each case.

#### How do these plugins work?
An Armadillo Plugin contains:

* An Akka Actor: This triggers the processing. Eg: AddressActor
* A container: This is basically just strategy pattern's context class. Eg: AddressPlugin
* One or more implementations: You can have one or more implemantations (strategies) of the same plugin, which makes it useful for testing, comparing results, switching implementations, etc. Eg: ListAddressPlugin, GoogleMapsAddressPlugin.

Note: All HTTP requests and all plugins are executed in a concurrent and non-blocking manner.

#### Tech
* Scala 
* Akka
* Play2-mini