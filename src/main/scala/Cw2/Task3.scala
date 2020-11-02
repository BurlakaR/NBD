package Cw2

object Task3 {
  def main(args:Array[String]): Unit = {
    println(matching(Osoba("Jon", "Snow")))
    println(matching(Osoba("Robb", "Stark")))
    println(matching(Osoba("Brandon", "Stark")))
    println(matching(Osoba("Aegon", "Targaryen")))
    println(matching(Osoba("Really", "Noone")))
  }

  def matching(o:Osoba): String = o match {
    case Osoba("Jon", "Snow") => "You know nothing, Jon Snow."
    case Osoba(_, "Stark") => "Winter is coming, " + o.imie
    case Osoba(_, "Targaryen") => "Fire and Blood, " + o.imie
    case _ => "Valar morghulis"
  }

}

case class Osoba(var imie: String, var nazwisko: String)

