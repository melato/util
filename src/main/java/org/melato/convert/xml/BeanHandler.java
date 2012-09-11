package org.melato.convert.xml;

import java.util.Collection;

/**
 * An XML parser that uses reflection to construct beans.
 * Use with XMLDelegator.
 * It maps xml element tags to bean property names.
 * It uses customizable type converters to convert text to property types.
 * @author Alex Athanasopoulos
 *
 * @param <T>
 */
public class BeanHandler<T> extends ReflectionHandler<T> {

  /**
   * @param beanClass  The class to use in order to construct beans.
   * @param collector  Where to put the resulting beans.
   */
  public BeanHandler(Class<T> beanClass, Collection<T> collector) {
    super(beanClass, new BeanPropertyReflector(), collector);
  }

}
