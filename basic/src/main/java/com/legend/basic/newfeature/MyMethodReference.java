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


public class MyMethodReference {

    // 静态方法的方法引用
    static class Numbers {
        public static boolean isMoreThanFifty(int n1, int n2) {
            return (n1 + n2) > 50;
        }

        // 方法定义的参数是个函数接口，则后面方法调用时，该函数接口可以用anonymous class、lambda、method reference等形式定义实现
        public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
            List<Integer> newList = new ArrayList<>();
            for (Integer i : l) {
                if (p.test(i, i + 10)) {
                    newList.add(i);
                }
            }
            return newList;
        }
    }

    // 实例方法的方法引用
    static class Shipment {
        public double calculateWeight() {
            double weight = 0;
            // calculate weight
            return weight;
        }

        // 方法定义，其中方法参数为函数接口；后面方法调用，该函数接口就可以用匿名内部类、lambda表达式、方法引用定义实现
        public static List<Double> calculateOnShipments(
                List<Shipment> l, Function<Shipment, Double> f) {
            List<Double> results = new ArrayList<>();
            for (Shipment s : l) {
                results.add(f.apply(s));
            }
            return results;

        }
    }

    // java has a function interface that takes one parameter,
    // a bitfunction that takes two parameters,
    // but there's no trifunction that takes three parameters ,so let's make one:
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    static class Sum {
        Integer doSum(String s1, String s2) {
            return Integer.parseInt(s1) + Integer.parseInt(s2);
        }
    }

    static class Car2 {
        private int id;
        private String color;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    static class Mechanic {
        public void fix(Car2 c) {
            System.out.println("Fixing car " + c.getId());
        }
    }



    public static void main(String[] args) {

        /**
         * 1. static method reference
         * in this case ,we have a lambda expression like the one below:
         * (args) -> Class.staticMethod(args)
         * this can be turned into the following method reference:
         * Class::staticMethod
         */
        List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);
        // anonymous class
        // 匿名内部类作为方法参数,其中 该匿名内部类是函数接口实现
        Numbers.findNumbers(list, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer i1, Integer i2) {
                return Numbers.isMoreThanFifty(i1, i2);
            }
        });
        // lambda 代替匿名内部类
        // (args)-> Class.staticMethod(args)
        Numbers.findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));
        // method reference
        Numbers.findNumbers(list, Numbers::isMoreThanFifty);


        //======================================================
        /**
         * 2.instance method reference of an object of a particular type
         * in this case, we have a lambda expression like the following:
         * (obj, args) -> obj.instanceMethod(args)
         * <p>
         * where an instance of an object is passed ,and one of its mehods is executed with
         * some optional(s) parameter(s).
         * <p>
         * this can be turned into the following method reference:
         * ObjectType::instanceMethod
         * <p>
         * first, we don't use the instance itself - we use its type
         * second, the other argument of the lambda expression, if any ,is not used in the method reference,
         * but it's passed behind the curtains like in the static method case.
         */
        List<Shipment> l = new ArrayList<>();
        // Using an anonymous class
        Shipment.calculateOnShipments(l, new Function<Shipment, Double>() {
            @Override
            public Double apply(Shipment shipment) {
                return shipment.calculateWeight();
            }
        });

        // Using a lambda expression
        Shipment.calculateOnShipments(l, (Shipment s) -> s.calculateWeight());
        Shipment.calculateOnShipments(l, s -> s.calculateWeight());

        // Using a method reference
        Shipment.calculateOnShipments(l, Shipment::calculateWeight);


        // anonymous class
        // (obj,args) -> obj.instanceMethod(args)
        TriFunction<Sum, String, String, Integer> anno = new TriFunction<Sum, String, String, Integer>() {
            @Override
            public Integer apply(Sum sum, String s1, String s2) {
                return sum.doSum(s1, s2);
            }
        };
        System.out.println(anno.apply(new Sum(), "1", "4"));

        // lambda expression
        TriFunction<Sum, String, String, Integer> lambda = (Sum sum, String s1, String s2) -> sum.doSum(s1, s2);

        // method reference

        TriFunction<Sum, String, String, Integer> mRef = Sum::doSum;
        System.out.println(mRef.apply(new Sum(), "1", "4"));
        //======================================================
        /**
         * 3. Instance method reference
         * <p>
         * in this case ,we have a lambda expression like the following:
         * (args) -> obj.instanceMethod(args)
         * this can be tured into the follow method reference:
         * obj::instanceMethod
         * <p>
         * this time ,an instance defined somewhere else is used , and the arguments(if any)
         * are passed behind the curtains like in the static method case
         */
        final Mechanic mechanic = new Mechanic();
        Car2 car2 = new Car2();
        // anonymous class
        // (args) -> otherobj.instanceMethod(args)
        execute(car2, new Consumer<Car2>() {
            public void accept(Car2 c) {
                mechanic.fix(c);
            }
        });
        // using a lambda expression
        execute(car2, c -> mechanic.fix(c));

        // method reference
        execute(car2, mechanic::fix);

        Consumer<String> c = System.out::println;
        c.accept("Hello");
        //======================================================
        /**
         * 4. constructor method reference
         * in this case ,we have a lambda expression like the following:
         * (args) -> new ClassName(args)
         * that can be turned into the following method reference:
         * ClassName::new
         * <p>
         * the only thing this lambda expression does is to create object and we just
         * reference a constructior of the class with the keyword new. Like in the other cases,
         * arguments(if any) are not passed in hte method reference.
         * <p>
         * most of the time ,we can use this syntax whit two (or three) interfaces of java.util.function package.
         * if the constructor takes no arguments, a Supplier will do the job:
         * <p>
         * the referencing constructor is very similar to referencing a static method, the difference is that
         * the consturctor "method name " is new
         */

        // supplier
        // anonymous class
        // (args) -> new ClassName(args)
        Supplier<List<String>> s = new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                return new ArrayList<String>();
            }
        };
        List<String> ll = s.get();

        // lambda expression
        Supplier<List<String>> ss = () -> new ArrayList<String>();

        // method reference
        Supplier<List<String>> mS = ArrayList::new;
        List<String> ls = mS.get();

        // if the constuctor takes an arugument ,we can use the function inteface
        // anonymous class
        Function<String, Integer> f = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return new Integer(s);
            }
        };
        // lambda expression
        Function<String, Integer> ff = st -> new Integer(st);
        final Integer i = ff.apply("100");

        // method reference
        Function<String, Integer> mf = Integer::new;
        final Integer ii = mf.apply("100");

        // if the constructor take two arguments ,we use the bitfunction interface:
        // anonymous class
        final BiFunction<String, String, Locale> biFunction = new BiFunction<String, String, Locale>() {

            @Override
            public Locale apply(String lang, String country) {
                return new Locale(lang, country);
            }
        };
        Locale loc = biFunction.apply("en", "UK");
        // lambda
        BiFunction<String, String, Locale> bf = (lang, country) -> new Locale(lang, country);
        Locale locc = bf.apply("en", "UK");

        // method reference
        BiFunction<String, String, Locale> mff = Locale::new;
        Locale mloc = mff.apply("en", "Uk");
        // if you have a constructor with three or more argument , you would have to create
        // your own functional interface

    }

    private static void execute(Car2 car, Consumer<Car2> car2Consumer) {
    }
}
