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
  public Object getObject(Class<?> cls) {
    Object obj = getObject();
    if ( obj == null ) {
      return null;
    }
    if ( cls.isAssignableFrom(obj.getClass())) {
      return obj;
    }
    return null;
  }
  @Override
  public String toString() {
    return getName();
  }
  
}
