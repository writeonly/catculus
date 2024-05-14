package pl.writeonly.catculator.core.calculators.lazyk

import pl.writeonly.catculator.core.adt.calculus.Combinator
import pl.writeonly.catculator.core.adt.calculus.Combinator._
import pl.writeonly.catculator.core.adt.tree.BinaryTree
import pl.writeonly.catculator.core.adt.tree.BinaryTree._
import pl.writeonly.catculator.core.calculators.lazyk.ADT._
import spire.math.Natural

import scala.util.Right

object Reducer {
  def reduce(f: ADTBT): ADTBTSafe = f match {
    case Node(x, y) => applyM(reduce(x), reduce(y))
    case x          => Right(x)
  }

  def applyM(fM: ADTBTSafe, xM: ADTBTSafe): ADTBTSafe =
    for
      f <- fM
      x <- xM
      r <- apply(f, x)
    yield r

  def flippedApply(x: ADTBT, y: ADTBT): ADTBTSafe = apply(y, x)

  def apply(f: ADTBT, x: ADTBT): ADTBTSafe = f match {
    case Leaf(ADT.Succ())                   => succ(x)
    case Node(Node(Leaf(ADT.Com(S)), z), y) => applyM(apply(z, x), apply(y, x))
    case Node(Leaf(ADT.Com(K)), y)          => Right(y)
    case Leaf(ADT.Com(I))                   => Right(x)
    case _                                  => Right(Node(f, x))
  }

  private def succ(x: ADTBT) = x match {
    case Leaf(ADT.Num(x)) => Right(Leaf(ADT.Num(x + Natural.one)))
    case _                => Left(s"attempted to apply inc to a non-number $x")
  }

}
