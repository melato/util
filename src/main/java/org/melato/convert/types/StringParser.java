package org.melato.convert.types;

import org.melato.convert.TypeParser;

public class StringParser implements TypeParser {

  @Override
  public Object parse(String s) {
    return s;
  }

}
