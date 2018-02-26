package week4

/**
  * Created by chenteng on 2017/2/17.
  */

object PatternMatching {

  class Num(n:Int){
    def value = n
  }

  object Num {
    def apply(n: Int)= new Num(n)
  }

  def main(args: Array[String]): Unit = {
    println(Num(4).value)
  }

}
