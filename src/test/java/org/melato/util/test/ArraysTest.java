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
 