def squareList(list: List[Int]): List[Int] = list match {
  case Nil => list
  case x :: xs => x * x :: squareList(xs)
}

def pack[T](list: List[T]): List[List[T]] = list match {
  case Nil => Nil
  case x :: xs => {
    val (first, rest) = list.partition(n => x == n)
    first :: pack(rest)
  }
}

def encode[T](list: List[T]): List[(T, Int)] =
//  list match {
//  case Nil => Nil
//  case _ => {
//    def count[T](list: List[List[T]]): List[(T, Int)] = list match {
//      case Nil => Nil
//      case x :: xs => (x.head, x length) :: count(xs)
//    }
//    count(pack(list))
//  }
//}
  pack(list) map (xs => (xs.head, xs.length))


val test1 = List(1, 5, 2, 3, 4, 5, 6)
val test2 = List("a", "b", "a", "b", "c", "c", "d")

encode(test2)
test2.reduceLeft(_ + _)
test2.reduce(_ + _)
test2.reduceRight(_ + _)
pack(test2)
squareList(test1)
test1.take(3)
test1.apply(3)
test1.apply(1)
test1.map(n => n * n)
test1.filter(n => n > test1.apply(test1.length / 2))
test1 zip "s"