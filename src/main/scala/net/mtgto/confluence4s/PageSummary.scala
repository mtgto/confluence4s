package net.mtgto.confluence4s

/**
 * The entity model of the summary of page.
 *
 * @see https://developer.atlassian.com/display/CONFDEV/Remote+Confluence+Data+Objects#RemoteConfluenceDataObjects-PageSummary
 * @param id the id of the page
 * @param space the key of the space that this page belongs to
 * @param parentId the id of the parent page
 * @param title the title of the page
 * @param url the url to view this page online
 * @param locks the number of locks current on this page
 */
case class PageSummary(
  id: String,
  space: String,
  parentId: String,
  title: String,
  url: String,
  locks: Int
)
