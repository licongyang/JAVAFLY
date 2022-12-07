package com.legend.basic.newfeature;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式，也称为闭包；
 * 允许将函数作为方法的参数，或者把代码本身当作数据处理
 * jvm平台之上的语言（Groovy、Scala）开始就支持Lambda表达式；而JAVA开发者只能使用匿名内部类代替Lambda表达式
 * <p>
 * Lambda表达式的语法格式：
 * <p>
 * (parameters) -> expression
 * 或
 * (parameters) -> {statements;}
 * <p>
 * Lambda编程风格，分为四类：
 * 1. 可选类型声明： 不需要声明参数类型，编译器可以同意识别参数值
 * 2. 可选的参数圆括号： 一个参数无需定义圆括号，但多个参数需要定义圆括号
 * 3. 可选的大括号： 如果主体包含了一个语句，就不需要使用大括号
 * 4. 可选的返回关键字： 如果主题只有一个表达式返回值则编译器自动返回值，大括号需要指明表达式返回了一个数值
 */
public class MyLambda {


    public static void main(String[] args) {
        // 匿名内部类方式排序
        List<String> names = Arrays.asList("a", "b", "d");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        // lambda表达式
        // 1.1 可选的参数圆括号
        // 方法只有一个参数可以省略圆括号
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
        // 多个参数需要有圆括号
        Arrays.asList("a", "b", "c").sort((e1, e2) -> e1.compareTo(e2));

        // 1.2 可选数据类型
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        Collections.sort(names, (String s1, String s2) -> s1.compareTo(s2));

        // 1.3 可选大括号
        // 当主体只包含一行时，无需使用大括号
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
        // 主体包含多行，需要大括号
        Arrays.asList("a", "b", "c").forEach(e -> {
            System.out.println(e);
            System.out.println(e);
        });

        //1.4 可选的返回关键字
        // 如果主体只有一行，则可以不用return语句，返回值由编译器推理得出
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
        // 如果语句块有多行，可以在大括号中指明表达式返回值
        Arrays.asList("a", "b", "c").sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });

        // 2.1 Lambda表达式引用类成员和局部变量，但是会将这些变量隐式转换为final
        String separator = ",";
        Arrays.asList("a","b","c").forEach((String e) -> System.out.println(e + separator) );

        final String separator2 = ",";
        Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e + separator2));
        // 2.2 Lambda表达式的局部变量可以不用声明final,但后面代码不可再修改（隐式final）
        int num = 1;
        Arrays.asList(1, 2, 3, 4).forEach(e -> System.out.println(num + e));
        // num = 2;
        // 会报错： Local variable num defined in an enclosing scope must be final or effectively final
        // 2.3 Lambda表达式中不允许声明一个和局部变量同名的参数或者局部变量
        int num2 = 1;
        // Arrays.asList(1, 2, 3, 4).forEach(num2 -> System.out.println(num2));
        // Variable 'num' is already defined in the scope



    }
}
