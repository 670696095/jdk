package com.cuizhiwen.jdk.format.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 15:27
 */
public class TestTime {
    /**
     * 时间格式化
     * @param args
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
}
