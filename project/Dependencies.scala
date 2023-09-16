import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import org.scalajs.jsdependencies.sbtplugin.JSDependenciesPlugin.autoImport._
import sbt._

object Dependencies {
  val scalaVersion = "3.3.0"

  // Core
  private val catsVersion = "2.9.0"
  private val catsEffectVersion = "3.5.1"
  private val catsMtlVersion = "1.3.1"
  private val fs2Version = "3.8.0"
  private val http4sVersion = "0.23.26"
  private val circeVersion = "0.14.1"
  private val jawnVersion = "1.5.1"
  private val doobieVersion = "1.0.0-RC4"
  private val scalaTestVersion = "3.2.16"
  private val spec2Version = "4.19.2"
  private val scalaMockVersion = "5.2.0"

  // Udash
  val udashVersion = "0.9.0"
  val udashJQueryVersion = "3.2.0"

  // Backend
  val jettyVersion = "9.4.51.v20230217"
  val logbackVersion = "1.3.5"
  val typesafeConfigVersion = "1.4.2"

  // JS dependencies
  val bootstrapVersion = "4.1.3"

  val catsDeps = Def.setting(Seq(
    "org.typelevel" %%% "cats-kernel" % catsVersion,
    "org.typelevel" %%% "cats-core" % catsVersion,
    "org.typelevel" %%% "cats-laws" % catsVersion,
    "org.typelevel" %%% "cats-free" % catsVersion,
    "org.typelevel" %%% "cats-testkit" % catsVersion,
    "org.typelevel" %%% "algebra" % catsVersion,
  ))
  val catsEffectDeps = Def.setting(Seq(
    "org.typelevel" %%% "cats-effect" % catsEffectVersion,
    "org.typelevel" %%% "cats-effect-kernel" % catsEffectVersion,
    "org.typelevel" %%% "cats-effect-laws" % catsEffectVersion % Test,
  ))
  val catsMtlDeps = Def.setting(Seq(
    "org.typelevel" %%% "cats-mtl" % catsMtlVersion,
    "org.typelevel" %%% "cats-mtl-laws" % catsMtlVersion % Test,
  ))
  val fs2Deps = Def.setting(Seq(
    "co.fs2" %%% "fs2-core" % fs2Version,
    "co.fs2" %%% "fs2-scodec" % fs2Version,
    "co.fs2" %%% "fs2-io" % fs2Version,
  ))

  val http4sDeps = Def.setting(Seq(
    "org.http4s" %% "http4s-ember-client" % http4sVersion,
    "org.http4s" %% "http4s-ember-server" % http4sVersion,
    "org.http4s" %% "http4s-dsl"          % http4sVersion,
    "org.http4s" %% "http4s-circe"        % http4sVersion,
  ))
  val circle = Def.setting(Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser"
  ).map(_ % circeVersion))
  val jawnDeps = Def.setting(Seq(
    "org.typelevel" %%% "jawn-parser" % jawnVersion,
    "org.typelevel" %%% "jawn-ast" % jawnVersion,
  ))
  val scalaTestDeps = Def.setting(Seq(
    "org.scalatest" %%% "scalatest-funspec" % scalaTestVersion % Test,
    "org.scalatest" %%% "scalatest-wordspec" % scalaTestVersion % Test,
  ))
  val specs2Deps = Def.setting(Seq(
    "org.specs2" %%% "specs2-core" % spec2Version % Test,
    "org.specs2" %%% "specs2-scalacheck" % spec2Version % Test,
  ))
  val munitDeps = Def.setting(Seq(
    "org.scalameta" %%% "munit" % "0.7.29" % Test,
    "org.scalameta" %%% "munit-scalacheck" % "0.7.29" % Test,
    "org.typelevel" %%% "munit-cats-effect-3" % "1.0.7" % Test,
  ))
  val disciplineDeps = Def.setting(Seq(
    "org.typelevel" %%% "discipline-core" % "1.5.1",
    "org.typelevel" %%% "discipline-scalatest" % "2.2.0" % Test,
    "org.typelevel" %%% "discipline-specs2" % "1.4.0" % Test,
    //    "org.typelevel" %%% "discipline-munit" % "1.0.9" % Test,
  ))
  val otherDeps = Def.setting(Seq(
    "org.typelevel" %%% "mouse" % "1.2.1",
    "org.typelevel" %%% "kittens" % "3.0.0",
    "org.typelevel" %%% "cats-collections-core" % "0.9.7",
    "org.typelevel" %%% "spire" % "0.18.0",
    "org.typelevel" %%% "cats-parse" % "0.3.10",
    "org.typelevel" %%% "log4cats-core" % "2.6.0",
    "org.scalacheck" %%% "scalacheck" % "1.17.0" % Test,
  ))

  // Dependencies for both frontend and backend
  // Those have to be cross-compilable
  val crossDeps = Def.setting(Seq(
    "io.udash" %%% "udash-rpc" % udashVersion,
    "io.udash" %%% "udash-rest" % udashVersion,
    "io.udash" %%% "udash-i18n" % udashVersion,
    "io.udash" %%% "udash-css" % udashVersion,
    "io.udash" %%% "udash-auth" % udashVersion,
  ))

  // Dependencies compiled to JavaScript code
  val frontendDeps = Def.setting(Seq(
    "org.scala-js" %%% "scalajs-dom" % "2.2.0"
  ))

  // JavaScript libraries dependencies
  // Those will be added into frontend-deps.js
  val frontendJSDeps = Def.setting(Seq(
    // "jquery.js" is provided by "udash-jquery" dependency
    "org.webjars" % "bootstrap" % bootstrapVersion /
      "js/bootstrap.bundle.js" minified "js/bootstrap.bundle.min.js" dependsOn "jquery.js",
  ))

  // Dependencies for JVM part of code
  val backendDeps = Def.setting(Seq(
    "io.udash" %% "udash-rpc" % udashVersion,
    "io.udash" %% "udash-rest" % udashVersion,
    "io.udash" %% "udash-i18n" % udashVersion,
    "io.udash" %% "udash-css" % udashVersion,

    "org.eclipse.jetty" % "jetty-server" % jettyVersion,
    "org.eclipse.jetty" % "jetty-rewrite" % jettyVersion,
    "org.eclipse.jetty.websocket" % "websocket-server" % jettyVersion,

    "com.typesafe" % "config" % typesafeConfigVersion,

    // server logging backend
    "ch.qos.logback" % "logback-classic" % logbackVersion,
  ))

  // Test dependencies
  val crossTestDeps = Def.setting(Seq(
    "org.scalatest" %%% "scalatest" % scalaTestVersion,
    "org.scalamock" %%% "scalamock" % scalaMockVersion
  ).map(_ % Test))
}
