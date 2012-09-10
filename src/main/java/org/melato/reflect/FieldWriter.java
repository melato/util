package org.melato.reflect;

import java.lang.reflect.Field;


public class FieldWriter implements PropertyWriter {
  Class<?> cls;
  Field field;
  
  public FieldWriter(Class<?> cls, String name) {
    this.cls = cls;
    try {
      field = cls.getField(name);
    } catch (SecurityException e) {
      throw new RuntimeException( e );
    } catch (NoSuchFieldException e) {
      throw new RuntimeException( e );
    }    
    
  }

  @Override
  public Class<?> getPropertyType() {
    return field.getType();
  }

  @Override
  public void apply(Object obj, Object value) {
    try {
      field.set(obj, value);
    } catch (IllegalArgumentException e) {
      throw new RuntimeException( e );
    } catch (IllegalAccessException e) {
      throw new RuntimeException( e );
    }
  }  
  
}
