package net.mtgto.confluence4s

import org.codehaus.swizzle.confluence.{Confluence, Page => InnerPage, PageSummary => InnerPageSummary, SpaceSummary => InnerSpaceSummary}
import scala.collection.JavaConversions._
import java.util.{List => JList}

class DefaultClient(
  val innerClient: Confluence
) extends Client {
  def getSpaceSummaries = {
    innerClient.getSpaces.asInstanceOf[JList[InnerSpaceSummary]].map(
      innerSpaceSummary =>
        SpaceSummary(key = innerSpaceSummary.getKey,
                     name = innerSpaceSummary.getName,
                     url = innerSpaceSummary.getUrl)
    ).toSeq
  }

  def getPageSummaries(spaceKey: String): Seq[PageSummary] = {
    innerClient.getPages(spaceKey).asInstanceOf[JList[InnerPageSummary]].map(
      innerPageSummary =>
        PageSummary(id = innerPageSummary.getId,
                    space = innerPageSummary.getSpace,
                    parentId = innerPageSummary.getParentId,
                    title = innerPageSummary.getTitle,
                    url = innerPageSummary.getUrl,
                    locks = innerPageSummary.getLocks)
    )
  }

  def getPage(spaceKey: String, pageTitle: String): Page = {
    val innerPage = innerClient.getPage(spaceKey, pageTitle)
    convertInnerPageToPage(innerPage)
  }

  private def convertInnerPageToPage(innerPage: InnerPage): Page = {
    Page(
      id = innerPage.getId,
      space = innerPage.getSpace,
      parentId = innerPage.getParentId,
      title = innerPage.getTitle,
      url = innerPage.getUrl,
      version = innerPage.getVersion,
      content = innerPage.getContent,
      created = innerPage.getCreated,
      creator = innerPage.getCreator,
      modified = innerPage.getModified,
      modifier = innerPage.getModifier,
      homePage = innerPage.isHomePage,
      locks = innerPage.getLocks,
      contentStatus = innerPage.getContentStatus,
      current = innerPage.isCurrent)
  }

  def createPage(spaceKey: String, title: String, content: String, parentId: String): Page = {
    val page = new InnerPage
    page.setSpace(spaceKey)
    page.setTitle(title)
    page.setContent(content)
    page.setParentId(parentId)
    val createdPage = innerClient.storePage(page)
    convertInnerPageToPage(createdPage)
  }

  def movePage(page: Page, parentId: String): Page = {
    val innerPage = new InnerPage
    innerPage.setId(page.id)
    innerPage.setSpace(page.space)
    innerPage.setTitle(page.title)
    innerPage.setContent(page.content)
    innerPage.setVersion(page.version)
    innerPage.setParentId(parentId)
    val storedPage = innerClient.storePage(innerPage)
    convertInnerPageToPage(storedPage)
  }
}


