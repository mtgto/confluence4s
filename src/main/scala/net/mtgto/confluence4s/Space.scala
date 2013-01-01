package net.mtgto.confluence4s

/**
 * The entity model of the space.
 *
 * @see https://developer.atlassian.com/display/CONFDEV/Remote+Confluence+Data+Objects#RemoteConfluenceDataObjects-Space
 * @param key the space key
 * @param name the name of the space
 * @param url the url to view this space online
 * @param homePage the id of the space homepage
 * @param description the HTML rendered space description
 */
case class Space(
  key: String,
  name: String,
  url: String,
  homePage: String,
  description: String
)
