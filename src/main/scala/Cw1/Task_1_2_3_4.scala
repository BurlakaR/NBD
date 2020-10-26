package Cw1

import scala.annotation.tailrec

object Task_1_2_3_4 {
  def main(args:Array[String])
  {
    val weekList: List[String] = List("poniedziałek",
      "wtorek",
      "środa",
      "czwartek",
      "piątek",
      "sobota",
      "niedziela")


    println("Task 1")
    println(a_1(weekList))
    println(b_1(weekList))
    println(c_1(weekList))

    println("Task 2")
    println(a_2(weekList))
    println(b_2(weekList))

    println("Task 3")
    println(a_3(weekList))
    println(b_3(weekList))

    println("Task 4")
    println(a_4(weekList))
    println(b_4(weekList))
    println(c_4(weekList))
  }

  def a_1(weekList : List[String]) : String = {
    var res = ""
    for (day <- weekList){
      res += day + ","
    }
    res.dropRight(1)
  }
  def b_1(weekList : List[String]) : String = {
    var res = ""
    for (day <- weekList if day.startsWith("p")){
      res += day + ","
    }
    res.dropRight(1)
  }
  def c_1(weekList : List[String]) : String = {
    var res = ""
    val it = weekList.iterator
    while(it.hasNext){
      res += it.next() + ","
    }
    res.dropRight(1)
  }

  def a_2(weekList : List[String]) : String = {
    def recursion(list : List[String]): String = list match{
      case Nil => ""
      case _ => list.head + "," + recursion(list.tail)
    }
    recursion(weekList).dropRight(1)
  }
  def b_2(weekList : List[String]) : String = {
    def recursion(list : List[String]): String = list match{
      case Nil => ""
      case _ => recursion(list.tail) + list.head + ","
    }
    recursion(weekList).dropRight(1)
  }

  def a_3(weekList : List[String]) : String = {
    @tailrec
    def recursion(list : List[String], res : String): String = list match{
      case Nil => res
      case _ => recursion(list.tail, res + list.head + ",")
    }
    recursion(weekList, "").dropRight(1)
  }
  def b_3(weekList : List[String]) : String = {
    @tailrec
    def recursion(list : List[String], res : String): String = list match{
      case Nil => res
      case _ => recursion(list.tail, list.head + "," + res)
    }
    recursion(weekList, "").dropRight(1)
  }

  def a_4(weekList : List[String]) : String ={
    weekList.foldLeft(""){(res, day) => res + day + ","}.dropRight(1)
  }

  def b_4(weekList : List[String]) : String ={
    weekList.foldRight(""){(res, day) => res + "," + day}.dropRight(1)
  }

  def c_4(weekList : List[String]) : String ={
    weekList.filter(s => s.startsWith("p")).foldLeft(""){_ + "," + _}.drop(1)
  }
}
