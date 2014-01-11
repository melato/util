package org.melato.client;

public class Bookmark {
  protected int type;
  protected String name;
  protected Object object;
  public Bookmark(int type, String name, Object object) {
    super();
    this.type = type;
    this.name = name;
    this.object = object;
  }
  public int getType() {
    return type;
  }
  public String getName() {
    return name;
  }
  public Object getObject() {
    return object;
  }
  public <T> T getObject(Class<T> cls) {
    return Serialization.cast(getObject(), cls);
  }
  @Override
  public String toString() {
    return getName();
  }
  
}
