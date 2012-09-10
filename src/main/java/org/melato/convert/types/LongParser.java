package org.melato.convert.types;

import org.melato.convert.TypeParser;

public class LongParser implements TypeParser {

  @Override
  public Object parse(String s) {
    return Long.parseLong(s);
  }

}
