package Cw2

object Task4 {
  def main(args:Array[String]): Unit = {
    println(threetimefunction(2, function))
  }

  def function(x:Int):Int = {
      x*2
  }

  def threetimefunction(x:Int, f:Int => Int):Int = {
    f(f(f(x)))
  }
}


