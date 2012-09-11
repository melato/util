package org.melato.convert.xml;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;


public class BeanPropertyReflector implements PropertyReflector {
  private PropertyDescriptor[] properties;

  @Override
  public void setBeanClass(Class<?> beanClass) {
    BeanInfo beanInfo;
    try {
      beanInfo = Introspector.getBeanInfo(beanClass,Object.class);
    } catch (IntrospectionException e) {
      throw new RuntimeException( e );
    }
    properties = beanInfo.getPropertyDescriptors();
  }

  @Override
  public int getPropertyCount() {
    return properties.length;
  }

  @Override
  public Class<?> getPropertyType(int index) {
    return properties[index].getPropertyType();
  }
  
  @Override
  public String getPropertyName(int index) {
    return properties[index].getName();
  }

  @Override
  public void setProperty(Object bean, int index, Object value) throws Exception {
    properties[index].getWriteMethod().invoke(bean, value);
  }

  @Override
  public Object getProperty(Object bean, int index) throws Exception {
    return properties[index].getReadMethod().invoke(bean);
  }

}
