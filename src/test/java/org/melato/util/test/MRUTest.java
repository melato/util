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

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.melato.util.MRU;

public class MRUTest {

	public @Test void testAppend() {
	  int N = 2;
	  List<String> mru = new MRU<String>(N); 
	  for( int i = 0; i < 10; i++ ) {
	    mru.add("x" + i);
	  }
    Assert.assertEquals(N, mru.size());
	  Assert.assertEquals("x9", mru.get(0));
    Assert.assertEquals("x8", mru.get(1));
	}

  public @Test void testUpdate() {
    int N = 2;
    List<String> mru = new MRU<String>(N); 
    for( int i = 0; i < 10; i++ ) {
      mru.add("x" + i);
    }
    mru.add("x1");
    Assert.assertEquals(N, mru.size());
    Assert.assertEquals("x1", mru.get(0));
    Assert.assertEquals("x9", mru.get(1));
  }
	
}
