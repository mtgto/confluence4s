// -*- scala -*-

name := "confluence4s"

organization := "net.mtgto"

version := "0.3.0-SNAPSHOT"

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-encoding", "UTF8")

libraryDependencies ++= Seq(
  "org.sisioh" % "scala-dddbase-core_2.9.1" % "0.0.1",
  "org.apache.xmlrpc" % "xmlrpc-dist" % "3.1.3",
  "org.specs2" %% "specs2" % "1.12.1" % "test"
)

resolvers ++= Seq(
  "Sisioh Maven Relase Repository" at "http://maven.sisioh.org/release/",
  "Sisioh Maven Snapshot Repository" at "http://maven.sisioh.org/snapshot/"
)

initialCommands := "import net.mtgto.confluence4s._"
