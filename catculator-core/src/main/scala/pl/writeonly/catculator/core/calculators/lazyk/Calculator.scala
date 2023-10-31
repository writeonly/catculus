package pl.writeonly.catculator.core.calculators.lazyk

import pl.writeonly.catculator.core.adt.calculus.Combinator
import pl.writeonly.catculator.core.adt.calculus.Combinator._
import pl.writeonly.catculator.core.adt.tree.BinaryTree
import pl.writeonly.catculator.core.adt.tree.BinaryTree._
import pl.writeonly.catculator.core.calculators.lazyk.ADT._
import pl.writeonly.catculator.core.calculators.lazyk.Reducer.flippedApply
import spire.math.Natural

object Calculator {

  val number0: ADTBT = Leaf(ADT.Num(Natural(0)))

  val trueVar: ADTBT = Leaf(ADT.Com(K))

  val falseVar: ADTBT = Node(trueVar, Leaf(ADT.Com(I)))

  def run(program: ADTBT): Iterator[Safe[Natural]] = runWithTerminator(falseVar, program)

  private def runWithTerminator(terminator: ADTBT, combinator: ADTBT): Iterator[Safe[Natural]] =
    println("runWithTerminator2")
    Iterator.unfold[Safe[Natural], (ADTBT, Safe[ADTBT])](terminator, Right(combinator)) { case (t: ADTBT, cM: Safe[ADTBT]) =>
      val a = cM.flatMap(realizeWithTrue)
      val s = cM.flatMap(Reducer.flippedApply(t, _))
      Option(a, (t, s))
    }

  private def runWithTerminatorNumber(terminator: ADTBT, combinator: ADTBT): Safe[Unit] = realizeWithTrue(combinator).flatMap(output(terminator, combinator, _))

  def realizeWithTrue(combinator: ADTBT): Safe[Natural] = flippedApply(trueVar, combinator).flatMap(realize)

  def realize(combinator: ADTBT): Safe[Natural] = flippedApply(Leaf(ADT.Succ()), combinator).flatMap(flippedApply(number0, _)).flatMap(naturalSafe)

  private def naturalSafe(combinator: ADTBT): Safe[Natural] = combinator match {
    case Leaf(ADT.Num(x)) => Right(x)
    case x                => Left(s"Invalid output format. Output should be the list of Church numerals. $x")
  }

  private def output(terminator: ADTBT, combinator: ADTBT, number: Natural): Safe[Unit] = Reducer
    .apply(combinator, terminator)
    .flatMap(runWithTerminatorNumber(terminator, _))

}
