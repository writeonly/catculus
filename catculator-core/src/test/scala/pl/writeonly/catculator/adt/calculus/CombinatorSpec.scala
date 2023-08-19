<<<<<<<< HEAD:catculator-core/src/test/scala/pl/writeonly/catculator/core/adt/calculus/CombinatorSpec.scala
package pl.writeonly.catculator.core.adt.calculus

import pl.writeonly.catculator.core.TableDrivenPropertySpec
import pl.writeonly.catculator.core.adt.calculus.Combinator.*

class CombinatorSpec extends TableDrivenPropertySpec {
  it should "generate code for BinaryTree of Combinators" in {
    import pl.writeonly.catculator.core.adt.tree.BinaryTree.*
========
package pl.writeonly.catculator.adt.calculus

import pl.writeonly.catculator.TableDrivenPropertySpec
import pl.writeonly.catculator.adt.calculus.Combinator._

class CombinatorSpec extends TableDrivenPropertySpec {
  it should "generate code for BinaryTree of Combinators" in {
    import pl.writeonly.catculator.adt.tree.BinaryTree._
>>>>>>>> db3778c (Reduce sugar):catculator-core/src/test/scala/pl/writeonly/catculator/adt/calculus/CombinatorSpec.scala
    val combinators = Table(
      ("ast", "code"),
      (Leaf(I), "I"),
      (Node(Leaf(S), Node(Leaf(K), Leaf(K))), "`S `K K"),
    )
    forAll(combinators) { (ast, code) =>
      generateBT(ast) shouldBe code
    }
  }

  it should "generate code for Tree of Combinators" in {
<<<<<<<< HEAD:catculator-core/src/test/scala/pl/writeonly/catculator/core/adt/calculus/CombinatorSpec.scala
    import pl.writeonly.catculator.core.adt.tree.Tree.*
========
    import pl.writeonly.catculator.adt.tree.Tree._
>>>>>>>> db3778c (Reduce sugar):catculator-core/src/test/scala/pl/writeonly/catculator/adt/calculus/CombinatorSpec.scala
    val combinators = Table(
      ("ast", "code"),
      (Leaf(I), "I"),
      (node(Leaf(S), node(Leaf(K), Leaf(K))), "(S (K K))"),
    )
    forAll(combinators) { (ast, code) =>
      generateT(ast) shouldBe code
    }
  }
}
