package pl.writeonly.catculator.core.reducers

import pl.writeonly.catculator.core.UnitSpec
import pl.writeonly.catculator.core.adt.calculus.Combinator.I
import pl.writeonly.catculator.core.adt.calculus.Lambda.Com
import pl.writeonly.catculator.core.parsers.LambdaParser
import pl.writeonly.catculator.core.reducers.SugarReducer.lambdaSugarReducer

class LambdaTest extends UnitSpec {
  "A SugarReducer" should {
    "return argument for Combinator" in {
      val i = Com(I)
      lambdaSugarReducer.reduceSugar(i) shouldBe i
    }

    "return argument for Combinator 2" in {
      val lambdaSource = "\\n \\f \\x (f (n f x))"
      val lambda = LambdaParser
        .parse(lambdaSource)
        .map(lambdaSugarReducer.reduceSugar)
//        .map(reduceAbstraction)
//        .map(LambdaGenerator.generate)
        .value
      println(lambda)
//      Abs(n,Abs(f,Abs(x,App(Var(f),App(App(Var(n),Var(f)),Var(x))))))

//      App(App(Com(S),App(Com(K),App(Com(S),App(App(Com(S),App(Com(K),Com(S))),App(App(Com(S),App(Com(K),Com(K))),Com(I)))))),App(App(Com(S),App(App(Com(S),App(Com(K),Com(S))),App(App(Com(S),App(Com(K),App(Com(S),App(Com(K),Com(S))))),App(App(Com(S),App(App(Com(S),App(Com(K),Com(S))),App(App(Com(S),App(Com(K),App(Com(S),App(Com(K),Com(S))))),App(App(Com(S),App(Com(K),App(Com(S),App(Com(K),Com(K))))),App(App(Com(S),App(Com(K),Com(K))),Com(I)))))),App(Com(K),App(App(Com(S),App(Com(K),Com(K))),Com(I))))))),App(Com(K),App(Com(K),Com(I)))))

//      val cbt = toCombinatorBT(lambda).value
//      val result = fromCombinatorBT(cbt)
//
//      println(result)

//      result shoudlBe successor
    }
  }
}
