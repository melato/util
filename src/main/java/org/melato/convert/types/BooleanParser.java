package org.melato.convert.types;

import org.melato.convert.TypeParser;

public class BooleanParser implements TypeParser {

  @Override
  public Object parse(String s) {
    return Boolean.parseBoolean(s);
  }

}
