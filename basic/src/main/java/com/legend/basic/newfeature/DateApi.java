package com.legend.basic.newfeature;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *  在旧版的JAVA中，日期时间api存在诸多问题，
 *  1. 非线程安全： java.util.Date是非线程安全的，所有的日期类都是可变的，这是JAVA日期类的最大的问题之一
 *  2. 设计很差：JAVA的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类被定义在java.text包中。
 *     java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，
 *     这本身就是一个非常糟糕的设计
 *  3. 时区处理麻烦：日期类并不提供国际化，没有时区支持，因此JAVA引入了java.util.Calendar和java.util.TimeZone类，但它们同样存在上述所有问题
 *  因为这些原因，诞生了第三方库Joda-Time,可以替代JAVA的时间管理API
 *
 *  jdk8新的时间和日期管理api深受joda-time影响，
 *  新的java.time包包含了所有关于日期、时间、时区、Instant(跟日期类似但精确到纳秒)、duration(持续时间)和时钟操作的类
 *  新设计的api考虑了这些类的不变形，如果某个实例需要修改，则返回一个新的对象。
 */
public class DateApi {
    public static void main(String[] args) {
        // 1. Clock类
        // clock类使用时区来返回当前的纳秒时间和日期
        // clock可以替代System.currentTimeMillis()和TimeZone.getDefault()
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        //2022-12-07T09:14:17.156Z
        System.out.println(clock.getZone());
        //Z
        System.out.println(clock.millis());
        //1670404457202

        // 2.LocalDate LocalTime LocalDateTime
        // 都是用于处理日期时间的API，在处理日期时间时可以不用强制指定时区
        // 2.1 LocalDate 仅仅包含ISO-8601日历系统中的日期部分
        // 获取当前日期
        final LocalDate localDate = LocalDate.now();
        //获取指定时钟的日期
        final LocalDate clockLocalDate = LocalDate.now(clock);
        System.out.println(localDate);
        //2022-12-07
        System.out.println(clockLocalDate);
        //2022-12-07
        // 2.2 LocalTime 仅仅包含日历系统中的时间部分
        // 获取当前时间
        final LocalTime localTime = LocalTime.now();
        // 获取指定时钟的时间
        final LocalTime clockLocalTime = LocalTime.now(clock);
        System.out.println(localTime);
        //17:18:53.354
        System.out.println(clockLocalTime);
        //17:18:53.354
        // 2.3 LocalDataTime 包含了LocalDate LocalTime的信息，但是不包含ISO-8601日历系统中的时区信息
        //获取当前日期时间
        final LocalDateTime localDateTime = LocalDateTime.now();
        //获取指定时钟的日期时间
        final LocalDateTime clockDateTime = LocalDateTime.now(clock);
        System.out.println(localDateTime);
        //2022-12-07T17:22:24.648
        System.out.println(clockDateTime);
        //2022-12-07T17:22:24.648
        // 2.4格式化
        System.out.println("format: " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // 2.5获取时间戳
        System.out.println("秒数: " + localDateTime.toEpochSecond(ZoneOffset.of("+8")));
        System.out.println("秒数： " + localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli());
        // 2.6 Date与LocalDateTime互转
        // 将java8的java.time.LocalDateTime 转换为 java.util.Date，默认时区为东八区
        System.out.println("Date: " + Date.from(localDateTime.toInstant(ZoneOffset.of("+8"))));
        //Date: Wed Dec 07 17:46:47 CST 2022
        Date date = new Date();
        // 将java8 java.util.date转换为localdatetime
        System.out.println("LocalDateTime: " + date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
        //LocalDateTime: 2022-12-07T17:46:47.309
        //2.7 LocalDateTime时间加减
        System.out.println("当前时间：" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //当前时间：2022-12-07 17:46:47
        System.out.println("昨天时间：" + localDateTime.minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("明天时间：" + localDateTime.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));


        // 3.ZonedDateTime
        // 需要时区信息，可以使用ZoneDateTime，它保存有ISO-8601日期系统的日期和时间，而且有时区信息
        //获取当前时间日期
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        //获取指定时钟的日期时间
        final ZonedDateTime zonedDateTime1 = ZonedDateTime.now(clock);
        //获取纽约时区的当前日期时间
        final ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime);
        //2022-12-07T17:25:57.177+08:00[Asia/Shanghai]
        System.out.println(zonedDateTime1);
        //2022-12-07T09:25:57.177Z
        System.out.println(zonedDateTime2);
        //2022-12-07T04:25:57.178-05:00[America/New_York]

        // 4.Duration
        // 它持有的时间精确到秒和那表，利用它可以容易的计算两个日期之间的时间差
        final LocalDateTime from = LocalDateTime.of(2020, Month.APRIL, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of(2022, Month.DECEMBER, 17, 17, 29, 0);
        //获取时间差
        final Duration duration = Duration.between(from, to);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());

    }
}
