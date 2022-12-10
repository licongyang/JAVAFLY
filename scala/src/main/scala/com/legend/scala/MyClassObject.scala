package com.legend.scala

/**
 * Scala 继承
 * 1、重写一个非抽象方法必须使用override修饰符
 * 2、只有主构造函数才可以往基类的构造函数里写参数。
 * 3、在子类中重写超类的抽象方法时，你不需要使用override关键字。
 *
 * 单例对象
 * 在 Scala 中，是没有 static 这个东西的，但是它也为我们提供了单例模式的实现方法，那就是使用关键字 object。
 * Scala 中使用单例模式时，除了定义的类之外，还要定义一个同名的 object 对象，它和类的区别是，object对象不能带参数
 * 当单例对象与某个类共享同一个名称时，他被称作是这个类的伴生对象：companion object。你必须在同一个源文件里定义类和它的伴生对象。类被称为是这个单例对象的伴生类：companion class。类和它的伴生对象可以互相访问其私有成员
 *
 */
class Point(xc: Int, yc: Int) {
  // Scala 的类定义可以有参数，称为类参数，如上面的 xc, yc，类参数在整个类中都可以访问。
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println ("x 的坐标点: " + x);
    println ("y 的坐标点: " + y);
  }
}

class Location( val xc: Int,  val yc: Int,
               val zc :Int) extends Point(xc, yc){
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int) {
    x = x + dx
    y = y + dy
    z = z + dz
    println ("x 的坐标点 : " + x);
    println ("y 的坐标点 : " + y);
    println ("z 的坐标点 : " + z);
  }
}
//Scala重写一个非抽象方法，必须用override修饰符。
class Person {
  var name = ""
  override def toString = getClass.getName + "[name=" + name + "]"
}

class Employee extends Person {
  var salary = 0.0
  override def toString = super.toString + "[salary=" + salary + "]"
}


object MyClassObject {
  def main(args: Array[String]): Unit = {
    val pt = new Point(10, 20)
    // 移动到一个新的位置
    pt.move(10, 10)

    val loc = new Location(10, 20, 15);
    // 移到一个新的位置
    loc.move(10, 10, 5);

    val fred = new Employee
    fred.name = "Fred"
    fred.salary = 50000
    println(fred)

  }



}
