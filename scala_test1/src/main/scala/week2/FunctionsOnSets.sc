def contains(s: Set[Int], elem: Int): Boolean = {
  def condition(set: Set[Int]): Boolean = {
    if (set.head.equals(elem)) true
    else if (set.tail.size == 0) false
    else condition(set.tail)
  }

  condition(s)
}

val set = Set(1, 2, 3, 4, 5, 6, 7, 8)

def contain(s: Set[Int], elem: Int): Boolean =
  if (s.head.equals(elem)) true
  else  if (s.tail.size == 0) false
  else contain(s.tail,elem)

contains(set, 8)
contain(set,9)

