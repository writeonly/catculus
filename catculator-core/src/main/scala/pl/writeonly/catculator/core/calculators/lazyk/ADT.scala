package pl.writeonly.catculator.core.calculators.lazyk

import pl.writeonly.catculator.core.adt.calculus.Combinator
import pl.writeonly.catculator.core.adt.calculus.Combinator.CombinatorBT
import pl.writeonly.catculator.core.adt.tree.BinaryTree
import pl.writeonly.catculator.core.adt.tree.BinaryTree._

import pl.writeonly.catculator.core.adt.calculus.Constants

import spire.math.Natural

enum ADT:
  case Com(c: Combinator)
  case Num(n: Natural)
  case Succ()

object ADT {

  type ADTBT = BinaryTree[ADT]

  val number0: ADTBT = Leaf(ADT.Num(Natural(0)))
  val trueVar: ADTBT = fromCombinatorBT(Constants.trueCom)
  val falseVar: ADTBT = fromCombinatorBT(Constants.falseCom)

  def fromCombinatorBT(c: CombinatorBT): ADTBT = c match {
    case Node(a, b) => Node(fromCombinatorBT(a), fromCombinatorBT(b))
    case Leaf(a) => Leaf(fromCombinator(a))
  }

  private def fromCombinator(c: Combinator): ADT = ADT.Com(c)

}