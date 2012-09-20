package org.melato.util;

import java.util.AbstractCollection;
import java.util.Iterator;

public class AbstractCollector<T> extends AbstractCollection<T> {
  protected int size;

  @Override
  public boolean add(T e) {
    size++;
    return true;
  }

  @Override
  public Iterator<T> iterator() {
    throw new UnsupportedOperationException();
  }

  @Override
  public int size() {
    return size;
  }
}
