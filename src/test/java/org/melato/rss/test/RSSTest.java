package org.melato.rss.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.melato.convert.xml.BeanHandler;
import org.melato.rss.RSS;
import org.melato.rss.RSS.Item;
import org.xml.sax.SAXException;

public class RSSTest {
  public @Test void testParse() throws IOException, SAXException {
    List<Item> items = RSS.parse(getClass().getResourceAsStream("rss.xml"));
    Assert.assertEquals(2, items.size());
    Item item = items.get(0);
    Assert.assertEquals( "title1", item.getTitle());
    item = items.get(1);
    Assert.assertEquals( "title2", item.getTitle());    
  }
  public @Test void beanParserTest() throws IOException, SAXException {
    List<Item> items = new ArrayList<Item>();
    BeanHandler<Item> handler = new BeanHandler<Item>(Item.class, items);
    handler.parse(RSS.RSS_CHANNEL_ITEM, getClass().getResourceAsStream("rss.txt"));    
    Assert.assertEquals(2, items.size());
  }

}
