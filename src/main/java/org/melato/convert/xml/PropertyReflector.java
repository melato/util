package org.melato.convert.xml;


public interface PropertyReflector {
  void setBeanClass(Class<?> beanClass);
  int getPropertyCount();
  String getPropertyName(int index);
  Class<?> getPropertyType(int index);
  void setProperty(Object bean, int index, Object value) throws Exception;  
  Object getProperty(Object bean, int index) throws Exception;  
}
