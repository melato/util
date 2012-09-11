package org.melato.convert.test;

import java.io.IOException;

import org.junit.Test;
import org.melato.convert.xml.BeanPropertyReflector;
import org.xml.sax.SAXException;

public class XmlBeanTest extends ReflectionTests {
  public @Test void parseTest() throws IOException, SAXException {
    verifyRead( new BeanPropertyReflector(), getClass().getResourceAsStream("beans.xml"));    
  }
  
  public @Test void readWriteReadTest() throws IOException, SAXException {
    verifyReadWriteRead(new BeanPropertyReflector() );
  }

}
