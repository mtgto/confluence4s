package net.mtgto.confluence4s

/**
 * The entity model of the summary of space.
 *
 * @see https://developer.atlassian.com/display/CONFDEV/Remote+Confluence+Data+Objects#RemoteConfluenceDataObjects-SpaceSummary
 * @param key the space key
 * @param name the name of the space
 * @param url the url to view this space online
 */
case class SpaceSummary(
  key: String,
  name: String,
  url: String
)
