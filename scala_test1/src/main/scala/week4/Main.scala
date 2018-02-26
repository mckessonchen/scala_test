package week4

import sun.security.provider.Sun

/**
  * Created by chenteng on 2017/2/16.
  */

object Main {

  abstract class Nat {
    def isZero: Boolean

    def predecessor: Nat

    def successor: Nat

    def +(that: Nat): Nat

    def -(that: Nat): Nat
  }

  object Zero extends Nat {
    override def isZero: Boolean = true

    override def predecessor: Nat = throw new NoSuchElementException("Zero.predecessor")

    override def successor: Nat = new Succ(this)

    override def +(that: Nat): Nat = that

    override def -(that: Nat): Nat = if (that.isZero) this else throw new NoSuchElementException("Zero -" + that)
  }

  class Succ(n: Nat) extends Nat {
    override def isZero: Boolean = false

    override def predecessor: Nat = n

    override def successor: Nat = new Succ(n)

    override def +(that: Nat): Nat = new Succ(n + that)

    override def -(that: Nat): Nat = if (that.isZero) this else n - that.predecessor
  }

  def main(args: Array[String]): Unit = {
    val test1 = new Succ(Zero)
    val test2 = new Succ(test1)
    val test3 = test1 + test2
    println("end")
  }

}
