package com.legend.scala

object AssignmentOperator {

  def main(args: Array[String]) : Unit = {

    var a = 10
    val b = 20
    var c = 0

    c = a + b
    println("c = a + b  = " + c) //c = a + b  = 30

    c += a
    println("c += a  = " + c)

    c -= a
    println("c -= a = " + c)

    c *= a
    println("c *= a = " + c)

    a = 10
    c = 15
    c /= a
    println("c /= a  = " + c)

    a = 10
    c = 15
    c %= a
    println("c %= a  = " + c)

    c <<= 2
    println("c <<= 2  = " + c) //c <<= 2  = 20

    c >>= 2
    println("c >>= 2  = " + c) //c >>= 2  = 5

    c >>= a
    println("c >>= a  = " + c) //c >>= a  = 0

    c &= a
    println("c &= 2  = " + c)

    c ^= a
    println("c ^= a  = " + c)

    c |= a
    println("c |= a  = " + c)
  }

}
