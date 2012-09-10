package org.melato.reflect;


public class FieldWriterFactory implements PropertyWriterFactory {
  Class<?> cls;
  
  public FieldWriterFactory(Class<?> cls) {
    this.cls = cls;
  }

  @Override
  public PropertyWriter getWriter(String name) {
    return new FieldWriter(cls, name);
  }
  
}
