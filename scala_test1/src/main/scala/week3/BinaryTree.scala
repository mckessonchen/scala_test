package week3

/**
  * Created by chenteng on 2017/2/15.
  */

object BinaryTree {

  def main(args: Array[String]): Unit = {
    val t1 = new NotEmpty(4, new Empty, new Empty)
    val t2 = t1.incl(5)
    t1.contains(3)
    println(t1)
    println(t2)
    println(t1.contains(3))

  }

  abstract class InSet {
    def contains(x: Int): Boolean

    def incl(x: Int): InSet
  }

  class Empty extends InSet {
    override def contains(x: Int): Boolean = false

    override def incl(x: Int): InSet = new NotEmpty(x, new Empty, new Empty)

    override def toString = "."
  }

  class NotEmpty(elem: Int, left: InSet, right: InSet) extends InSet {
    override def contains(elem: Int): Boolean = {
      if (elem < elem) left.contains(elem)
      else if (elem > elem) right.contains(elem)
      else true
    }

    override def incl(x: Int): InSet = {
      if (x < elem) new NotEmpty(elem, left incl (x), right)
      else if (x > elem) new NotEmpty(elem, left, right incl (x))
      else this
    }

    override def toString: String = "{" + left + elem + right + "}"
  }



}
