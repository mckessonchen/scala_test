def isPrime(n: Int): Boolean =
  (2 until n) forall(n % _ != 0)

val n = 8
(1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter (pairs => isPrime(pairs._1 + pairs._2))

val test = (1 until n) flatMap (i => (1 until i) map (j => (i, j)))

for (i<- test if isPrime(i._1+i._2)) yield i._1