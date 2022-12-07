package com.legend.basic.newfeature;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * jdk8 api 添加了一个新的java.util.stream工具包，被称为流stream,可以以一种声明的方式处理数据
 * Stream使用一种类似用SQL语句从数据库查询数据的直观方式来提供一种对JAVA集合运算和表达的高阶抽象
 * 这种风格将要处理的元素集合看作一种流，流在管道中传输，并且在管道的节点上进行处理，比如筛选，排序，聚合等
 * 元素流在管道中经过中间操作的处理，最后由最终操作得到前面处理的结果
 * 
 * 集合接口有两个方法来生成流：
 * 1. stream : 为集合创建串行流
 * 2. parallelStream: 为集合创建并行流
 * 流的来源可以是集合、数组、I/O channel ，产生器generator...
 *
 */

public class MyStream {

    public static void main(String[] args) {
        // stream of elements -> filter/ sorted / map / collect
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取集合中大于2，并且经过排序、平方去重的有序集合
        final List<Integer> squaresList = numbers.stream()
                .filter(x -> x > 2)
                .sorted((o1, o2) -> o1.compareTo(o2))
                .map(x -> x * x)
                .distinct()
                .collect(Collectors.toList());
        
        // 1.filter
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        final List<String> filterCollect = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        // 2. limit 
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        // 3. sorted
        numbers.stream().sorted().forEach(System.out::println);
        // 4. map
        final List<Integer> collect = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        // 5. foreach
        numbers.stream().forEach(System.out::println);
        // 6. collectors
        // Collectors类将流转换成集合和聚合元素，返回列表或字符串
        final List<String> collect1 = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());

        final String mergeString = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串：" + mergeString);
        // 7. 统计
        // 一些长生统计结果的收集器，常用于int、double、long等基本类型上
        final IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("列表中最大的数：" + intSummaryStatistics.getMax());
        System.out.println("列表中最小的数：" + intSummaryStatistics.getMin());
        System.out.println("列表中所有数之和：" + intSummaryStatistics.getSum());
        System.out.println("列表中平均数：" + intSummaryStatistics.getAverage());
        // 8. 并行程序
        // 获取空字符串的数量
        final long count = strings.parallelStream().filter(str -> str.isEmpty()).count();
    }
}
