package pl.writeonly.catculator.doobie

import munit._

class AnalysisTestSuite extends FunSuite with doobie.munit.IOChecker {

  override private val colors = doobie.util.Colors.None // just for docs

  private val transactor = Transactor.fromDriverManager[IO](
    driver = "org.postgresql.Driver", url = "jdbc:postgresql:world", user = "postgres", password = "password", logHandler = None
  )

  test("trivial")    { check(trivial)        }
  test("biggerThan") { checkOutput(biggerThan(0))  }
  test("update")     { check(update) }

}