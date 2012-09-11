package org.melato.convert;

import java.util.HashMap;
import java.util.Map;

/** Maps names and/or classes to T */ 
public abstract class TypeManager<T> {
  private Map<String,T> handlersForName = new HashMap<String,T>();
  private Map<Class<?>,T> handlersForType = new HashMap<Class<?>,T>();
  
  /** Specify the handler to use for a field of a given type. */
  public void set(Class<?> type, T handler) {
    handlersForType.put(type,  handler);    
  }

  /** Specify the handler to use for a specific field. */
  public void set(String fieldName, T handler) {
    handlersForName.put(fieldName,  handler);    
  }

  protected abstract T getDefault(Class<?> type);
    
  public T get(Class<?> type) {
    T handler = handlersForType.get(type);
    if ( handler != null || handlersForType.containsKey(type))
      return handler;
    return getDefault(type);
  }

  public T get(String name, Class<?> type ) {
    T handler = handlersForName.get(name);
    if ( handler != null || handlersForType.containsKey(name))
      return handler;
    return getDefault(type);
  }
}
