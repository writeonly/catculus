package pl.writeonly.catculator.core.adt.calculus

import pl.writeonly.catculator.core.adt.calculus.Combinator.CombinatorBT
import pl.writeonly.catculator.core.adt.tree.BinaryTree.*

object Constants {
  val sCom: CombinatorBT = com(Combinator.S)
  val kCom: CombinatorBT = com(Combinator.K)
  val iCom: CombinatorBT = com(Combinator.I)
  val trueCom: CombinatorBT = kCom
  val falseCom: CombinatorBT = Node(kCom, iCom)

  val appKS: CombinatorBT = Node(kCom, sCom)

  val bCom: CombinatorBT = app3(sCom, appKS, kCom)

  def app3SI(a: CombinatorBT): CombinatorBT = app3(sCom, iCom, a)

  def appK(a: CombinatorBT): Node[Combinator] = Node(kCom, a)

  def app4(
    c1: CombinatorBT,
    c2: CombinatorBT,
    c3: CombinatorBT,
    c4: CombinatorBT,
  ): CombinatorBT = Node(c1, app3(c2, c3, c4))

  def app3(c1: CombinatorBT, c2: CombinatorBT, c3: CombinatorBT): CombinatorBT =
    Node(c1, Node(c2, c3))

  def com(c: Combinator): CombinatorBT = Leaf(c)

}
