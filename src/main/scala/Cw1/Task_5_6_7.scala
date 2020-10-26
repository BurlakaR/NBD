package Cw1

object Task_5_6_7 {
  def main(args:Array[String]): Unit =
  {
    val games = Map("Cyberpunk 2099" -> 59.99, "Assassin's Creed Valhalla" -> 59.99, "Baldur's Gate 3" -> 51.00 )
    println("Task 5")
    println(a_5(games))

    val something = ("Word" , 0, 0.01)
    println("Task 6")
    a_6(something)

    println("Task 7")
    println("Cyberpunk 2099 price: " + a_7(games.get("Cyberpunk 2099")))
    println("Stellaris Necroids DLC price: " + a_7(games.get("Stellaris Necroids DLC")))

  }

  def a_5(products: Map[String, Double]) : Map[String, Double] ={
    products.map({case(k, v) => k->v*0.9})
  }

  def a_6(something: Tuple3[String, Int, Double]) : Unit = {
    something.productIterator.foreach(println)
  }

  def a_7(x: Option[Double]) : Any = x match {
    case Some(s) => s
    case None => "No information"
  }
}
