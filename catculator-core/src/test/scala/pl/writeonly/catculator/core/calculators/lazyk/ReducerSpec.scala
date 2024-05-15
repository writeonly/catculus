package pl.writeonly.catculator.core.calculators.lazyk

import pl.writeonly.catculator.core.UnitSpec
import pl.writeonly.catculator.core.adt.calculus.Combinator._
import pl.writeonly.catculator.core.adt.tree.BinaryTree._
import pl.writeonly.catculator.core.calculators.lazyk.ADT._
import pl.writeonly.catculator.core.calculators.lazyk.Reducer._

class ReducerSpec extends UnitSpec {
  "A Reducer" should {
    val idVar = Leaf(Com(I))
    val succ = Leaf(Succ())

    "return 1 for succ zero" in {
      reduce(Node(succ, number0)).value shouldBe number1
    }

    "return 0 for I 0" in {
      reduce(Node(idVar, number0)).value shouldBe number0
    }

    "return 0 for K 0 1" in {
      reduce(Node(Node(trueVar, number0), number1)).value shouldBe number0
    }

    "return 1 for F 0 1" in {
      reduce(Node(Node(falseVar, number0), number1)).value shouldBe number1
    }

    "return 0 for S K + 0" in {
      reduce(Node(Node(Node(Leaf(Com(S)), trueVar), succ), number0)).value shouldBe number0
    }
  }
}
