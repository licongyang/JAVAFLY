package com.legend.basic.newfeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.*;


/**
 * 方法引用使用一对冒号::, 通过方法的名字来指向一个方法
 * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码
 * 它只能用来代替单个方法的lambda表达式
 * 方法引用-》一个方法lambda表达式-》匿名内部类 =》 函数接口-》一个接口只有一个抽象方法
 * <p>
 * Instead of using
 * AN ANONYMOUS CLASS
 * you can use
 * A LAMBDA EXPRESSION
 * And if this just calls one method, you can use
 * A METHOD REFERENCE
 * <p>
 * There are four types of method references:
 * <p>
 * A method reference to a static method.
 * (args) -> Class.staticMethod(args) =》Class::staticMethod
 * A method reference to an instance method of an object of a particular type.
 * (obj, args) -> obj.instanceMethod(args) => ObjectType::instanceMethod
 * A method reference to an instance method of an existing object.
 * (args) -> otherobj.instanceMethod(args) => otherobj::instanceMethod
 * A method reference to a constructor.
 * (args) -> new ClassName(args) => ClassName::new
 * 1.if the constuctor takes an arugument ,we can use the function inteface
 * 2.if the constructor take two arguments ,we use the bitfunction interface
 * 3.if you have a constructor with three or more argument , you would have to create
 * your own functional interface
 * <p>
 */


public class MyMethodReference2 {

    static class Car {

        // Supplier是jdk1.8的接口，这里和lambda一起使用
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided" + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repaire() {
            System.out.println("Repaired" + this.toString());
        }
    }


    public static void main(String[] args) {
        // 构造器引用
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        // 1.静态方法引用
        // 匿名内部类
        // (args) -> Class.staticMethod(args)
        cars.forEach(new Consumer<Car>() {
            @Override
            public void accept(Car car) {
                Car.collide(car);
            }
        });
        // lambda
        cars.forEach(cd -> Car.collide(cd));
        // 方法引用
        cars.forEach(Car::collide);
        // 2.类成员方法引用
        // (obj,args) -> obj.instanceMethod(args)
        cars.forEach(Car::repaire);
        // 3.实例对象的成员方法引用
        final Car police = Car.create(Car::new);
        // (args) -> otherobj.instanceMethod(args)
        cars.forEach(new Consumer<Car>() {

            @Override
            public void accept(Car car) {
                police.follow(car);
            }
        });
        cars.forEach(c-> police.follow(c));
        cars.forEach(police::follow);
        // 注意这个方法follow接受一个Car类型的参数

        // 匿名内部类
        final Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                // 主要调用方法
                System.out.println(s);
            }
        };
        // lambda代替内部类，主体主要调用了方法println
        Consumer<String> cs = smm -> System.out.println(smm);
        // 将lambda转换为具体方法的方法引用
        // 在方法引用的:: 前面是包含方法的类，后面是无参的方法
        Consumer<String> d = System.out::println;
    }

}
