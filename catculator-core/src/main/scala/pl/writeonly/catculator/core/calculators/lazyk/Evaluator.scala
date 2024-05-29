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
    yield output(List(), run(c)).map(_.toBigInt.toInt.toChar).mkString

  @tailrec
  private def output(acc: List[Natural], input: Iterator[Safe[Natural]]): List[Natural] = input.nextOption match {
    case None =>
      println("output none")
      acc
    case Some(Left(e)) =>
      println(s"output Left e $e")
      acc
    case Some(Right(e)) =>
      println(s"output Right e $e")
      output(acc ++ List(e), input)
  }
}
