package com.legend.scala

import scala.Console.println

/**
 * scala集合分为可变和不可变集合
 * 可变集合可以在适当的地方被更新或拓展，这意味着你可以修改、添加、移除一个集合的元素
 * 不可变集合类，永远不会改变。不过，可以模拟添加、移除或更新操作，但是这些操作将在每一种情况下都返回一个新的集合，同时使原来的集合不发生改变
 *  1. List
 *     List的特征是其元素以线性方式存储，集合中可以存放重复对象。
 *     2. Set
 *     Set是最简单的一种集合。集合中的对象不按特定的方式排序，并且没有重复对象。
 *     3. Map
 *     Map 是一种把键对象和值对象映射的集合，它的每一个元素都包含一对键对象和值对象。
 *     4. Typle
 *     元组是不同类型的值的集合
 *     5. Option
 *     Option[T] 表示有可能包含值的容器，也可能不包含值。
 *     6. Iterator
 *     迭代器不是一个容器，更确切的说是逐一访问容器内元素的方法。
 */
object MyCollection {

  def main(args: Array[String]): Unit = {
    // 定义整形List
    val x = List(1, 2, 3, 4)
    // 定义Set
    val set = Set(1, 3, 5, 7)
    // Map 有两种类型，可变与不可变，区别在于可变对象可以修改它，而不可变对象不可以
    // 默认情况下scala使用不可变Map,如果需要使用可变集合，需要显式引入 import scala.collection.mutable.Map类
    // 不可变使用Map , 可变使用 mutable.Map
    // 定义Map
    val map = Map("one" -> 1, "two" -> 2, "three" -> 3)
    map("one")
    // 空哈希表，键为字符串，值为整形
    var A: Map[Char, Int] = Map()
    A += ('I' -> 1)
    A += ('J' -> 5)
    // Map键值对演示
    // Map基本操作
    val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "preu" -> "#CD853F")
    val nums: Map[Int, Int] = Map()
    println("colors中的键为: " + colors1.keys)
    println("colors中的值为：" + colors1.values)
    println("检测colors是否为空： " + colors1.isEmpty)
    println("检测nums是否为空：" + nums.isEmpty)
    // map合并
    val color2 = Map("blue" -> "#0033FF","yellow" -> "#FFFF00", "red" -> "#FF0000")
    // ++ 作为运算符
    var colors = colors1 ++ color2
    println("colors1 ++ colors2 : " + colors)
    // ++ 作为方法
    var colorss = colors1.++(color2)
    println("colors1.++(colors2) : " + colorss)

    colors1.keys.foreach(i => print("key = " + i + " value = " + colors1(i)))
    if(colors1.contains("red"))
      println("colors1  contain red")

    // 创建两个不同类型元素的元组
    val typle = (10, "runoob")
    // 定义option
    // Option[T] 是一个类型为 T 的可选值的容器： 如果值存在， Option[T] 就是一个 Some[T] ，如果不存在， Option[T] 就是对象 None 。
    val opt: Option[Int] = Some(5)
    // 虽然 Scala 可以不定义变量的类型，还是
    // 把他显示的定义上了
    val myMap: Map[String, String] = Map("key1" -> "value")
    val value1: Option[String] = myMap.get("key1")
    val value2: Option[String] = myMap.get("key2")
    println(value1) // Some("value1")
    println(value2) // None
    val a:Option[Int] = Some(5)
    val b:Option[Int] = None

    println("a.getOrElse(0): " + a.getOrElse(0) ) // 5
    println("b.getOrElse(10): " + b.getOrElse(10) ) // 10
    println("b.isEmpty: " + b.isEmpty )
    val t = (4,3,2,1)

    // 使用 Tuple.productIterator() 方法来迭代输出元组的所有元素
//    t.productIterator.foreach{ i =>println("Value = " + i )}
    val tt = new Tuple2("www.google.com", "www.runoob.com")
//    println("交换后的元组: " + t.swap )

    //迭代器 it 的两个基本操作是 next 和 hasNext。
    // 调用 it.next() 会返回迭代器的下一个元素，并且更新迭代器的状态
    // 调用 it.hasNext() 用于检测集合中是否还有元素
    val it = Iterator("Baidu", "Google", "Runoob", "Taobao")
    while (it.hasNext){
      println(it.next())
    }

  }

}
