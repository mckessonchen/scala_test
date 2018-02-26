package week4

/**
  * Created by chenteng on 2017/2/16.
  */

object CustomerList {

  trait ListTest[+T] {
    def isEmpty: Boolean

    def head: T

    def tail: ListTest[T]

    def test[U >: T](elem: U): ListTest[U] = new Cons(elem, this)
  }

  class Nil[T] extends ListTest[T] {
    override def isEmpty = true

    override def head = throw new NoSuchElementException("nil.head")

    override def tail = throw new NoSuchElementException("nil.tail")
  }

  class Cons[T](val head: T, val tail: ListTest[T]) extends ListTest[T] {
    override def isEmpty = false
  }

  object Test {

    def apply[T](x1: T, x2: T): ListTest[T] = new Cons[T](x1, new Cons[T](x2, new Nil[T]))

    def apply[T]: ListTest[T] = new Nil[T]


  }

}
