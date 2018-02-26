trait Expr

def eval(e: Expr): String = e match {
  case Number(n) => n.toString
  case Sum(e1, e2) =>   eval(e1) + "+" + eval(e2)
//  case Prod(e1, e2) => "(" + eval(e1) + "*" + eval(e2) + ")"
  case Prod(e1, e2) => {
    if(e1.isInstanceOf[Sum]&&e2.isInstanceOf[Sum])
      "(" + eval(e1) + ")*(" + eval(e2) + ")"
    else if (e1.isInstanceOf[Sum]&& !e2.isInstanceOf[Sum])
      "(" + eval(e1) + ")*" + eval(e2)
    else if (!e1.isInstanceOf[Sum]&& e2.isInstanceOf[Sum])
      eval(e1) + "*(" + eval(e2) + ")"
    else
      eval(e1) + "*" + eval(e2)
  }
  case _ => null
}

case class Number(n: Int) extends Expr

case class Sum(var e1: Expr, e2: Expr) extends Expr

case class Prod(e1: Expr, e2: Expr) extends Expr

eval(Sum(Prod(Number(2), Number(4)), Number(4)))
eval(Prod(Sum(Number(2), Number(4)), Number(4)))

val  s = Sum(Number(1),Number(2))
s.e1