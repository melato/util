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

import org.junit.Assert;
import org.junit.Test;

/** A unit test that shows that arrays of equal elements are not equal. */
public class ArraysTest {
  public @Test void arraysEquals() {
    int[] a1 = new int[] {2,13,7};
    int[] a2 = new int[] {2,13,7};
    Assert.assertTrue(Arrays.equals(a1, a2));
    Assert.assertFalse(a1.equals(a2));
  }
  public @Test void arraysHashCode() {
    int[] a1 = new int[] {2,13,7};
    int[] a2 = new int[] {2,13,7};
    Assert.assertFalse(a1.hashCode() == a2.hashCode());
  }
}
 