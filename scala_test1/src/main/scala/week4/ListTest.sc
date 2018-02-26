def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys =>
    if (x > y) y::insert(x,ys)
    else x:: insert(y,ys)
}

def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y,isort(ys))
}

isort(4 :: 9 :: 9 :: 5 :: 14 :: 6 :: 7 :: 6 :: Nil)

def s1 = List(1, 3, 4, 5)

def s2 = List(2, 3, 4) ::: s1