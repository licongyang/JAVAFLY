package com.legend.scala

import java.io.{FileNotFoundException, FileReader, IOException}

/**
 * Scala 的异常处理和其它语言比如 Java 类似
 * Scala 的方法可以通过抛出异常的方法的方式来终止相关代码的运行，不必通过返回值
 * Scala 抛出异常的方法和 Java一样，使用 throw 方法,如：throw new IllegalArgumentException
 *
 * 异常捕捉的机制与其他语言中一样，如果有异常发生，catch 字句是按次序捕捉的。因此，在 catch 字句中，越具体的异常越要靠前，越普遍的异常越靠后。
 * 如果抛出的异常不在 catch 字句中，该异常则无法处理，会被升级到调用者处
 */
object ScalaException {

  // 捕捉异常的 catch 子句，语法与其他语言中不太一样。
  // 在 Scala 里，借用了模式匹配的思想来做异常的匹配，
  // 因此，在 catch 的代码里，是一系列 case 字句
  def main(args: Array[String]): Unit = {
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException =>{
        println("Missing file exception")
      }
      case ex: IOException => {
        println("IO Exception")
      }
    }finally {
      //finally 语句用于执行不管是正常处理还是有异常发生时都需要执行的步骤
      println("Exiting finally...")
    }
  }

}
