package pl.writeonly.catculator.core.reducers

import pl.writeonly.catculator.core.UnitSpec
import pl.writeonly.catculator.core.adt.calculus.Combinator.I
import pl.writeonly.catculator.core.adt.calculus.Lambda.Com
import pl.writeonly.catculator.core.parsers.LambdaParser
import pl.writeonly.catculator.core.reducers.SugarReducer.lambdaSugarReducer

class LambdaTest extends UnitSpec {
  "A SugarReducer" should {
    "return argument for Combinator" in {
      val i = Com(I)
      lambdaSugarReducer.reduceSugar(i) shouldBe i
    }
  }
}
