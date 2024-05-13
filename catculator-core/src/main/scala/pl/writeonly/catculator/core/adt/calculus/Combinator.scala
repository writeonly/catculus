package pl.writeonly.catculator.core.adt.calculus

import pl.writeonly.catculator.core.adt.tree._

enum Combinator:
  case S
  case K
  case I

object Combinator {

  type CombinatorT = Tree[Combinator]
  type CombinatorBT = BinaryTree[Combinator]

  extension (self: CombinatorT)
    def generateT: String = self match {
      case Tree.Leaf(a) => a.generateC
      case Tree.Node(a) => s"(${a.map(_.generateT).toList.mkString(" ")})"
    }

  extension (self: CombinatorBT)
    def generateBT: String = self match {
      case BinaryTree.Leaf(a)    => a.generateC
      case BinaryTree.Node(a, b) => s"`${a.generateBT} ${b.generateBT}"
    }

  extension (self: Combinator)
    def generateC: String = self.toString
}
