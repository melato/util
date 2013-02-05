package org.melato.util;


public interface Cache<K, V> {
  public static class LoadException extends Exception {
    private static final long serialVersionUID = 1L;

    public LoadException(Throwable cause) {
      super(cause);
    }
  }
  
  V get(K key) throws LoadException;

}