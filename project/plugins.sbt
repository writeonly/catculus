libraryDependencies += "org.scala-js" %% "scalajs-env-selenium" % "1.1.1"

// core

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.11.0")
addSbtPlugin("org.typelevel" % "sbt-typelevel" % "0.4.22")
<<<<<<< HEAD
addSbtPlugin("org.jetbrains.scala" % "sbt-ide-settings" % "1.1.1")

addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.9.16")

// native

addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.14")
addSbtPlugin("org.portable-scala" % "sbt-scala-native-crossproject" % "1.3.2")

// js

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.13.2")
addSbtPlugin("org.scala-js" % "sbt-jsdependencies" % "1.0.2")
=======

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.0")
addSbtPlugin("org.typelevel" % "sbt-tpolecat" % "0.5.0")

//addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "1.2.2")
//addSbtPlugin("scalacenter" % "sbt-scalajs-bundler" % "0.21.1")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.21.1")

libraryDependencies ++= Seq("com.lihaoyi" %% "upickle" % "3.1.2")
>>>>>>> db3778c (Reduce sugar)
