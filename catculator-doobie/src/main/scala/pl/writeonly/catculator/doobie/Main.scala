package pl.writeonly.catculator.doobie

import doobie._
import doobie.implicits._

import cats._
import cats.effect._
import cats.implicits._

import doobie.util.ExecutionContexts
import cats.effect.unsafe.implicits.global

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    val xa = Transactor.fromDriverManager[IO](
      driver = "org.postgresql.Driver", // JDBC driver classname
      url = "jdbc:postgresql:world", // Connect URL
      user = "postgres", // Database user name
      password = "password", // Database password
      logHandler = None // Don't setup logging for now. See Logging page for how to log events in detail
    )

    val program1: ConnectionIO[(Int, Double)] =
      for {
        a <- sql"select 42".query[Int].unique
        b <- sql"select random()".query[Double].unique
      } yield (a, b)

    val io = program1.transact(xa)
    io.as(ExitCode.Success)
  }

}
