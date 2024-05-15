package pl.writeonly.catculator.core.reducers

import cats.Applicative
import cats.implicits._
import pl.writeonly.catculator.core.adt.calculus.Combinator._
import pl.writeonly.catculator.core.adt.calculus.Lambda
import pl.writeonly.catculator.core.adt.calculus.Lambda._
import pl.writeonly.catculator.core.adt.tree.BinaryTree._

object LambdaReducer {
  def toCombinatorBT(l: Lambda): Either[Lambda, CombinatorBT] = l match {
    case Com(c)    => Right(Leaf(c))
    case App(f, x) => Applicative[Either[Lambda, *]].map2(toCombinatorBT(f), toCombinatorBT(x))(Node.apply)
    case _         => Left(l)
  }
}
