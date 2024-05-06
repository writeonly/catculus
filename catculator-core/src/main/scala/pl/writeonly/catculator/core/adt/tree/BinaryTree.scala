package pl.writeonly.catculator.core.adt.tree

enum BinaryTree[+A]:
  case Leaf(leaf: A)
  case Node(first: BinaryTree[A], follow: BinaryTree[A])

object BinaryTree {
}
