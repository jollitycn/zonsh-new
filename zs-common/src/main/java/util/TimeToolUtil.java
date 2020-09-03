package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangJin
 *
 * @date 2019年5月30日 下午3:31:15
 *
 */
public class TimeToolUtil {
  /**
   * 时间格式：yyyy-MM.
   */
  public static final String DATEFORMAT_Y4_MM = "yyyy-MM";

  /**
   * 时间格式：yyyy-MM-dd.
   */
  public static final String DATEFORMAT_Y4_MM_DD = "yyyy-MM-dd";
  public static final String DATEFORMAT_Y4MM_DD = "yyyy年MM月dd日";
  /**
   * 时间格式：yy-MM-dd.
   */
  public static final String DATEFORMAT_Y2_MM_DD = "yy-MM-dd";

  /**
   * 时间格式：yyyy-MM-dd HH:mm:ss.
   */
  public static final String DATEFORMAT_Y4_MM_DD_HMS = "yyyy-MM-dd HH:mm:ss";

  /**
   * 时间格式：yyyy-MM-dd HH:mm.
   */
  public static final String DATEFORMAT_Y4_MM_DD_HM = "yyyy-MM-dd HH:mm";

  /**
   * yyyyMMddHHmm格式的时间字符串，转成Date
   *
   * @param dateStr str
   * @param format forMat
   * @return date
   */
  public static Date parseStringToDate(final String dateStr,
      final String format) {
    SimpleDateFormat sdfOrd = new SimpleDateFormat(DATEFORMAT_Y4_MM_DD_HMS);
    Date date = null;
    try {
      if (!isNullOrEmpty(format)) {
        sdfOrd = new SimpleDateFormat(format);
      }
      if (!isNullOrEmpty(dateStr)) {
        date = sdfOrd.parse(dateStr);
      }
    } catch (final ParseException e) {
      try {
        sdfOrd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = sdfOrd.parse(dateStr);
      } catch (final ParseException e1) {
        return null;
      }
    }
    return date;
  }

  public static Boolean isNullOrEmpty(final Object str) {
    if (str == null || str == "") {
      return true;
    }
    return false;
  }

  /**
   * 将date类型转成字串.
   *
   * @param date
   * @param formart forMart
   * @return String
   */
  public static String parseDateToString(final Date date,
      final String formart) {
    String s = "";
    try {
      SimpleDateFormat sdf1 = new SimpleDateFormat(DATEFORMAT_Y4_MM_DD_HMS);
      if (!isNullOrEmpty(formart)) {
        sdf1 = new SimpleDateFormat(formart);
      }
      if (date != null) {
        s = sdf1.format(date);
      }
    } catch (final Exception e) {
      s = "";
    }
    return s;
  }

  // 获取本周的开始时间
  public static Date getBeginDayOfWeek() {
    final Date date = new Date();
    final Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
    if (dayofweek == 1) {
      dayofweek += 7;
    }
    cal.add(Calendar.DATE, 2 - dayofweek);
    return cal.getTime();
  }

  // 获取本周的结束时间
  public static Date getEndDayOfWeek() {
    final Calendar cal = Calendar.getInstance();
    cal.setTime(getBeginDayOfWeek());
    cal.add(Calendar.DAY_OF_WEEK, 6);
    final Date weekEndSta = cal.getTime();
    return weekEndSta;
  }

  // 获取本月的开始时间
  public static Date getBeginDayOfMonth() {
    final Calendar calendar = Calendar.getInstance();
    calendar.set(getNowYear(), getNowMonth() - 1, 1);
    return calendar.getTime();
  }

  // 获取本月的结束时间
  public static Date getEndDayOfMonth() {
    final Calendar calendar = Calendar.getInstance();
    calendar.set(getNowYear(), getNowMonth() - 1, 1);
    final int day = calendar.getActualMaximum(5);
    calendar.set(getNowYear(), getNowMonth() - 1, day);
    return calendar.getTime();
  }

  // 获取今年是哪一年
  public static Integer getNowYear() {
    final Date date = new Date();
    final GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
    gc.setTime(date);
    return Integer.valueOf(gc.get(1));
  }

  // 获取本月是哪一月
  public static int getNowMonth() {
    final Date date = new Date();
    final GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
    gc.setTime(date);
    return gc.get(2) + 1;
  }

  public static Map<String, String> getMarkTheCorrespondingTime(
      final Integer mark) {
    final Map<String, String> map = new HashMap<>();
    if (mark == 0) {// 今天
      map.put("start", parseDateToString(new Date(), DATEFORMAT_Y4_MM_DD));
      map.put("end", parseDateToString(new Date(), DATEFORMAT_Y4_MM_DD));
    } else if (mark == 1) {// 本周
      map.put("start",
          parseDateToString(getBeginDayOfWeek(), DATEFORMAT_Y4_MM_DD));
      map.put("end", parseDateToString(getEndDayOfWeek(), DATEFORMAT_Y4_MM_DD));
    } else {//本月
      map.put("start",
          parseDateToString(getBeginDayOfMonth(), DATEFORMAT_Y4_MM_DD));
      map.put("end",
          parseDateToString(getEndDayOfMonth(), DATEFORMAT_Y4_MM_DD));
    }
    return map;
  }

 /* public static void main(final String[] args) {
    System.out.println("本周开始时间："
        + parseDateToString(getBeginDayOfWeek(), DATEFORMAT_Y4_MM_DD));
    System.out.println("获取本周的结束时间："
        + parseDateToString(getEndDayOfWeek(), DATEFORMAT_Y4_MM_DD));
    System.out.println("本月开始时间："
        + parseDateToString(getBeginDayOfMonth(), DATEFORMAT_Y4_MM_DD));
    System.out.println(" 获取本月的结束时间："
        + parseDateToString(getEndDayOfMonth(), DATEFORMAT_Y4_MM_DD));
    System.out
        .println("今天：" + parseDateToString(new Date(), DATEFORMAT_Y4_MM_DD));
  }*/
}
