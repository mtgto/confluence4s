package net.mtgto.confluence4s

import org.codehaus.swizzle.confluence.Confluence
/**
 * ClientFactory that creates new Client that communicate with Confluence using xml rpc.
 */
object ClientFactory {
  def withClient(host: String, username: String, password: String)(f: Client => Unit) = {
    val inner = new Confluence(host)
    inner.login(username, password)
    try {
      val client = new DefaultClient(inner)
      f(client)
    } finally {
      inner.logout
    }
  }
}
