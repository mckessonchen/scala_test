

trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true

  override def head: T = throw new NoSuchElementException("Nil.head")

  override def tail: List[T] = throw new NoSuchElementException("Nil.tail")
}

def nth[T](index: Int, list: List[T]): T =
  if (list.isEmpty) throw new IndexOutOfBoundsException
  else if (index == 0) list.head
  else nth(index - 1, list.tail)

val cons = new Cons(1,new Cons(2,new Cons(3,new Cons(4,new Nil))))

nth(3,cons)
nth(4,cons)
nth(6,cons)