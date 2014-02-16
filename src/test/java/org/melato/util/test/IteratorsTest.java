/*-------------------------------------------------------------------------
 * Copyright (c) 2012,2013,2014, Alex Athanasopoulos.  All Rights Reserved.
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

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.melato.util.Iterators;

public class IteratorsTest {
  public @Test void concatenate2() {
    List<String> x = Arrays.asList( new String[] { "a", "b" } );
    List<String> y = Arrays.asList( new String[] { "c" } );
    Iterator<String> it = Iterators.concatenate(x, y).iterator();
    Assert.assertTrue(it.hasNext());
    String a = it.next();
    Assert.assertTrue(it.hasNext());
    String b = it.next();
    Assert.assertTrue(it.hasNext());
    String c = it.next();
    Assert.assertFalse(it.hasNext());
    Assert.assertEquals("a", a);
    Assert.assertEquals("b", b);
    Assert.assertEquals("c", c);
  }
  public @Test void concatenateEmpty() {
    List<String> x = Arrays.asList( new String[0] );
    List<String> y = Arrays.asList( new String[] { "a" } );
    Iterator<String> it = Iterators.concatenate(x, y).iterator();
    Assert.assertTrue(it.hasNext());
    String a = it.next();
    Assert.assertFalse(it.hasNext());
    Assert.assertEquals("a", a);
  }

}
