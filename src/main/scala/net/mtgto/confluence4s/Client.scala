package net.mtgto.confluence4s

trait Client {
  /**
   * get all space summaries of the confluence.
   */
  @throws(classOf[ConfluenceException])
  def getSpaceSummaries: Seq[SpaceSummary]

  /**
   * get all page summaries of specified space.
   *
   * @param spaceKey space to get the page summaries.
   */
  @throws(classOf[ConfluenceException])
  def getPageSummaries(spaceKey: String): Seq[PageSummary]

  /**
   * get the content of page specified by the space and title.
   *
   * @param spaceKey space to get the page content.
   * @param pageTitle title of the page.
   */
  @throws(classOf[ConfluenceException])
  def getPage(spaceKey: String, pageTitle: String): Page

  /**
   * create a new page in specified space.
   *
   * @param spaceKey the space to create a page.
   * @param title title of the new page.
   * @param content content of the new page.
   * @param parentId id of the parent page.
   */
  @throws(classOf[ConfluenceException])
  def createPage(spaceKey: String, title: String, content: String, parentId: String): Page

  /**
   * move the page have pageId to the children of parent page have parentId.
   *
   * @param pageId id of the page to move.
   * @param parentId id of the page to be parent.
   */
  @throws(classOf[ConfluenceException])
  def movePage(pageId: String, parentId: String, position: Position.Value = Position.APPEND): Unit
}
