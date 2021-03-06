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

import org.junit.Assert;
import org.junit.Test;
import org.melato.util.Cache.LoadException;
import org.melato.util.CacheLoader;
import org.melato.util.SoftCache;

public class SoftCacheTest {
  static class TestLoader implements CacheLoader<Integer,Integer> {

    @Override
    public Integer load(Integer key) {
      return key * 10;
    }
    
  }
  public @Test void cacheTest() throws LoadException {
    SoftCache<Integer,Integer> cache = new SoftCache<Integer,Integer>(new TestLoader());
    Assert.assertEquals(10, (int) cache.get(1));
    Assert.assertEquals(10, (int) cache.get(1));
    Assert.assertEquals(20, (int) cache.get(2));
  }

}
