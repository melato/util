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
