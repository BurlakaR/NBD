package Cw2

object Task2 {
  def main(args:Array[String]) {
    val konto1 = new KontoBankowe(5)
    konto1.wplata(5)
    konto1.wyplata(11)
    konto1.wyplata(3)
    println(konto1.stanKonta)

    val konto2 = new KontoBankowe
    konto2.wyplata(10)
    konto2.wplata(2)
    println(konto2.stanKonta)

  }
}

class KontoBankowe(private var _stanKonta: Double = 0.0){
    def stanKonta: Double = _stanKonta;

    def wplata(x:Double): Unit ={
      _stanKonta += x
    }

    def wyplata(x:Double): Unit ={
      if (x <= _stanKonta) _stanKonta -= x
    }
}
