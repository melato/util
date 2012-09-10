package org.melato.convert.types;

import org.melato.convert.TypeParser;

public class CharParser implements TypeParser {

  @Override
  public Object parse(String s) {
    if ( s.length() == 0 )
      return (char)0;
    return s.charAt(0);
  }

}
