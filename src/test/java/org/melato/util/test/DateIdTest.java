package org.melato.util.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.melato.util.DateId;

public class DateIdTest {
  public @Test void fromCalendar() {
    Calendar cal = new GregorianCalendar();
    cal.set(Calendar.YEAR, 2012);
    cal.set(Calendar.MONTH, Calendar.DECEMBER);
    cal.set(Calendar.DAY_OF_MONTH, 25);
    int dateId = DateId.dateId(cal);
    Assert.assertEquals(20121225, dateId);    
  }
  public @Test void fromNumbers() {
    int dateId = DateId.dateId(2012, 12, 17);
    Assert.assertEquals(20121217, dateId);    
  }
  public @Test void string() {
    Assert.assertEquals("2012-12-17", DateId.toString(20121217));    
  }

}
