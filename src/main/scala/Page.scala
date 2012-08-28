package net.mtgto.confluence4s

import java.util.Date

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
