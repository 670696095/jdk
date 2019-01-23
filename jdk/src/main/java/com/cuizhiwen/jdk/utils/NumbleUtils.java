package com.cuizhiwen.jdk.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * <pre>
 * 名称: NumbleUtils
 * 描述:
 * </pre>
 *
 **/

public class NumbleUtils {
    public static Double getDouble(Double num){
        if (num == null){
            return null;
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        //去掉千分位逗号
        nf.setGroupingUsed(false);
        // 保留两位小数
        nf.setMaximumFractionDigits(2);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        return Double.valueOf(nf.format(num));
    }
    /**
     * double 保留两位小数（四舍五入）
     * @param db
     * @return double
     */
    public static Double DoubleFormat(Double db) {
        if (db == null) {
            return null;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        String string = df.format(db);
//        NumberFormat nf = NumberFormat.getNumberInstance();
        //去掉千分位逗号
//        nf.setGroupingUsed(false);
        return Double.parseDouble(string);
    }
    /**
     *  bigdecimal 数据格式化
     * @param string
     * @return
     */
    public static String bigDecimalFormart(String string) {
        if (StringUtils.isEmpty(string)) {
            return null;
        }
        BigDecimal b = new BigDecimal(string);
        return b.setScale(2,BigDecimal.ROUND_HALF_UP).toString();
    }
    
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        Double d = 123.9;
        System.out.println( bigDecimalFormart(d.toString()));
       bigDecimalFormart(d.toString());
       Double double2 = DoubleFormat(19274123.022);
       System.out.println(NumbleUtils.getDouble(19274123.022));

    }
}
