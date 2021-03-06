package net.mtgto.confluence4s

/**
 * The client to access to Confluence.
 */
trait Client {
  /**
   * get all space summaries of the confluence.
   */
  @throws(classOf[ConfluenceException])
  def getSpaceSummaries: Seq[SpaceSummary]

  /**
   * get the space by its key.
   *
   * @param key the key of the space.
   */
  @throws(classOf[ConfluenceException])
  def getSpace(key: String): Space

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
   * get the content of page specified by id.
   *
   * @param id id of the page.
   */
  @throws(classOf[ConfluenceException])
  def getPage(id: String): Page

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

  /**
   * get all comments for the page.
   *
   * @param pageId id of the page to get comments.
   */
  @throws(classOf[ConfluenceException])
  def getComments(pageId: String): Seq[Comment]

  /**
   * get the specified comment.
   *
   * @param commentId id of the specified comment.
   */
  @throws(classOf[ConfluenceException])
  def getComment(commentId: String): Comment

  /**
   * create a comment in specified page.
   *
   * @param pageId id of the page to create a comment.
   * @param content content of a comment
   */
  @throws(classOf[ConfluenceException])
  def createComment(pageId: String, content: String): Comment

  /**
   * remove a comment.
   *
   * @param commentId id of the specified comment to be removed.
   */
  @throws(classOf[ConfluenceException])
  def removeComment(commentId: String): Boolean

  /**
   * get all attachments for the page.
   *
   * @param pageId id of the page to get attachments.
   */
  @throws(classOf[ConfluenceException])
  def getAttachments(pageId: String): Seq[Attachment]

  /**
   * get the data of the specified attachment (for current version).
   *
   * @param pageId id of the page to get the attachment.
   * @param fileName filename
   */
  @throws(classOf[ConfluenceException])
  def getAttachmentData(pageId: String, fileName: String): Array[Byte]
}
