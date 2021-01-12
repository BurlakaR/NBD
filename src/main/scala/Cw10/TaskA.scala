package Cw10

object TaskA {

  def main(args: Array[String]): Unit =  {
    val test = generatePairs.buffered
    for(n <- 0 to 5){
      println(test.next)
    }
    test take 15 foreach println
    println()


    val yes = new Yes[List[Int]](value = List(1,1,2,3,5,8,13))
    def doubleBid(i:Int):Int = i*2
    println("Map result:")
    println(yes.map(doubleBid,yes._value))


    val yesStr = new Yes[List[String]](value = List("Thorin II Oakenshield","Fili","Kili","Óin","Glóin","Balin","Dwalin","Ori","Dori","Nori","Bifur","Bofur","Bombur"))
    def flatmapRun(str:String):List[String] = str.split("").map(_.trim).toList
    println("Flatmap result:")
    println(yes.flatmap(flatmapRun,yesStr._value))
  }



  def generatePairs: Iterator[(Int, Int)] = for{
    a <- Iterator.from(1)
    b <- 1 until a+1 if a % b == 0
  } yield (a,b)
}