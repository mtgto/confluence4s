package net.mtgto.confluence4s

object Main extends App {
  ClientFactory.withClient("http://localhost:1990/confluence/rpc/xmlrpc", "admin", "admin") {
    client => {
      val spaces = client.getSpaceSummaries
      println("spaces = " + spaces)
      val pages = client.getPageSummaries("SPACE")
      println("pages = " + pages)
      val page = client.getPage("SPACE", "XXXX-XX-XX")
      println("page = " + page)
      client.createPage(page.space, "2012-08-01", page.content, page.parentId)
    }
  }
}
