package com.cuizhiwen.jdk.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YTOString {
    public static String toUtf8(String orgStr) {
        // A StringBuffer Object
        StringBuffer sb = new StringBuffer();
        sb.append(orgStr);
        String conStr = "";
        String strUTF8 = "";
        try {
            conStr = new String(sb.toString().getBytes("UTF-8"));
            strUTF8 = URLEncoder.encode(conStr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        // return to String Formed
        return strUTF8;
    }

    public static String toGBK(String orgStr) {
        // A StringBuffer Object
        StringBuffer sb = new StringBuffer();
        sb.append(orgStr);
        String conStr = "";
        String strUTF8 = "";
        try {
            conStr = new String(sb.toString().getBytes("UTF-8"));
            strUTF8 = URLEncoder.encode(conStr, "GBK");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        // return to String Formed
        return strUTF8;
    }

    /**inpiut 转 String*/
    public static String is2String(InputStream is) {
        try {
            String line = "";
            StringBuffer buffer = null;

            BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            buffer = new StringBuffer();

            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }

            return buffer.toString();
        } catch (Exception e) {
            YTOLogger.getInstance().warn( "Exception", e);
            throw new RuntimeException(e);
        }
    }

    public static String subString(String text, int begin, int end) {
        if (StringUtils.isBlank(text))
            return text;
        int length = text.length();
        int size = end - begin;

        if (begin < 0 || end < 0 || (end - begin) < 0)
            return text;
        if (size < 1)
            return text;

        if (end <= length)
            return text.substring(begin, end);
        if (end > length)
            return text.substring(begin, length);

        return null;
    }

    public static long strByteSize( String data) {
        try {
            //return new StringBufferInputStream(inStr);
            byte[] bytes = data.getBytes("UTF-8");
            return bytes.length;
        } catch (Exception e) {
            YTOLogger.getInstance().warn( "str:{}", e, data);
            return 0;
        }
    }

    public static InputStream Str2InputStream( String str) {
        try {
            //return new StringBufferInputStream(inStr);
            ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes("UTF-8"));

            return stream;
        } catch (Exception e) {
            YTOLogger.getInstance().warn( "str:{}", e, str);
            return null;
        }
    }

    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * 时间格式校验  “yy-mm-dd hh:mm:ss”
     * @param date1
     * @return
     */
    public static boolean isValidDate(String date1, String date2) {

        String regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        if(!date1.matches(regex))
            return false;
        if(!date1.matches(regex))
            return false;

        String dateStr = "2037-12-31";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(date1);
            format.parse(date2);
            format.parse(dateStr);
        } catch (ParseException e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
           // convertSuccess = false;
            return false;
        }

        int startDay = 0;
        int endDay = 0;
        int date = 0;
        int nToday = 0;
        try {
            Date dateStart = format.parse(date1);
            Date datEnd = format.parse(date2);
            Date standDate = format.parse(dateStr);
            Date today = format.parse(format.format(new Date()));
            startDay = (int) (dateStart.getTime() / 1000);
            endDay = (int) (datEnd.getTime() / 1000);
            date = (int) (standDate.getTime() / 1000);
            nToday = (int) (today.getTime() / 1000);
            if(endDay < startDay)
                return false;
            if(startDay > date)
                return false;
            if(endDay > date)
                return false;
            if(startDay<nToday)
                return false;
        } catch (Exception e) {
            YTOLogger.getInstance().error( "str:{}", e);
            return false;
        }
        return true;
    }
}
