package org.melato.util;

import java.text.Normalizer;

public class Strings {
  public static String implode(int[] objects, String glue) {
    StringBuilder buf = new StringBuilder();
    for( int i = 0; i < objects.length; i++ ) {
      if ( i > 0 )
        buf.append( glue );
      buf.append(String.valueOf(objects[i]));          
    }
    return buf.toString();
  }
  public static String implode(Object[] objects, String glue) {
    StringBuilder buf = new StringBuilder();
    for( int i = 0; i < objects.length; i++ ) {
      if ( i > 0 )
        buf.append( glue );
      buf.append(String.valueOf(objects[i]));          
    }
    return buf.toString();
  }
  public static String toUpperCaseNoAccents(String name) {
    name = name.toUpperCase();
    name = Normalizer.normalize(name, Normalizer.Form.NFD);
    int len = name.length();
    StringBuilder buf = null;
    for( int i = 0; i < len; i++ ) {
      char c = name.charAt(i);
      int type = Character.getType(c);
      if ( type == Character.NON_SPACING_MARK) {
        if ( buf == null) {
          buf = new StringBuilder();
          buf.append( name, 0, i );
        }
        continue;
      } else if ( buf != null) {
        buf.append(c);
      }
    }
    return buf == null ? name : buf.toString();    
  }
}
