/*-------------------------------------------------------------------------
 * Copyright (c) 2012, Alex Athanasopoulos.  All Rights Reserved.
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

import org.junit.Assert;
import org.junit.Test;
import org.melato.util.CircularList;

public class CircularListTest {

  public @Test void testFull() {
    int N = 2;
    CircularList<Integer> list = new CircularList<Integer>(N);
    for( int i = 0; i < N; i++ ) {
      list.add(i);
    }
    Assert.assertEquals(N, list.size());
    Assert.assertEquals(0, (int) list.get(0));
    Assert.assertEquals(1, (int) list.get(1));
  }

  
	public @Test void testAppend() {
	  int N = 2;
	  CircularList<Integer> list = new CircularList<Integer>(N);
	  for( int i = 0; i < 10; i++ ) {
	    list.add(i);
	  }
    Assert.assertEquals(N, list.size());
	  Assert.assertEquals(8, (int) list.get(0));
    Assert.assertEquals(9, (int) list.get(1));
	}

  public @Test void testInsertEmpty() {
    CircularList<Integer> list = new CircularList<Integer>(2);
    list.add(0, 7);
    Assert.assertEquals(1, list.size());
    Assert.assertEquals(7, (int) list.get(0));
  }

  public @Test void testInsert1() {
    CircularList<Integer> list = new CircularList<Integer>(2);
    list.add(7);
    list.add(0, 5);
    Assert.assertEquals(2, list.size());
    Assert.assertEquals(5, (int) list.get(0));
    Assert.assertEquals(7, (int) list.get(1));
  }
  
  public @Test void testRemoveLeft() {
    int N = 10;
    CircularList<Integer> list = new CircularList<Integer>(N);
    for( int i = 0; i < N; i++ ) {
      list.add(i);
    }
    Assert.assertEquals(N, list.size());
    Assert.assertEquals(0, (int) list.get(0));
    
    int removed = (int) list.remove(1);
    Assert.assertEquals(N-1, list.size());
    Assert.assertEquals(1, removed);
    Assert.assertEquals(0, (int) list.get(0));
    for( int i = 1; i < N - 1; i++ ) {
      Assert.assertEquals(i+1, (int) list.get(i));
    }
  }
  public @Test void testRemoveRight() {
    int N = 10;
    CircularList<Integer> list = new CircularList<Integer>(N);
    for( int i = 0; i < N; i++ ) {
      list.add(i);
    }
    Assert.assertEquals(N, list.size());
    int removed = (int) list.remove(8);
    Assert.assertEquals(N-1, list.size());
    Assert.assertEquals(8, removed);
    Assert.assertEquals(9, (int) list.get(8));
    for( int i = 0; i < 8; i++ ) {
      Assert.assertEquals(i, (int) list.get(i));
    }
  }
  
}
