package org.melato.convert.xml;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.melato.convert.ParserManager;
import org.melato.convert.TypeParser;
import org.melato.log.Log;
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
public class ReflectionHandler<T> extends XMLMappingHandler {
  private Class<T> beanClass;
  private PropertyReflector reflector;
  private XMLStringHandler[] handlers;
  private TypeParser[] parsers;
  private ParserManager parserManager = new ParserManager();
  private Collection<T> collector;

  /**
   * @param beanClass  The class to use in order to construct beans.
   * @param collector  Where to put the resulting beans.
   */
  public ReflectionHandler(Class<T> beanClass, PropertyReflector reflector, Collection<T> collector) {
    this.beanClass = beanClass;
    this.collector = collector;
    Log.info(beanClass.getName());
    this.reflector = reflector;
    reflector.setBeanClass(beanClass);
    handlers = new XMLStringHandler[reflector.getPropertyCount()];
    parsers = new TypeParser[handlers.length];
    for( int i = 0; i < handlers.length; i++ ) {
      parsers[i] = parserManager.getParser(reflector.getPropertyType(i));
      if ( parsers[i] != null ) {
        XMLStringHandler handler = new XMLStringHandler();
        setHandler( reflector.getPropertyName(i), handler );
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
      for( int i = 0; i < handlers.length; i++ ) {
        if ( handlers[i] != null ) {
          String text = handlers[i].getText();
          if ( text != null ) {
            Object value = parsers[i].parse(text);
            reflector.setProperty(bean, i, value);
          }          
        }
      }
      collector.add(bean);
    } catch (Exception e) {
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
  public void parse(String xmlPath, InputStream input) throws IOException, SAXException {
    XMLMappingHandler root = new XMLMappingHandler();
    root.setPathHandler(xmlPath, this );
    XMLDelegator.parse(root,  input);
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
