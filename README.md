confluence4s
========
confluence4s is a library to easily access to Atlassian Confluence XML-RPC API written by Scala.

Fow now, confluence4s has following features.

- get all space summaries
- get all page summaries
- create a new page
- move a page to another child page

confluence4s uses [Apache XML-RPC](http://ws.apache.org/xmlrpc/index.html).

# How to use
First, you add maven repository of confuence4s to your configuration.
Next, you add confluence4s to library dependencies.

If you use sbt, you write like below:

```
resolvers += "confluence4s repos" at "http://mtgto.github.com/confluence4s/maven/"

libraryDependencies += "net.mtgto" %% "confluence4s" % "0.3.0"
```

Now, you write the program to access confluence.

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
			client.movePage(page.id, pages.last.id, Position.APPEND)
		}
	}
}
```

# Licenses
# Confluence4s
Confluence4s is Licensed under the BSD license.

For detail, see `LICENSE`.

# Apache XML-RPC
`Apache XML-RPC` is Licensed under the Apache License, Version 2.0(http://www.apache.org/licenses/LICENSE-2.0).
