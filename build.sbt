// -*- scala -*-

name := "confluence4s"

organization := "net.mtgto"

version := "0.5.0-SNAPSHOT"

scalaVersion := "2.10.0"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0")

scalacOptions ++= Seq("-deprecation", "-unchecked", "-encoding", "UTF8")

libraryDependencies ++= Seq(
  "org.apache.xmlrpc" % "xmlrpc-dist" % "3.1.3",
  "org.specs2" %% "specs2" % "1.12.3" % "test"
)

initialCommands := "import net.mtgto.confluence4s._"

publishTo := Some(Resolver.file("file", new File("maven/")))
