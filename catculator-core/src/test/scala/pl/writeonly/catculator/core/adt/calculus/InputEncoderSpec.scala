package pl.writeonly.catculator.core.adt.calculus

import pl.writeonly.catculator.core.TableDrivenPropertySpec
import pl.writeonly.catculator.core.adt.calculus.Combinator._
import pl.writeonly.catculator.core.adt.calculus.Constants._
import pl.writeonly.catculator.core.adt.tree.BinaryTree._
import spire.math.Natural

class InputEncoderSpec extends TableDrivenPropertySpec {

  private val oneCom = Node(Node(Leaf(S), Node(Node(Leaf(S), Node(Leaf(K), Leaf(S))), Leaf(K))), Node(Leaf(K), Leaf(I)))
  private val zeroListCom = Node(Node(Leaf(S), Node(Node(Leaf(S), Leaf(I)), Node(Leaf(K), Node(Leaf(K), Leaf(I))))), Node(Leaf(K), Node(Leaf(K), Leaf(I))))

  it should "church number" in {

    val combinators = Table(("input", "ast"), (Natural.zero, falseCom), (Natural.one, oneCom))
    forAll(combinators) { (input, code) =>
      InputEncoder.church(input) shouldBe code
    }
  }

  it should "encode input List" in {
    val combinators = Table(("input", "ast"), (List(Natural.zero), zeroListCom))
    forAll(combinators) { (input, code) =>
      InputEncoder.encodeInput(input) shouldBe code
    }
  }

  it should "encode input String" in {
    val combinators = Table(("input", "ast"), ("", falseCom))
    forAll(combinators) { (input, code) =>
      InputEncoder.readInput(input) shouldBe code
    }
  }

}
