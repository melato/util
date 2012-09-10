package org.melato.convert.types;

import org.melato.convert.TypeParser;

public class ShortParser implements TypeParser {

  @Override
  public Object parse(String s) {
    return Short.parseShort(s);
  }

}
