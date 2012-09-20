package org.melato.util;

import java.util.AbstractList;
import java.util.List;

/**
 * Converts List<S> into a List<T>, provided S is a subclass of T.
 * (Since Java doesn't do this automatically)
 * @author Alex Athanasopoulos
 *
 * @param <S> Subclass of T
 * @param <T> Any class
 */
public class DelegateList<S,T> extends AbstractList<T> {
  private List<S> list;

  
  public DelegateList(List<S> list) {
    super();
    this.list = list;
  }

  @Override
  public T get(int index) {
    return (T) list.get(index);
  }

  @Override
  public int size() {
    return list.size();
  }
}
