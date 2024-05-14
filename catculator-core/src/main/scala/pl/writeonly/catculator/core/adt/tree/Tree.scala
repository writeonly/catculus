package pl.writeonly.catculator.core.adt.tree

import cats.data.NonEmptyList

enum Tree[A]:
  case Leaf(leaf: A)
  case Node(children: NonEmptyList[Tree[A]])

object Tree {
  def node[A](head: Tree[A], tail: Tree[A]*): Tree[A] = Node(NonEmptyList(head, tail.toList))
}
