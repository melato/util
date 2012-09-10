package org.melato.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MethodWriter implements PropertyWriter {
  Method  method;
  
  public MethodWriter(Method method) {
    this.method = method;
  }

  
  @Override
  public Class<?> getPropertyType() {
    return method.getReturnType();
  }


  @Override
  public void apply(Object obj, Object value) {
    try {
      method.invoke(obj, value);
    } catch (IllegalArgumentException e) {
      throw new RuntimeException( e );
    } catch (IllegalAccessException e) {
      throw new RuntimeException( e );
    } catch (InvocationTargetException e) {
      throw new RuntimeException( e );
    }
  }  
  
}
