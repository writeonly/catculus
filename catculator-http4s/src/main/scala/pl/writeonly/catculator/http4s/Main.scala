package pl.writeonly.catculator.http4s

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple:
  val run = QuickstartServer.run[IO]
