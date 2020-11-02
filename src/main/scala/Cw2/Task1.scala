package Cw2

object Task1 {
  def main(args:Array[String]) {
    println(patternfuction("wtorek"))
    println(patternfuction("sobota"))
    println(patternfuction("dzień"))
  }

  def patternfuction (x:String) = x match {
    case "poniedziałek" |  "wtorek" |  "środa" |  "czwartek" |  "piątek" => "Praca"
    case "sobota" |  "niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }
}


