package org.melato.convert.xml;

import org.melato.xml.XMLWriter;

/**
 * Writes beans to XML
 */
public class BeanWriter<T> extends ReflectionWriter<T> {
  /**
   * @param beanClass  The class to use in order to construct beans.
   * @param collector  Where to put the resulting beans.
   */
  public BeanWriter(Class<T> beanClass, XMLWriter xml, String tag) {
    super(beanClass, new BeanPropertyReflector(), xml, tag);
  }
}
