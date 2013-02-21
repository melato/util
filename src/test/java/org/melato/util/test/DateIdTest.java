/*-------------------------------------------------------------------------
 * Copyright (c) 2012,2013, Alex Athanasopoulos.  All Rights Reserved.
 * alex@melato.org
 *-------------------------------------------------------------------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *-------------------------------------------------------------------------
 */
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
