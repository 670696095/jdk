package com.cuizhiwen.jdk.common.format.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 15:27
 */
public class TestTime   {
    /**
     * 时间格式化:
     * Date --- 表示日期的类 --- SimpleDateFormat --- 可以在日期和字符串之间
     * 进行转化，但是在转化的时候需要指定转化格式
     * Calendar --- 表示日历的类 --- 在jdk1.2出现，推荐使用这个类来取代Date
     * 日期比较：
     * Java使用以下三种方法来比较两个日期：
     *      使用 getTime() 方法获取两个日期（自1970年1月1日经历的毫秒数值），然后比较这两个值。
     *      使用方法 before()，after() 和 equals()。例如，一个月的12号比18号早，则 new Date(99, 2, 12).before(new Date (99, 2, 18)) 返回true。
     *      使用 compareTo() 方法，它是由 Comparable 接口定义的，Date 类实现了这个接口。
     */
    public static void main(String[] args) {
        /**
         * 使用Calendar
         */
        Calendar now = Calendar.getInstance();
        System.out.println("年：" + now.get(Calendar.YEAR));
        System.out.println("月：" + (now.get(Calendar.MONTH) + 1));
        System.out.println("日：" + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("时：" + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("分：" + now.get(Calendar.MINUTE));
        System.out.println("秒：" + now.get(Calendar.SECOND));

        /**
         * 使用Date
         */
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间：" + sdf.format(d));

        fun();


    }

    /**
     * 获取日期相差的天数
     * @param date1
     * @param date2
     * @return
     */
    private static int dayBetween(Date date1, Date date2){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long betweenDays = (time2 - time1)/(24*3600*1000);
        return  Integer.parseInt(String.valueOf(betweenDays));
    }

    /**
     * 计算执行时间差
     */
    private static void fun(){
        try {
            long start = System.currentTimeMillis( );
            System.out.println(new Date( ) + "\n");
            Thread.sleep(5*60*10);
            System.out.println(new Date( ) + "\n");
            long end = System.currentTimeMillis( );
            long diff = end - start;
            System.out.println("Difference is : " + diff);
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
    }


}
