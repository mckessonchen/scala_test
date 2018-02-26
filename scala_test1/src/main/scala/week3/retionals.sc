val x = new Retionals(1, 3)
val y = new Retionals(5, 7)
val z = new Retionals(3, 2)

-x
-1
x.numer
x.denum
x sub y
x.sub(y).sub(z)
x.add(y).sub(z)
x.less(y)
x.max(y)

val sss = new Retionals(1, 0)
sss.add(x)

class Retionals(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def numer = x

  def denum = y

  def add(that: Retionals) =
    new Retionals(numer * that.denum + denum * that.numer, denum * that.denum)

  def unary_- : Retionals = new Retionals(-numer, denum)

  def less(that: Retionals) = numer * that.denum < that.numer * denum

  def max(that: Retionals) = !this.less(that)

  def sub(that: Retionals) =
    new Retionals(numer * that.numer, denum * that.denum)

  override def toString: String = {
    val g = gcd(numer, denum)
    numer / g + "/" + denum / g
  }
}