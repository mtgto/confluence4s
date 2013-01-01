package net.mtgto.confluence4s

/**
 * destination positions of page.
 * @see https://developer.atlassian.com/display/CONFDEV/Confluence+XML-RPC+and+SOAP+APIs
 */
object Position extends Enumeration {
  val ABOVE = Value("above")

  val BELOW = Value("below")

  val APPEND = Value("append")
}
