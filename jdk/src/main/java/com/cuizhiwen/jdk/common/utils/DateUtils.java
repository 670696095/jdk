/*
 * Copyright © 2015-2026 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cuizhiwen.jdk.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author he
 * @since 1.0.0
 */
@Slf4j
@SuppressWarnings("all")
public class DateUtils {
    private DateUtils() {

    }

    /**
     * 判断时间和格式是否匹配
     *
     * @param timeStr 时间字符串
     * @param pattern 格式
     * @return 是否匹配
     */
    public static boolean isValidFormatDate(final String timeStr, final String pattern) {
        boolean convertSuccess = true;
        String pat = "yyyy-MM-dd HH:mm:ss";
        if (StringUtils.isNotEmpty(pattern)) {
            pat = pattern;
        }
        SimpleDateFormat format = new SimpleDateFormat(pat);
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(timeStr);
        } catch (final Exception e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }
    /**
     * 将时间戳转换为时间字符串
     *
     * @param timeStamp 时间戳
     * @param format  格式
     * @return 格式字符串
     */

    public static String timeStamp2Date(long timeStamp, String format) {
        try {
            if (StringUtils.isEmpty(format)) {
                format = "yyyy-MM-dd HH:mm:ss";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(timeStamp);
        } catch (Exception e) {
            log.info("timeStamp={},format={}", timeStamp, format);
            log.error("timeStamp2Date error", e);
            return "";
        }
    }

    /**
     * 将时间戳转换为时间字符串
     *
     * @param date 时间戳
     * @param format  格式
     * @return 格式字符串
     */
    public static String dateFormat(Date date, String format) {
        try {
            if (date == null) {
                return "";
            }
            if (format == null || format.isEmpty()) {
                format = "yyyy-MM-dd HH:mm:ss";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception e) {
            log.error("dateFormat error", e);
            return "";
        }
    }
    /**
     * 将字符串时间转换为时间戳
     *
     * @param date 时间戳
     * @param format  格式
     * @return 格式字符串
     */
    public static Long dateStrFormat(String dateStr) {
        try {
            if (StringUtils.isEmpty(dateStr)) {
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(dateStr);
            return date.getTime();
        } catch (Exception e) {
            log.error("dateFormat error", e);
            return null;
        }
    }
    /**
     * 将时间戳毫秒转换为时间字符串
     *
     * @param seconds 时间戳
     * @param format  格式
     * @return 格式字符串
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }

    public static String addDay(String s, int n) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(s));
            cd.add(Calendar.DATE, n);
            return sdf.format(cd.getTime());

        } catch (Exception e) {
            return "转换异常";
        }
    }
}
