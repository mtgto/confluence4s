// -*- scala -*-

name := "confluence4s"

organization := "net.mtgto"

version := "0.4.0-SNAPSHOT"

scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.1", "2.9.2")

scalacOptions ++= Seq("-deprecation", "-unchecked", "-encoding", "UTF8")

libraryDependencies ++= Seq(
  "org.apache.xmlrpc" % "xmlrpc-dist" % "3.1.3",
  "org.specs2" %% "specs2" % "1.12.3" % "test"
)

initialCommands := "import net.mtgto.confluence4s._"

publishTo := Some(Resolver.file("file", new File("maven/")))
