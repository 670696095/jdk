package com.cuizhiwen.jdk.common.format.time;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/25 10:46
 */
public class TCalendar {
    public static void main(String[] args) {
        /**
         * 取得年月日、小时分钟秒？
         */
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        // 0 - 11
        System.out.println(cal.get(Calendar.MONTH) + 1);
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        // 1 - 12
        System.out.println(dt.getMonthValue());
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
        /**
         * 取得从 1970 年 1 月 1 日 0 时 0 分 0 秒到现在的毫秒数？
         */
        Calendar.getInstance().getTimeInMillis(); //第一种方式
        System.currentTimeMillis(); //第二种方式
        // Java 8
        Clock.systemDefaultZone().millis();
        /**
         * 取得某月的最后一天？
         */
        SimpleDateFormat format = new SimpleDateFormat();
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        //设置为 1 号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        String first = format.format(c.getTime());
        System.out.println("===============first:" + first);
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        System.out.println("===============last:" + last);
        //Java 8
        LocalDate today = LocalDate.now();
        //本月的第一天
        LocalDate firstday = LocalDate.of(today.getYear(), today.getMonth(), 1);
        //本月的最后一天
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月的第一天" + firstday);
        System.out.println("本月的最后一天" + lastDay);
        /**
         *  如何格式化日期？
         *      1）Java.text.DataFormat 的子类（如 SimpleDateFormat 类）中的 format(Date)方法可将日期格式化。
         *      2）Java 8 中可以用 java.time.format.DateTimeFormatter 来格式化时间日期，代码如下所示：
         *  补充：Java 的时间日期 API 一直以来都是被诟病的东西，为了解决这一问题，Java 8 中引入了新的时间日期 API，
         *      其中包括 LocalDate、LocalTime、LocalDateTime、Clock、Instant 等类，这些的类的设计都使用了不变模式，因
         *      此是线程安全的设计
         */
        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));
        // Java 8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));
        /**
         * 打印昨天的当前时刻？
         */
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());
        //java-8
        LocalDateTime today1 = LocalDateTime.now();
        LocalDateTime yesterday = today1.minusDays(1);
        System.out.println(yesterday);

    }
}
