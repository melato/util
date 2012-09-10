package org.melato.reflect;


public interface PropertyWriterFactory {
  PropertyWriter getWriter(String name);
}
