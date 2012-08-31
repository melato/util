package org.melato.util;

import java.util.AbstractList;
import java.util.List;

public class IntArrays {
  public static List<Integer> asList(int[] array) {
    return new IntArrayList(array);
  }
  public static int[] toArray(List<Integer> list) {
    int[] array = new int[list.size()];
    for( int i = 0; i < array.length; i++ ) {
      array[i] = list.get(i);
    }
    return array;
  }
  
  private static class IntArrayList extends AbstractList<Integer> {
    private int[] array;
    
    
    public IntArrayList(int[] array) {
      this.array = array;
    }

    @Override
    public Integer get(int index) {
      return array[index];
    }

    @Override
    public int size() {
      return array.length;
    }

  }
  
}
