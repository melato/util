package org.melato.util;

import java.util.AbstractList;

/** A fixed-size collection where old elements are discarded. */
public class CircularList<T> extends AbstractList<T> {
  private Object[] data;
  /** The index of the first element in the list. */
  private int start = 0;
  /** The index past the last element in the list.
   * When the list is full, start == end
   * */
  private int end = 0;
  private int size;
  
  public CircularList( int length) {
    data = new Object[length];
  }
  
  /** Return the number of points in the buffer.  Between 0 and size. */
  public int size() {
    return size;
  }
    
  /**
   * Get an element from the list.
   */
  @SuppressWarnings("unchecked")
  public T get(int i) {
    int size = size();    
    if ( i < 0 || i >= size ) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return (T) data[(start + i) % data.length];
  }
  
  @Override
  public boolean add(T e) {
    data[end] = e;
    end = (end + 1) % data.length;
    if ( size == data.length ) {
      start = end;
    } else {
      size++;
    }
    return true;
  }

  @Override
  public void add(int index, T e) {
    int length = data.length;
    if ( index > size / 2 + 1 ) {
      // shift the right part to the right
      for( int j = size; j >= index; j-- ) {
        // index is > 0, so j - 1 is >= 0
        data[(start + j) % length] = data[(start + j - 1) % length];
      }
      end = (end + 1) % length;
      if ( size == length ) {
        start = end;
      } else {
        size++;
      }
    } else {
      // shift the left part to the left
      for( int j = 0; j < index; j++ ) {
        data[(start + j - 1 + length) % length] = data[(start + j) % length];
      }
      start = (start - 1 + length) % length;
      if ( size == length ) {
        end = start;
      } else {
        size++;
      }      
    }
    data[(start + index) % length] = e;
  }

  @Override
  public T remove(int index) {
    if ( size == 0 )
      throw new IllegalArgumentException("cannot remove from an empty list" );
    T t = get(index);    
    int length = data.length;
    if ( index > size / 2 ) {
      // shift the right part to the left
      for( int j = index + 1; j < size; j++ ) {
        data[(start + j - 1) % length] = data[(start + j) % length];
      }
      end = (end - 1) % length;
    } else {
      // shift the left part to the right
      for( int j = index; j > 0; j-- ) {
        data[(start + j) % length] = data[(start + j - 1) % length];
      }
      start = (start + 1 + length) % length;
    }
    size--;
    return t;
  }
}
