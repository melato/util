package org.melato.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;


public class BeanWriterFactory implements PropertyWriterFactory {
  Class<?> cls;
  
  public BeanWriterFactory(Class<?> cls) {
    this.cls = cls;
  }

  @Override
  public PropertyWriter getWriter(String name) {
    PropertyDescriptor descriptor;
    try {
      descriptor = new PropertyDescriptor(name, cls);
      return new MethodWriter(descriptor.getWriteMethod());
    } catch (IntrospectionException e) {
      throw new RuntimeException( e );
    }    
  }
  
}
