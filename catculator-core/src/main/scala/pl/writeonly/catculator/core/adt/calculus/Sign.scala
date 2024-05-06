package pl.writeonly.catculator.core.adt.calculus

enum Sign:
  case Plus
  case Minus

object Sign {

  def generate(s: Sign): String = s match {
    case Plus  => "+"
    case Minus => "-"
  }
}
