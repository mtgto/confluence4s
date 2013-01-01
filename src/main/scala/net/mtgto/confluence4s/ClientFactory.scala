package net.mtgto.confluence4s

import impl.ClientImpl
import org.apache.xmlrpc.client.{XmlRpcClient, XmlRpcClientConfigImpl}
import java.net.URL

/**
 * ClientFactory that creates new Client that communicate with Confluence using xml rpc.
 */
object ClientFactory {
  def withClient(host: String, username: String, password: String)(f: Client => Unit) = {
    val clientConfig = new XmlRpcClientConfigImpl
    clientConfig.setServerURL(new URL(host))
    val inner = new XmlRpcClient
    inner.setConfig(clientConfig)
    val token = inner.execute("confluence2.login", Array[AnyRef](username, password)).asInstanceOf[String]
    try {
      val client = new ClientImpl(inner, token)
      f(client)
    } finally {
      val result = inner.execute("confluence2.logout", Array[AnyRef](token))
      println("logout result = " + result)
    }
  }
}
