package org.melato.rss;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.melato.convert.xml.BeanHandler;
import org.melato.xml.XMLDelegator;
import org.melato.xml.XMLMappingHandler;
import org.xml.sax.SAXException;

/** A simple RSS parser.
 *  It parses basic fields from an RSS feed.
 *  */
public class RSS {
  public static final String RSS_CHANNEL_ITEM = "rss/channel/item";
  public static List<Item> parse(InputStream input) throws IOException, SAXException {
    List<Item> items = new ArrayList<Item>();
    XMLMappingHandler root = new XMLMappingHandler();
    root.setPathHandler(RSS_CHANNEL_ITEM, new BeanHandler<Item>(Item.class, items));
    XMLDelegator.parse(root,  input);
    return items;
  }
  
  public static class Item {
    private String  title;
    private String  description;
    private String  pubDate;
    private String  guid;
    private String  link;
    public String getTitle() {
      return title;
    }
    public void setTitle(String title) {
      this.title = title;
    }
    public String getDescription() {
      return description;
    }
    public void setDescription(String description) {
      this.description = description;
    }
    public String getPubDate() {
      return pubDate;
    }
    public void setPubDate(String pubDate) {
      this.pubDate = pubDate;
    }
    public String getGuid() {
      return guid;
    }
    public void setGuid(String guid) {
      this.guid = guid;
    }
    public String getLink() {
      return link;
    }
    public void setLink(String link) {
      this.link = link;
    }
    @Override
    public String toString() {
      return "RSS.Item [title=" + title + "]";
    }
  }
  
}
