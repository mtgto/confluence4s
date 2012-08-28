confluence4s
========
confluence4s is a library to easily access to Atlassian Confluence XML-RPC API written by Scala.

Fow now, confluence4s has following features.

- get all space summaries
- get all page summaries
- create a new page
- move a page to another child page

confluence4s uses [Apache XML-RPC](http://ws.apache.org/xmlrpc/index.html).

# Getting started
confluence4s currently does not have a maven repository.

you need to publish yourself.

```
$ sbt publish-local
```

# How to use
```scala
import net.mtgto.confluence4s._

object Main extends App {
	ClientFactory.withClient("http://YOURCONFLUENCE/rpc/xmlrpc", "username", "password") {
		client => {
			// get all space summaries
			val spaces = client.getSpaceSummaries
			spaces.foreach (println)
			// get all page summaries
			val pages = client.getPageSummaries(spaces.head.key)
			pages.foreach (println)
			// create a new page
			val page = client.createPage(spaces.head.key, "test page", "this is test", pages.head.id)
			// move a page to another child
			client.movePage(page, pages.last.id)
		}
	}
}
```
