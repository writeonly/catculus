package pl.writeonly.catculator.core.adt.calculus

enum Sign:
  case Plus
  case Minus

object Sign {
  extension (self: Sign)
    def generate: String = self match {
      case Plus  => "+"
      case Minus => "-"
    }
}
