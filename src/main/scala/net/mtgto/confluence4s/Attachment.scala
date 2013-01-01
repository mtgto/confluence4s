package net.mtgto.confluence4s

import java.util.Date

/**
 * The entity model of the attachment.
 *
 * @param id numeric id of the attachment
 * @param pageId page ID of the attachment
 * @param title title of the attachment
 * @param fileName file name of the attachment (Required)
 * @param fileSize numeric file size of the attachment in bytes
 * @param contentType mime content type of the attachment (Required)
 * @param created creation date of the attachment
 * @param creator creator of the attachment
 * @param url url to download the attachment online
 * @param comment comment for the attachment (Required)
 */
case class Attachment(
  id: String,
  pageId: String,
  title: String,
  fileName: String,
  fileSize: String,
  contentType: String,
  created: Date,
  creator: String,
  url: String,
  comment: String
)
