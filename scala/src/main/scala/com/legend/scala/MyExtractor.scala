package com.legend.scala

/**
 * 提取器是从传递给它的对象中提取出构造该对象的参数
 * Scala 标准库包含了一些预定义的提取器
 * Scala 提取器是一个带有unapply方法的对象。unapply方法算是apply方法的反向操作：
 * unapply接受一个对象，然后从对象中提取值，提取的值通常是用来构造该对象的值
 */
object MyExtractor {
  def main(args: Array[String]): Unit = {
    println("Apply 方法 : " + apply("Zara", "gmail.com"))
    println("Unapply 方法 : " + unApply("Zara@gmail.com"))
    println("Unapply 方法 : " + unApply("Zara Ali"))
  }
  // 注入方法 (可选)
  def apply(user: String, domain: String) = {
    user +"@"+ domain
  }

  // 提取方法（必须）
  def unApply(str: String):Option[(String, String)] = {
    val parts = str split "@"
    if(parts.length == 2)
        Some(parts(0), parts(1))
    else
        None
  }

}
