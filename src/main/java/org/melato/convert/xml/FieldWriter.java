package org.melato.convert.xml;

import org.melato.xml.XMLWriter;

/**
 * Writes beans to XML
 */
public class FieldWriter<T> extends ReflectionWriter<T> {
  /**
   * @param beanClass  The class to use in order to construct beans.
   * @param collector  Where to put the resulting beans.
   */
  public FieldWriter(Class<T> beanClass, XMLWriter xml, String tag) {
    super(beanClass, new FieldPropertyReflector(), xml, tag);
  }
}
