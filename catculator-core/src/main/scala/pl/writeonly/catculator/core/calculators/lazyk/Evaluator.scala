package pl.writeonly.catculator.core.calculators.lazyk

import pl.writeonly.catculator.core.adt.calculus.InputEncoder.*
import pl.writeonly.catculator.core.adt.tree.BinaryTree.Node
import pl.writeonly.catculator.core.calculators.lazyk.ADT.ADTBT
import pl.writeonly.catculator.core.calculators.lazyk.ADT.Safe
import pl.writeonly.catculator.core.calculators.lazyk.ADT.fromCombinatorBT
import pl.writeonly.catculator.core.calculators.lazyk.Calculator.run
import pl.writeonly.catculator.core.calculators.lazyk.Reducer.reduce
import spire.math.Natural

import scala.annotation.tailrec

object Evaluator {

  def evalCombinator(combinator: ADTBT, input: String): Safe[String] =
    for c <- reduce(Node(combinator, fromCombinatorBT(readInput(input))))
      yield aaa(run(c)).map(_.toBigInt.toInt.toChar).mkString

  @tailrec
  private def aaa(a: Iterator[Safe[Natural]], acc: List[Natural] = List()): List[Natural] =
    a.nextOption match {
      case None => acc
      case Some(Left(e)) =>
        println(e)
        acc
      case Some(Right(e)) => aaa(a.drop(1), acc ++ List(e))
    }
}
