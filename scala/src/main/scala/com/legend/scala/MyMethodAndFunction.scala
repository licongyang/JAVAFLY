package com.legend.scala

import java.util.Date

/**
 * scala中的方法跟java的类似，方法是组成类的一部分
 * scala中的函数则是一个完整的对象，scala中的函数其实继承了Trait的类的对象
 * scala中使用val定义函数，def定义方法
 *
 *
 */
class Method2Function{
  /**
   * 方法声明
   * scala方法声明格式如下：
   * def functionName([参数列表]) : [return type]
   *
   * 如果不写等号和方法主体，那么方法会被隐藏声明为抽象(abstract),包含它的类型也是一个抽象类型
   *
   * 方法定义：
   * 方法定义由一个def关键字开始, 紧接着是可选的参数列表，一个冒号：和方法的返回类型，一个等于=，最后是方法的主体
   * 定义格式如下：
   *
   * def functionName([参数列表]):[return type] ={
   *    function body
   *    return [expr]
   * }
   *
   * return type 可以是任意合法的scala数据类型。参数列表中的参数可以使用逗号分割
   */
  def m(x : Int) = x + 3

  val f = (x: Int) => x + 3
}
object MyMethodAndFunction {

  def addInt(a : Int, b : Int) : Int = {
    var sum:Int = 0
    sum = a + b
    return sum
  }

  def printMe() : Unit = {
    println("Hello, Scala")
  }

  def time() = {
    println("获取时间，单位为纳秒")
    System.nanoTime
  }
  // 该方法在变量名和变量类型使用 => 符号来设置传名调用
  def delayed(t: => Long) = {
    println("在 delayed方法内")
    println("参数：" + t)
    t
  }

  def main(args: Array[String]): Unit = {
    delayed(time())
    // 一般情况下函数调用参数，就按照函数定义时的参数顺序一个个传递。
    // 但是可以通过指定函数参数名，并且不需要按照顺序想函数传递参数
    printInt(b = 5, a = 7)
    // 函数的最后一个参数可以是重复的，可以不指定函数参数个数，向函数传入可变长度参数列表
    // 通过参数的类型之后放一个星号来设置可变参数
    printStrings("Runoob", "scala", "python")
    // scala 支持递归，意味着函数可以调用它本身
    for(i <- 1 to 10 )
      println( i + " 的阶乘为： = " + factorial(i))
    // 函数参数指定为默认参数值，在调用函数的过程中可以不需要传递参数，使用默认值。如果传递了参数，则传递值会取代默认值
    println("返回值： " + addInt2())
    // 高阶函数可以使用其它函数作为参数，或者使用函数作为输出结果
    println(apply(layout,10))
    // 函数嵌套： 在scala函数内定义函数，内部的函数称为局部函数
    println(factorial(3))

    /**
     * 匿名函数， 箭头左边是参数列表，右边是函数体
     */
    def inc = (x: Int) => x + 1
    // 相当于匿名内部类
    def add2 = new Function[Int, Int] {
      override def apply(v1: Int): Int = v1 + 1
    }
    // 以上的实例inc现在可以作为一个函数，使用
    var x = inc(7) - 1
    // 同样可以匿名函数中定义多个参数：
    var mul = (x : Int, y : Int) => x * y
    println(mul(3,4))
    // 可以不给匿名函数设置参数
    var userDir = () => {System.getProperty("user.dir")}
    println(userDir())

    // 偏应用函数
    // 可以不需要提供函数需要的所有参数，只需要提供部分，或不提供所需参数
    val date = new Date
    log(date, "message1")
    Thread.sleep(1000)
    log(date, "message2" )
    Thread.sleep(1000)
    log(date, "message3" )
    // 实例中，log() 方法接收两个参数：date 和 message。我们在程序执行时调用了三次，参数 date 值都相同，message 不同
    // 可以使用偏应用函数优化以上方法，绑定第一个 date 参数，第二个参数使用下划线(_)替换缺失的参数列表，并把这个新的函数值的索引的赋给变量
    val logWithDateBound = log(date, _:String)
    logWithDateBound("message1")

    // scala函数柯里化
    // 将原来接受两个参数的函数变成新的接受一个参数的函数的过程,如下
    // 新的函数返回一个以原有第二个参数为参数的函数
    def add(x:Int, y:Int)=x+y // add(1,2)
    // 变形下
    def add3(x:Int)(y:Int) = x + y // add3(1)(2)
    // 实现过程
    // add(1)(2)实际上是依次调用两个普通函数(非柯里化函数)，
    // 第一次调用使用一个参数x,返回一个函数类型的值，第二次使用参数y调用这个函数类型的值
    // 接受一个x为参数，返回一个匿名函数， 该匿名函数的定义是：接受一个Int行参数y,函数体为x+y
    def add4(x:Int)= (y:Int) => x + y
    val result = add4(1)
    val sum = result(2)

    val str1:String = "Hello,"
    val str2:String = "scala"
    println(strcat(str1)(str2))

    // scala闭包
    // 闭包是一个函数，返回值依赖于声明在函数外部的一个或多个变量
    // 闭包可以简单的认为是可以访问一个函数里面局部变量的另外一个函数
    // 匿名函数
    val multiplier = (i:Int) => i * 10
    // 函数体内有一个变量i,它作为函数的一个参数
    // 在multiplier中有两个变量： i 和factor . 其中一个i是函数的形式参数，在multiplier函数被调用时，i被赋予一个新的值
    // 然而，factor不是形式，而是自由变量
    var factor = 3
    val multiplier2 = (i:Int) => i * factor
    // 引入一个自由变量factor,这个变量定义在函数外面
    // 这样定义的函数变量multiplier成为一个"闭包"，因为它引用到函数外面定义的变量，
    // 定义这个函数的过程是将这个自由变量捕获而构成一个封闭的函数

    // 字符串
    var floatVar = 12.456
    var intVar = 2000
    var stringVar = "hello scala"
    var fs = printf("浮点数变量为：" + "%f, 整形变量为 %d, 字符串为：" + "%s",
      floatVar,intVar,stringVar)
    println(fs)




  }

  def printInt(a: Int, b: Int) = {
    println("value of a : " + a)
    println("value of b : " + b)
  }

  def printStrings(args: String*) = {
    var i: Int = 0
    for(arg <- args){
      println("arg value [" + i + "]= " + arg)
      i = i + 1
    }
  }

  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorial( n - 1)
  }

  def addInt2(a:Int=5, b:Int=7):Int={
    var sum:Int = 0
    sum = a + b
    return sum
  }

  // 函数f和值v作为参数，而函数f又调用了参数v
  def apply(f:Int => String, v: Int) = f(v)

  def layout[A](x: A) = "[" + x.toString + "]"

  def factorial(i: Int): Int = {
    def fact(i : Int, accumulator : Int) :Int = {
      if( i <= 1)
        accumulator
      else
        fact(i - 1, i * accumulator)
    }
    fact(i, 1)
  }

  def log(date: Date, message: String) = {
    println(date + "-----" + message)
  }

  def strcat(s1: String)(s2: String) = {
    s1 + s2
  }





}
