package org.melato.convert.types;

import org.melato.convert.TypeParser;

public class IntParser implements TypeParser {

  @Override
  public Object parse(String s) {
    return Integer.parseInt(s);
  }

}
