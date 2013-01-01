package net.mtgto.confluence4s

import java.util.Date

/**
 * The entity model of the comment.
 *
 * @see https://developer.atlassian.com/display/CONFDEV/Remote+Confluence+Data+Objects#RemoteConfluenceDataObjects-Comment
 * @param id numeric id of the comment
 * @param pageId page ID of the comment
 * @param title title of the comment
 * @param content notated content of the comment (use renderContent to render)
 * @param url url to view the comment online
 * @param created creation date of the attachment
 * @param creator creator of the attachment
 */
case class Comment(
  id: String,
  pageId: String,
  title: String,
  content: String,
  url: String,
  created: Date,
  creator: String
)
