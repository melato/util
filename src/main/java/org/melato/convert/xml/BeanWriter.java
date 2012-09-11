package org.melato.convert.xml;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.melato.convert.FormatManager;
import org.melato.convert.TypeFormatter;
import org.melato.xml.XMLWriter;

/**
 * Writes beans to XML
 */
public class BeanWriter<T> {
  private FormatManager formatManager = new FormatManager();
  private XMLWriter xml;
  private String tag;
  
  private PropertyDescriptor[] properties;
  private TypeFormatter[] formatters;

  /**
   * @param beanClass  The class to use in order to construct beans.
   * @param collector  Where to put the resulting beans.
   */
  public BeanWriter(Class<T> beanClass, XMLWriter xml, String tag) {
    this.xml = xml;
    this.tag = tag;
    BeanInfo beanInfo;
    try {
      beanInfo = Introspector.getBeanInfo(beanClass,Object.class);
    } catch (IntrospectionException e) {
      throw new RuntimeException( e );
    }
    properties = beanInfo.getPropertyDescriptors();
    formatters = new TypeFormatter[properties.length];
    for( int i = 0; i < properties.length; i++ ) {
      formatters[i] = formatManager.get(properties[i].getName(), properties[i].getPropertyType());
    }
  }
  
  public void write(T bean) {
    xml.println();
    xml.tagOpen(tag);
    for( int i = 0; i < properties.length; i++ ) {
      String name = properties[i].getName();
      if ( formatters[i] != null ) {
        Object value;
        try {
          value = properties[i].getReadMethod().invoke(bean);
        } catch (IllegalArgumentException e) {
          throw new RuntimeException( e );
        } catch (IllegalAccessException e) {
          throw new RuntimeException( e );
        } catch (InvocationTargetException e) {
          throw new RuntimeException( e );
        }
        if ( value != null ) {
          xml.println();
          xml.tagOpen(name);
          xml.text(formatters[i].format(value));
          xml.tagEnd(name);
        }
      }
    }
    xml.tagEnd(tag);    
  }

  public FormatManager getFormatManager() {
    return formatManager;
  }

  public void setFormatManager(FormatManager formatManager) {
    this.formatManager = formatManager;
  }
}
