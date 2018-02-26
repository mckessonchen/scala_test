import scala.util.Random

def randomNext() = math.abs(new Random().nextInt(1024))
var map = Map[String, Int]()
def apply(userName: String): Int = {
  val r = map.getOrElse(userName, randomNext()) + 1
  map = map + (userName -> r)
  r
}

apply("test")