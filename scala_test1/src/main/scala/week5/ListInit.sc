def init[T](list: List[T]): List[T] = list match {
  case List() => throw new NoSuchElementException("Nil")
  case List(x) => List()
  case s :: xs => s :: init(xs)
}

def reverse[T](list: List[T]): List[T] = list match {
  case List() => list
  case s :: xs => reverse(xs) ::: List(s)
}

def removeAt[T](n: Int, list: List[T]): List[T] = {
  if (n > list.length) list
  else if (n==0) list.tail
  else list match {
    case List(x) => Nil
    case x :: xs => x :: removeAt(n - 1, xs)
  }
}

def flatten(list: List[Any]):List[Any] = list match {
  case List()=>list
  case x ::xs =>{
    if (x.isInstanceOf[List[Any]]) flatten(x.asInstanceOf[List[Any]]) ++flatten(xs)
    else x :: flatten(xs)
  }
}

val test = List(1, 2, 3, 4, 5, 6)
val test1 = List(1)
val test3= List(List(1,List(2)),List(3,4),List(5))

init(test)
reverse(test)
removeAt(1,test)
removeAt(0,test1)
flatten(test3)
