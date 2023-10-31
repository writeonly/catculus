package pl.writeonly.catculator.core.calculators.lazyk

import mouse.all.anySyntaxMouse
import org.scalatest.prop.TableFor1
import pl.writeonly.catculator.core.TableDrivenPropertySpec
import pl.writeonly.catculator.core.adt.calculus.Combinator.CombinatorBT
import pl.writeonly.catculator.core.adt.calculus.Constants._
import pl.writeonly.catculator.core.adt.calculus.InputEncoder._
import pl.writeonly.catculator.core.calculators.lazyk.ADT._
import spire.math.Natural

class CalculatorSpec extends TableDrivenPropertySpec {

  val numbers: TableFor1[Long] = Table("number", 0, 1, 4, 8, 9, 16, 27, 36, 64, 81, 100, 121, 125, 256)

  def realizeFromCombinatorBT(c: CombinatorBT): Safe[Natural] = c |> fromCombinatorBT |> Calculator.realize

  it should "realize false" in {
    val result = realizeFromCombinatorBT(falseCom)
    result.value shouldBe Natural.zero
  }

  it should "realize I" in {
    val result = realizeFromCombinatorBT(iCom)
    result.value shouldBe Natural.one
  }

  it should "realize successor false" in {
    val c = successor(falseCom)
    val result = realizeFromCombinatorBT(c)
    result.value shouldBe Natural.one
  }

  it should "realize numbers" in {
    forAll(numbers) { number =>
      val natural = Natural(number)
      val c = church(natural)
      val result = realizeFromCombinatorBT(c)
      result.value shouldBe natural
    }
  }
}
