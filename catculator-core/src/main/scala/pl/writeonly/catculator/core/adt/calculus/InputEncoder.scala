package pl.writeonly.catculator.core.adt.calculus

import cats.implicits.catsSyntaxEq
import pl.writeonly.catculator.core.adt.calculus.Combinator.CombinatorBT
import pl.writeonly.catculator.core.adt.calculus.Constants.*
import spire.math.Natural

object InputEncoder {

  def readInput(input: String): CombinatorBT = encodeInput(
    input
      .toList
      .map { c =>
        Natural(c.toLong)
      },
  )

  private def encodeInput(input: List[Natural]): CombinatorBT = input
    .foldRight(falseCom) { case (n, l) =>
      cons(church(n), l)
    }

  def cons(a: CombinatorBT, b: CombinatorBT): CombinatorBT =
    app3(sCom, Constants.app3SI(appK(a)), appK(b))

  def church(n: Natural): CombinatorBT = n.toBigInt match {
    case n if n === BigInt(0) => falseCom
    case n                    => succChurch(Natural(n - BigInt(1)))
  }

  private def succChurch(n: Natural): CombinatorBT = successor(church(n))

  def successor(c: CombinatorBT): CombinatorBT = app3(sCom, bCom, c)

}
