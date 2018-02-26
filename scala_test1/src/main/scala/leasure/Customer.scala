package leasure

/**
  * Created by chenteng on 2017/3/24.
  */

object Customer {
  def main(args: Array[String]): Unit = {
    def pp(value: Int) = {
      println(value)
      println(value + 1)
    }

    var a = 1;
    def inc(): Int = {
      a += 1
      a
    }

    pp(inc())
  }
}
