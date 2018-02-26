/**
  * Created by chenteng on 2017/2/14.
  */

object Main {
  def main(args: Array[String]): Unit = {
    def contains(s: Set[Int], elem: Int): Boolean = {
      def condition(set: Set[Int]): Boolean = {
        println(set)
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

    println(contains(set, 9))
    println(contain(set, 9))



  }

}
