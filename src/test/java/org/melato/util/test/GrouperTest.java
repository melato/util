package org.melato.util.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.melato.util.AbstractGrouper;

public class GrouperTest {
  static class StringGrouper extends AbstractGrouper<String> {
    private List<String[]> groups = new ArrayList<String[]>();
    
    protected void addGroup(String[] array, int start, int end) {
      groups.add(Arrays.copyOfRange(array, start, end));
    }
      
    public List<String[]> getGroups() {
      return groups;
    }


    @Override
    protected boolean inSameGroup(String a, String b) {
      return a.length() > 0 && b.length() > 0 && a.charAt(0) == b.charAt(0);
    }
  }
  static class SequenceGrouper extends AbstractGrouper<Integer> {
    private List<int[]> groups = new ArrayList<int[]>();
    
    protected void addGroup(Integer[] array, int start, int end) {
      int[] group = new int[end-start];
      for( int i = start; i < end; i++ ) {
        group[i-start] = array[i];
      }
      groups.add(group);
    }
      
    public List<int[]> getGroups() {
      return groups;
    }

    @Override
    protected boolean inSameGroup(Integer a, Integer b) {
      return a + 1 == b;
    }
  }
  @Test public void groupStrings() {
    String[] array = new String[] { "a1", "a2", "a3", "b1", "b2" };
    StringGrouper grouper = new StringGrouper();
    grouper.group(array);
    List<String[]> groups = grouper.getGroups();
    Assert.assertEquals(2, groups.size());
    String[] group = groups.get(0);
    Assert.assertEquals(3, group.length);
    Assert.assertEquals("a1", group[0]);
    Assert.assertEquals("a2", group[1]);
    Assert.assertEquals("a3", group[2]);
  }
  @Test public void groupConsecutiveIntegers() {
    Integer[] array = new Integer[] { 1, 2, 3, 10, 11, 20 };
    SequenceGrouper grouper = new SequenceGrouper();
    grouper.group(array);
    List<int[]> groups = grouper.getGroups();
    Assert.assertEquals(3, groups.size());
    int[] group = groups.get(1);
    Assert.assertEquals(2, group.length);
    Assert.assertEquals(10, group[0] );
    Assert.assertEquals(11, group[1] );
  }
}
