package org.melato.convert.test;

import java.io.IOException;

import org.junit.Test;
import org.melato.convert.xml.FieldPropertyReflector;
import org.xml.sax.SAXException;

public class XmlFieldTest extends ReflectionTests {
  public @Test void parseTest() throws IOException, SAXException {
    verifyRead( new FieldPropertyReflector(), getClass().getResourceAsStream("beans.xml"));    
  }
  
  public @Test void readWriteReadTest() throws IOException, SAXException {
    verifyReadWriteRead(new FieldPropertyReflector() );
  }

}
