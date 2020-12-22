package Cw9

object Demonstration {
  def main(args: Array[String]): Unit = {
    println("1: ")
    val c1 = new Container[String]("42")
    println(c1.getContent)
    def applyFunc (a:String) = a.toFloat
    println(c1.applyFunction[Double](applyFunc))

    println()
    println("-----")
    println("2:")
    val yes = new Yes[Int](24)
    val no = new No
    println(yes.isInstanceOf[Maybe[Object]])
    println(no.isInstanceOf[Maybe[Object]])

    println()
    println("-----")
    println("3:")
    def applyYesNo (a:Int) = a.toFloat
    println(yes.getValue)
    println(yes.applyFunction[Double](applyYesNo).getValue)

    println()
    println("-----")
    println("4:")
    println(yes.getOrElse(42))
    println(no.getOrElse(42))
  }

}