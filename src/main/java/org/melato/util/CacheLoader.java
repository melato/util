package org.melato.util;

public interface CacheLoader <K,V> {
  V load(K key) throws Exception;

}
