package com.legend.scala

import java.io.{File, PrintWriter}
import scala.io.{Source, StdIn}

/**
 * Scala 进行文件写操作，直接用的都是 java中 的 I/O 类 （java.io.File)
 */
object MyIO {

  def main(args: Array[String]): Unit = {
    val writer = new PrintWriter(new File("test.txt"))
    writer.write("hello scala")
    writer.close()

    print("请屏幕输入 : " )
    val line = StdIn.readLine()

    println("谢谢，你输入的是: " + line)

    println("文件内容为:" )
    //从文件读取内容非常简单。我们可以使用 Scala 的 Source 类及伴生对象来读取文件。以下实例演示了从 "test.txt"(之前已创建过) 文件中读取内容
    Source.fromFile("test.txt" ).foreach{
      print
    }
  }

}
