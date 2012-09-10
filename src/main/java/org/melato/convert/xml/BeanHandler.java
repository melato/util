package org.melato.convert.xml;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.melato.convert.ParserManager;
import org.melato.convert.TypeParser;
import org.melato.xml.XMLDelegator;
import org.melato.xml.XMLMappingHandler;
import org.melato.xml.XMLStringHandler;
import org.melato.xml.XMLTag;
import org.xml.sax.SAXException;

/**
 * An XML parser that uses reflection to construct beans.
 * Use with XMLDelegator.
 * It maps xml element tags to bean property names.
 * It uses customizable type converters to convert text to property types.
 * @author Alex Athanasopoulos
 *
 * @param <T>
 */
public class BeanHandler<T> extends XMLMappingHandler {
  private Class<T> beanClass;
  private PropertyDescriptor[] properties;
  private XMLStringHandler[] handlers;
  private TypeParser[] parsers;
  private ParserManager parserManager = new ParserManager();
  private Collection<T> collector;

  /**
   * @param beanClass  The class to use in order to construct beans.
   * @param collector  Where to put the resulting beans.
   */
  public BeanHandler(Class<T> beanClass, Collection<T> collector) {
    this.beanClass = beanClass;
    this.collector = collector;
    BeanInfo beanInfo;
    try {
      beanInfo = Introspector.getBeanInfo(beanClass,Object.class);
    } catch (IntrospectionException e) {
      throw new RuntimeException( e );
    }
    properties = beanInfo.getPropertyDescriptors();
    handlers = new XMLStringHandler[properties.length];
    parsers = new TypeParser[properties.length];
    for( int i = 0; i < properties.length; i++ ) {
      parsers[i] = parserManager.getParser(properties[i].getPropertyType());
      if ( parsers[i] != null ) {
        XMLStringHandler handler = new XMLStringHandler();
        setHandler( properties[i].getName(), handler );
        handlers[i] = handler;        
      }
    }
  }
  @Override
  public void start(XMLTag tag) throws SAXException {
    super.start(tag);
  }
  @Override
  public void end() throws SAXException {
    try {
      T bean = beanClass.newInstance();
      for( int i = 0; i < properties.length; i++ ) {
        if ( handlers[i] != null ) {
          String text = handlers[i].getText();
          if ( text != null ) {
            Object value = parsers[i].parse(text);
            properties[i].getWriteMethod().invoke(bean, value);
          }          
        }
      }
      collector.add(bean);
    } catch (InstantiationException e) {
      throw new RuntimeException( e );
    } catch (IllegalAccessException e) {
      throw new RuntimeException( e );
    } catch (IllegalArgumentException e) {
      throw new RuntimeException( e );
    } catch (InvocationTargetException e) {
      throw new RuntimeException( e );
    }
  }
  
  
  /**
   * Parses beans out of an XML file (stream).
   * It uses a path of XML elements delimited by '/', for example "rss/channel/item".
   * This serves as a simple example of using BeanHandler.
   * @param path
   * @param input
   * @return
   * @throws IOException
   * @throws SAXException
   */
  public static <T> List<T> parse(Class<T> beanClass, String xmlPath, InputStream input) throws IOException, SAXException {
    List<T> beans = new ArrayList<T>();
    XMLMappingHandler root = new XMLMappingHandler();
    root.setPathHandler(xmlPath, new BeanHandler<T>(beanClass, beans));
    XMLDelegator.parse(root,  input);
    return beans;
  }
  /** Get the parser manager, which you can modify in order to customize the type parsers.  */
  public ParserManager getParserManager() {
    return parserManager;
  }
  /** Replace the parser manager, if you prefer, instead of modifying the default one. */
  public void setParserManager(ParserManager parserManager) {
    this.parserManager = parserManager;
  }
}
