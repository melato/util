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
