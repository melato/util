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
