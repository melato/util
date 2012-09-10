package org.melato.reflect;


public interface PropertyWriter {
  Class<?> getPropertyType();
  void apply(Object obj, Object value);
}
