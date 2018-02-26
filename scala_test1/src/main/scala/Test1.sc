def sumInt(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, f(a) + acc)
  }

  loop(a, 0)
}
sumInt(x => x * x)(1, 2)

def sum(f: Int => Int): (Int, Int) => Int = {
  def sumf(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sumf(a + 1, b)
  }

  sumf
}
sum(x => x * x)(1, 2)

def sum2(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum2(f)(a + 1, b)
sum2(x => x * x)(1, 2)

def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1 else f(a) * product(f)(a + 1, b)

def factorial(n: Int): Int = product(x => x)(1, n)
factorial(5)

def sumOfFac(n: Int): Int =
  if (n <= 0) 0 else factorial(n) + sumOfFac(n - 1)
sumOfFac(5)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)
             (a: Int, b: Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

def reProduct(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a, b)
reProduct(x => x)(1, 5)
