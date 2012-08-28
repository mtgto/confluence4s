package net.mtgto.confluence4s

trait Client {
  def getSpaceSummaries: Seq[SpaceSummary]
  
  def getPageSummaries(spaceKey: String): Seq[PageSummary]

  def getPage(spaceKey: String, pageTitle: String): Page

  def createPage(spaceKey: String, title: String, content: String, parentId: String): Page

  def movePage(page: Page, parentId: String): Unit
}