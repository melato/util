package org.melato.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * A cached map that uses SoftReferences to store the values.
 * @author Alex Athanasopoulos
 *
 * @param <K>
 * @param <V>
 */
public class SoftCache<K,V> implements Cache<K, V> {
  private CacheLoader<K,V> loader;
  private Map<K,CacheReference<K,V>> map = new HashMap<K,CacheReference<K,V>>();
  private ReferenceQueue<V>  queue;
  
  static class CacheReference<K,V> extends SoftReference<V> {
    K key;
    public CacheReference(K key, V value, ReferenceQueue<? super V> q) {
      super(value, q);
      this.key = key;
    }    
  }
  
  public SoftCache(CacheLoader<K, V> loader) {
    super();
    this.loader = loader;
    queue = new ReferenceQueue<V>();
  }

  synchronized private void cleanup() {
    for(;;) {
      CacheReference<K,V> ref = (CacheReference<K,V>) queue.poll();
      if ( ref == null) {
        break;
      }
      map.remove(ref.key);
    }
  }
  synchronized public V get(K key) throws LoadException {
    SoftReference<V> ref = map.get(key);
    if ( ref != null ) {
      V value = ref.get();
      if ( value != null ) {
        return value;        
      }
    }
    cleanup();
    V v;
    try {
      v = loader.load(key);
    } catch (Exception e) {
      throw new LoadException( e );
    }
    map.put(key,  new CacheReference<K,V>(key, v,queue));
    return v;
  }

}
