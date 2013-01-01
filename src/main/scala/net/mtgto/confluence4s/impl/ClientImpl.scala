package net.mtgto.confluence4s.impl

import net.mtgto.confluence4s.{Client, ConfluenceException}
import net.mtgto.confluence4s.{Page, PageSummary, Position, Space, SpaceSummary}
import org.apache.xmlrpc.XmlRpcException
import org.apache.xmlrpc.client.XmlRpcClient
import scala.collection.JavaConversions._
import java.util.{List => JList, Map => JMap, Date, HashMap => JHashMap}

class ClientImpl(
  val innerClient: XmlRpcClient,
  val token: String
) extends Client {
  @throws(classOf[ConfluenceException])
  override def getSpaceSummaries = {
    try {
      val spaces = innerClient.execute("confluence2.getSpaces", Array[AnyRef](token)).asInstanceOf[Array[AnyRef]]
      spaces.map {
        space => {
          val map = space.asInstanceOf[JMap[String, AnyRef]]
          SpaceSummary(key = map.get("key").asInstanceOf[String],
                       name = map.get("name").asInstanceOf[String],
                       url = map.get("url").asInstanceOf[String])
        }
      }.toSeq
    } catch {
      case e: XmlRpcException => throw new ConfluenceException(e)
      case e => throw e
    }
  }

  private def convertMapToSpace(map: JMap[String, AnyRef]): Space = {
    Space(key = map.get("key").asInstanceOf[String],
          name = map.get("name").asInstanceOf[String],
          url = map.get("url").asInstanceOf[String],
          homePage = map.get("homePage").asInstanceOf[String],
          description = map.get("description").asInstanceOf[String]
        )
  }

  override def getSpace(key: String): Space = {
    try {
      val space = innerClient.execute("confluence2.getSpace", Array[AnyRef](token, key)).asInstanceOf[JMap[String, AnyRef]]
      convertMapToSpace(space)
    } catch {
      case e: XmlRpcException => throw new ConfluenceException(e)
      case e => throw e
    }
  }

  override def getPageSummaries(spaceKey: String): Seq[PageSummary] = {
    try {
      val pages = innerClient.execute("confluence2.getPages", Array[AnyRef](token, spaceKey)).asInstanceOf[Array[AnyRef]]
      pages.map {
        page => {
          val map = page.asInstanceOf[JMap[String, AnyRef]]
          PageSummary(id = map.get("id").asInstanceOf[String],
                      space = map.get("space").asInstanceOf[String],
                      parentId = map.get("parentId").asInstanceOf[String],
                      title = map.get("title").asInstanceOf[String],
                      url = map.get("url").asInstanceOf[String],
                      locks = map.get("locks").asInstanceOf[Int])
        }
      }
    } catch {
      case e: XmlRpcException => throw new ConfluenceException(e)
      case e => throw e
    }
  }

  private def getInt(o: AnyRef): Int = {
    if (o.isInstanceOf[java.lang.Integer]) {
      o.asInstanceOf[java.lang.Integer]
    } else if (o.isInstanceOf[String]) {
      o.asInstanceOf[String].toInt
    } else {
      throw new IllegalStateException("Value is unsupported type: " + o.getClass.getName)
    }
  }

  private def getBoolean(o: AnyRef): Boolean = {
    if (o.isInstanceOf[Boolean]) {
      o.asInstanceOf[Boolean]
    } else if (o.isInstanceOf[String]) {
      o.asInstanceOf[String].toBoolean
    } else {
      throw new IllegalStateException("Value is unsupported type: " + o.getClass.getName)
    }
  }

  private def convertMapToPage(map: JMap[String, AnyRef]): Page = {
    Page(id = map.get("id").asInstanceOf[String],
         space = map.get("space").asInstanceOf[String],
         parentId = map.get("parentId").asInstanceOf[String],
         title = map.get("title").asInstanceOf[String],
         url = map.get("url").asInstanceOf[String],
         version = getInt(map.get("version")),
         content = map.get("content").asInstanceOf[String],
         created = map.get("created").asInstanceOf[Date],
         creator = map.get("creator").asInstanceOf[String],
         modified = map.get("modified").asInstanceOf[Date],
         modifier = map.get("modifier").asInstanceOf[String],
         homePage = getBoolean(map.get("homePage")),
         locks = map.get("locks").asInstanceOf[Int],
         contentStatus = map.get("contentStatus").asInstanceOf[String],
         current = getBoolean(map.get("current"))
       )
  }

  override def getPage(spaceKey: String, pageTitle: String): Page = {
    try {
      val map = innerClient.execute("confluence2.getPage", Array[AnyRef](token, spaceKey, pageTitle)).asInstanceOf[JMap[String, AnyRef]]
      convertMapToPage(map)
    } catch {
      case e: XmlRpcException => throw new ConfluenceException(e)
      case e => throw e
    }
  }

  override def getPage(id: String): Page = {
    try {
      val map = innerClient.execute("confluence2.getPage", Array[AnyRef](token, id)).asInstanceOf[JMap[String, AnyRef]]
      convertMapToPage(map)
    } catch {
      case e: XmlRpcException => throw new ConfluenceException(e)
      case e => throw e
    }
  }

  override def createPage(spaceKey: String, title: String, content: String, parentId: String): Page = {
    val map: JMap[String, AnyRef] = new JHashMap[String, AnyRef]
    map.put("space", spaceKey)
    map.put("title", title)
    map.put("content", content)
    map.put("parentId", parentId)
    try {
      val page = innerClient.execute("confluence2.storePage", Array[AnyRef](token, map)).asInstanceOf[JMap[String, AnyRef]]
      convertMapToPage(page)
    } catch {
      case e: XmlRpcException => throw new ConfluenceException(e)
      case e => throw e
    }
  }

  override def movePage(pageId: String, parentId: String, position: Position.Value = Position.APPEND): Unit = {
    try {
      innerClient.execute("confluence2.movePage", Array[AnyRef](token, pageId, parentId, position.toString))
    } catch {
      case e: XmlRpcException => throw new ConfluenceException(e)
      case e => throw e
    }
  }
}


