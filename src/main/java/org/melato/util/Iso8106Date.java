package org.melato.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Iso8106Date {
  static TimeZone utc = TimeZone.getTimeZone( "GMT" );
  static Pattern datePattern = Pattern.compile( "([0-9]{4})-([0-9]{1,2})-([0-9]{1,2})T([0-9]{1,2}):([0-9]{2}):([0-9\\.]*)([Z+-].*)");
  static Pattern tzPattern = Pattern.compile( "([-+])([0-9]{2}):([0-9]{2})");

  public static Date parseDate(String s) {
    long time = parseTime(s);
    if ( time != 0 )
      return new Date(time);
    return null;
  }
  public static int parseTimeZone(String tz) {
    if ( "Z".equals(tz)) {
      return 0;
    }
    Matcher matcher = tzPattern.matcher(tz);
    if ( matcher.matches()) {
      int minutes = 60*Integer.parseInt(matcher.group(2)) + Integer.parseInt(matcher.group(3));
      String sign = matcher.group(1);
      if ( "-".equals(sign)) {
        minutes = - minutes;
      }
      return minutes;
    }
    return 0;    
  }
  /**
   * Parse a GPX date (ISO 8601). 
   * Example:  2011-09-25T10:17:37Z
   * @param s
   */
  public static long parseTime(String s) {
    if ( s == null )
      return 0;
    s = s.trim();
    if ( s.length() == 0 )
      return 0;
    Matcher matcher = datePattern.matcher(s);
    if ( matcher.matches() ) {
      int year = Integer.parseInt( matcher.group(1));
      int month = Integer.parseInt( matcher.group(2));
      int day = Integer.parseInt( matcher.group(3));
      int hour = Integer.parseInt( matcher.group(4));
      int minute = Integer.parseInt( matcher.group(5));
      float second = Float.parseFloat( matcher.group(6));
      int millisecond = Math.round(second*1000);
      boolean isUtc = "Z".equals( matcher.group(7));
      GregorianCalendar calendar = new GregorianCalendar(year,  month - 1, day, hour, minute);      
      if ( isUtc ) {
        calendar.setTimeZone(utc);
      } else {
        calendar.setTimeZone(utc);
        int minutes = parseTimeZone(matcher.group(7));
        calendar.add(Calendar.MINUTE, -minutes);
      }
      long time = calendar.getTimeInMillis();
      time += millisecond;
      return time;
    }
    throw new IllegalArgumentException( "Invalid date: " + s );
  }
  

}
