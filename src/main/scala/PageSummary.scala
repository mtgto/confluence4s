package net.mtgto.confluence4s

case class PageSummary(
  id: String,
  space: String,
  parentId: String,
  title: String,
  url: String,
  locks: Int
)
