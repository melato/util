package org.melato.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Iterators {
  public static <T> Iterable<T> concatenate(Iterable<T> a, Iterable<T> b) {
    return new ConcatenationIterable<T>(a,b);
  }
  public static <T> Iterable<T> concatenate(Iterable<T> ... array) {
    return new ConcatenationIterable<T>(Arrays.asList(array));
  }
  public static <T> Iterable<T> concatenate(List<Iterable<T>> list) {
    return new ConcatenationIterable<T>(list);
  }
  private static class ConcatenationIterable<T> implements Iterable<T> {
    List<Iterable<T>> iterables;
    
    public ConcatenationIterable(List<Iterable<T>> iterables) {
      this.iterables = iterables;
    }
    public ConcatenationIterable(Iterable<T> a, Iterable<T> b) {
      iterables = new ArrayList<Iterable<T>>();
      iterables.add(a);
      iterables.add(b);
    }
    @Override
    public Iterator<T> iterator() {
      return new ConcatenationIterator<T>(iterables);
    }
    
  }
  private static class ConcatenationIterator<T> implements Iterator<T> {
    Iterator<Iterable<T>> iterables;
    Iterator<T> iterator;
    
    public ConcatenationIterator(List<Iterable<T>> iterables) {
      super();
      this.iterables = iterables.iterator();
    }
    @Override
    public boolean hasNext() {
      while( iterator == null || ! iterator.hasNext() ) {
        if ( iterables.hasNext() ) {
          iterator = iterables.next().iterator();
        } else {
          break;
        }
      }
      return iterator != null && iterator.hasNext();
    }
    @Override
    public T next() {
      if ( ! hasNext() )
        throw new IllegalArgumentException( "no next");
      return iterator.next();
    }
    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }    
  }


}
