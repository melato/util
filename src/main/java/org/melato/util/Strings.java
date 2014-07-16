/*-------------------------------------------------------------------------
 * Copyright (c) 2012,2013,2014, Alex Athanasopoulos.  All Rights Reserved.
 * alex@melato.org
 *-------------------------------------------------------------------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *-------------------------------------------------------------------------
 */
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
  public static boolean isEmpty(String s) {
    return s == null || s.length() == 0;
  }
  public static boolean equal(String s1, String s2) {
    if ( s1 == s2 ) {
      return true;
    }
    if ( s1 == null ) {
      return false;
    }
    return s1.equals(s2);
  }
  
}
