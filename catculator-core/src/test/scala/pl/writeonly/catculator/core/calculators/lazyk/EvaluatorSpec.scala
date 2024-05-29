package pl.writeonly.catculator.core.calculators.lazyk

import mouse.all.anySyntaxMouse
import pl.writeonly.catculator.core.TableDrivenPropertySpec
import pl.writeonly.catculator.core.adt.calculus.Combinator.CombinatorBT
import pl.writeonly.catculator.core.adt.calculus.Constants.iCom
import pl.writeonly.catculator.core.calculators.lazyk.ADT.Safe
import pl.writeonly.catculator.core.calculators.lazyk.ADT.fromCombinatorBT

class EvaluatorSpec extends TableDrivenPropertySpec {

  def evalFromCombinatorBT(c: CombinatorBT): Safe[String] = c |> fromCombinatorBT |> (c => Evaluator.evalCombinator(c, ""))

  it should "run I" in {
    val result = evalFromCombinatorBT(iCom)
    println(s"result $result")
    result.value shouldBe ""
  }

}
