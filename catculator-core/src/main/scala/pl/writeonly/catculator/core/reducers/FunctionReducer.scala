package pl.writeonly.catculator.core.reducers

import pl.writeonly.catculator.core.LambdaConfig
import pl.writeonly.catculator.core.adt.calculus.Lambda._
import pl.writeonly.catculator.core.adt.calculus._

import scala.language.postfixOps

object FunctionReducer {
  val haskellFunctionReducer: FunctionReducer = FunctionReducer(LambdaConfig.haskellConfig)
}

class FunctionReducer(config: LambdaConfig) {

  def reduceFunctions(xs: List[Func]): Lambda = xs match {
    case Nil     => Var("main")
    case x :: xs => config.wrapAppThrush(x.lambda, x.name)(reduceFunctions(xs))
  }

  def reduceFunctionsOpt(l: List[Func]): Option[Lambda] = {
    val env = buildEnv(l)
    env.get("main").map(reduceFunction(env))
  }

  private def buildEnv(l: List[Func]) = l
    .map { f =>
      (f.name, f.lambda)
    }
    .toMap

  private def reduceFunction(env: Map[String, Lambda])(main: Lambda) = main
}
