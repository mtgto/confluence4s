package net.mtgto.confluence4s

import java.util.Date

/**
 * The entity model of the page.
 *
 * @see https://developer.atlassian.com/display/CONFDEV/Remote+Confluence+Data+Objects#RemoteConfluenceDataObjects-Page
 * @param id the id of the page
 * @param space the key of the space that this page belongs to
 * @param parentId the id of the parent page
 * @param title the title of the page
 * @param url the url to view this page online
 * @param version the version number of this page
 * @param content the page content
 * @param created timestamp page was created
 * @param creator username of the creator
 * @param modified timestamp page was modified
 * @param modifier username of the page's last modifier
 * @param homePage whether or not this page is the space's homepage
 * @param locks the number of locks current on this page
 * @param contentStatus status of the page (eg. current or deleted)
 * @param current whether the page is current and not deleted
 */
case class Page(
  id: String,
  space: String,
  parentId: String,
  title: String,
  url: String,
  version: Int,
  content: String,
  created: Date,
  creator: String,
  modified: Date,
  modifier: String,
  homePage: Boolean,
  locks: Int,
  contentStatus: String,
  current: Boolean
)
