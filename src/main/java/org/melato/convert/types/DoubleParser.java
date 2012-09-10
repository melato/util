package org.melato.convert.types;

import org.melato.convert.TypeParser;

public class DoubleParser implements TypeParser {

  @Override
  public Object parse(String s) {
    return Double.parseDouble(s);
  }

}
