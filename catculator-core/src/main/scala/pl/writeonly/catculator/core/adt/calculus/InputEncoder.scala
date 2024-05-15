package pl.writeonly.catculator.core.adt.calculus

import pl.writeonly.catculator.core.adt.calculus.Combinator.CombinatorBT
import pl.writeonly.catculator.core.adt.calculus.Constants._
import spire.math.Natural

object InputEncoder {

  def readInput(input: String): CombinatorBT = encodeInput(
    input
      .toList
      .map { c =>
        Natural(c.toLong)
      },
  )

  def encodeInput(input: List[Natural]): CombinatorBT = input.foldRight(falseCom) { case (n, l) =>
    cons(church(n), l)
  }

  def cons(a: CombinatorBT, b: CombinatorBT): CombinatorBT = app3(sCom, Constants.app3SI(appK(a)), appK(b))

  def church(n: Natural): CombinatorBT = n match {
    case n if n === Natural.zero => falseCom
    case n                       => succChurch(n - Natural.one)
  }

  private def succChurch(n: Natural): CombinatorBT = successor(church(n))

  def successor(c: CombinatorBT): CombinatorBT = app3(sCom, bCom, c)

}
