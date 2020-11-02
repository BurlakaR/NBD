package Cw2

object Task5 {
  def main(args:Array[String]): Unit = {
    val person1 = new Student {}
    val person2 = new Pracownik {}
    person2.pensja = 100
    val person3 = new Nauczyciel {}
    person3.pensja = 100
    val person4 = new Student with Pracownik {}
    person4.pensja = 100
    val person5 = new Pracownik with Student {}
    person5.pensja = 100
    println(person1.podatek)
    println(person2.podatek + " " + person2.pensja)
    println(person3.podatek + " " + person3.pensja)
    println(person4.podatek + " " + person4.pensja)
    println(person5.podatek + " " + person5.pensja)
  }
}

class Person(private var _imie:String = "NoName", private var _nazwisko:String = "NoSurname", private var _podatek:Double = 0){
  def imie:String = _imie
  def nazwisko:String = _nazwisko
  def podatek:Double = _podatek
}

trait Student extends Person{
  override def podatek: Double = 0
}

trait Pracownik extends Person{
  override def podatek: Double = 0.2
  private var _pensja:Double = 0
  def pensja: Double = _pensja
  def pensja_= (nV:Double):Unit = _pensja = nV *(1-podatek)
}

trait Nauczyciel extends Pracownik {
  override def podatek: Double = 0.1
}
