package org.melato.convert.xml;

import org.melato.convert.FormatManager;
import org.melato.convert.TypeFormatter;
import org.melato.xml.XMLWriter;

/**
 * Writes beans to XML
 */
public class ReflectionWriter<T> {
  private FormatManager formatManager = new FormatManager();
  private XMLWriter xml;
  private String tag;

  private PropertyReflector reflector;
  private TypeFormatter[] formatters;

  /**
   * @param beanClass  The class to use in order to construct beans.
   * @param collector  Where to put the resulting beans.
   */
  public ReflectionWriter(Class<T> beanClass, PropertyReflector reflector, XMLWriter xml, String tag) {
    this.reflector = reflector;
    this.xml = xml;
    this.tag = tag;
    reflector.setBeanClass(beanClass);
    formatters = new TypeFormatter[reflector.getPropertyCount()];
    for( int i = 0; i < formatters.length; i++ ) {
      formatters[i] = formatManager.get(reflector.getPropertyName(i), reflector.getPropertyType(i));
    }
  }
  
  public void write(T bean) {
    xml.println();
    xml.tagOpen(tag);
    for( int i = 0; i < formatters.length; i++ ) {
      String name = reflector.getPropertyName(i);
      if ( formatters[i] != null ) {
        try {
          Object value = reflector.getProperty(bean,  i );
          if ( value != null ) {
            xml.println();
            xml.tagOpen(name);
            xml.text(formatters[i].format(value));
            xml.tagEnd(name);
          }
        } catch (Exception e) {
          throw new RuntimeException( e );
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
