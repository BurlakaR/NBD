package Cw1

import scala.annotation.tailrec

object Task_8_9_10 {
  def main(args:Array[String]): Unit =
  {
    val numList : List[Int] = List(0,1,0,2,0,3,0,4,0,0)
    println("Task 8")
    println(a_8(numList))

    println("Task 9")
    println(a_9(numList))

    val floatList : List[Double] = List(0.145, -5.622, 11.311, 12.111, 4.242)
    println("Task 10")
    println(a_10(floatList))
  }

  def a_8(numList : List[Int]) : List[Int] = {
    @tailrec
    def recursion_list_creation(i : Int, resultList : List[Int]) : List[Int] ={
      if(i==numList.length) resultList
      else{
        if(numList(i)==0) recursion_list_creation(i+1, resultList)
        else recursion_list_creation(i+1, resultList:+numList(i))
      }
    }
    recursion_list_creation(0, List())
  }

  def a_9(numList : List[Int]) : List[Int] = {
    numList.map({ x =>x+1})
  }

  def a_10(numList : List[Double]) : List[Double] = {
    numList.filter(x => (x>=(-5) && x<=12))
  }

}
