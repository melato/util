package org.melato.convert.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.melato.convert.xml.BeanWriter;
import org.melato.convert.xml.PropertyReflector;
import org.melato.convert.xml.ReflectionHandler;
import org.melato.xml.XMLWriter;
import org.xml.sax.SAXException;


public class ReflectionTests {
  public void verifyRead(PropertyReflector reflector, InputStream in) throws IOException, SAXException {
    List<TestBean> beans = new ArrayList<TestBean>();
    ReflectionHandler<TestBean> handler = new ReflectionHandler<TestBean>(TestBean.class, reflector, beans);
    handler.parse("beans/bean", in );    
    Assert.assertEquals(2, beans.size());
    TestBean bean = null;
    bean = beans.get(0);
    Assert.assertEquals("name1", bean.getName());
    Assert.assertEquals(1, bean.getCount());
    bean = beans.get(1);
    Assert.assertEquals("name2", bean.getName());
    Assert.assertEquals(2, bean.getCount());
  }
  
  public void verifyReadWriteRead(PropertyReflector reflector) throws IOException, SAXException {
    // read beans from the resource
    List<TestBean> beans = new ArrayList<TestBean>();
    ReflectionHandler<TestBean> handler = new ReflectionHandler<TestBean>(TestBean.class, reflector, beans);
    handler.parse("beans/bean", getClass().getResourceAsStream("beans.xml") );    
    // write them to memory
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    XMLWriter xml = new XMLWriter(out);
    xml.printHeader();
    xml.tagOpen("beans");
    BeanWriter<TestBean> writer = new BeanWriter<TestBean>(TestBean.class, xml, "bean");
    for( TestBean bean: beans ) {
      writer.write(bean);
    }
    xml.tagEnd("beans");
    xml.close();
    // read them from memory
    verifyRead( reflector, new ByteArrayInputStream(out.toByteArray()));
  }
  
}
