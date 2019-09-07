package com.micro.system.util;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Noageir
 * Date:2018-05-06 22:20
 * Project:com.spring.cloud
 * Package:com.micro.system.eureka
 */
public class DateUtil {
    public static final String FORMAT_1 = "yyyyMMddHHmmss";

    public static final String FORMAT_2 = "YYYY-MM-DD";

    public static final String FORMAT_3 = "yyyy年MM月dd日";

    public static final String FORMAT_4 = "yyyyMMdd";

    public static final String FORMAT_5 = "yyyy-MM-dd";

    public static final String FORMAT_6 = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_7 = "HH:mm:ss";

    private static final int CALENDAR_DEFAULT_YEAR = 1990;

    private static final int CALENDAR_DEFAULT_MONTH = 1;

    private static final int CALENDAR_DEFAULT_DAY = 1;

    private DateUtil() {
    }

    /**
     * 格式化指定的时间
     */
    private static String formatDate(Date date, String format) {
        if (date == null || StringUtils.isBlank(format)) {
            return "";
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 将format格式的字符串时间格式化为yyyyMMdd的
     */
    public static String formatDate(String date, String format) throws ParseException {
        return formatDate(parseDate(date, format), FORMAT_4);
    }

    /**
     * 格式化当前时间
     */
    public static String formatCurrentDate(String format) {
        return formatDate(new Date(), format);
    }

    /**
     * 获取当前时间戳
     */
    public static String generateSystemTimestamp() {
        Date currentDate = new Date();
        return String.valueOf(currentDate.getTime());
    }

    /**
     * 获取当前时间戳
     *
     * @return String
     */
    static String generateCurrentTimeMillis() {
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 判断firstTime是否在secondTime之后，忽略日期部分
     */
    private static boolean isTimeAfter(Date firstTime, Date secondTime) {

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(firstTime);
        calendar1.set(CALENDAR_DEFAULT_YEAR, Calendar.FEBRUARY, CALENDAR_DEFAULT_DAY);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(secondTime);
        calendar2.set(CALENDAR_DEFAULT_YEAR, Calendar.FEBRUARY, CALENDAR_DEFAULT_DAY);
        return calendar1.after(calendar2);
    }

    /**
     * 判断firstTime是否在secondTime之前，忽略日期部分
     */
    public static boolean isTimeBefore(Date firstTime, Date secondTime) {
        return isTimeAfter(secondTime, firstTime);
    }


    /**
     * 判断firstTime是否在secondTime之后，不忽略日期部分
     */
    private static boolean isTimeAfterIncludeDate(Date firstTime, Date secondTime) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(firstTime);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(secondTime);
        return calendar1.after(calendar2);
    }

    /**
     * 判断firstTime是否在secondTime之前，不忽略日期部分
     */
    public static boolean isTimeBeforeIncludeDate(Date firstTime, Date secondTime) {
        return isTimeAfterIncludeDate(secondTime, firstTime);
    }

    /**
     * 获取date添加minutes分钟后的时间
     */
    public static Date addMinutes(Date date, int minutes) {
        return DateUtils.addMinutes(date, minutes);
    }


    /**
     * 格式化字符串为时间类型
     */
    private static Date parseDate(String date, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }

    /**
     * 格式化字符串为时间类型(严格模式)
     */
    public static Date parseDateStrict(String date, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat.parse(date);
    }

    /**
     * 获取年月日
     */
    public static String getDate() {
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        String monthFormat = month < 10 ? "0" + month : String.valueOf(month);
        String dateFormat = date < 10 ? "0" + date : String.valueOf(date);
        return year + monthFormat + dateFormat;
    }
}
