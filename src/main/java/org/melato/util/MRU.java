package org.melato.util;

/**
 * Most-Recently-Used list.
 * A list that keeps the last N added items, so that item(0) is the most recently added item.
 * @author Alex Athanasopoulos
 * @param <T>
 */
public class MRU<T> extends CircularList<T> {
  /** Recent items go to the front. */
  public MRU() {
    this(10);
  }
  
  public MRU(int maxSize) {
    super(maxSize);
  }

  private int findItem(T item) {
    int size = size();
    for( int i = 0; i < size; i++ ) {
      if ( item.equals(get(i))) {
        return i;
      }
    }
    return -1;
  }
  
  @Override
  public boolean add(T item) {
    boolean added = true;
    int index = findItem(item);
    if ( index >= 0 ) {
      added = false;
      remove(index);
    }
    add(0, item);
    return added;
  }
}
