package pl.writeonly.catculator.core.calculators.lazyk

import pl.writeonly.catculator.core.adt.calculus.InputEncoder._
import pl.writeonly.catculator.core.adt.tree.BinaryTree.Node
import pl.writeonly.catculator.core.calculators.lazyk.ADT.ADTBT
import pl.writeonly.catculator.core.calculators.lazyk.ADT.Safe
import pl.writeonly.catculator.core.calculators.lazyk.ADT.fromCombinatorBT
import pl.writeonly.catculator.core.calculators.lazyk.Calculator.run
import pl.writeonly.catculator.core.calculators.lazyk.Reducer.reduce

object Evaluator {

  def evalCombinator(combinator: ADTBT, input: String): Safe[String] =
    for c <- reduce(Node(combinator, fromCombinatorBT(readInput(input))))
    yield run(c).map(_.toOption.get.toBigInt.toInt.toChar).mkString

}
