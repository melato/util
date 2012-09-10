package org.melato.convert.types;

import org.melato.convert.TypeParser;

/**
 * A TypeParser that parses a byte from a hex string.
 * @author Alex Athanasopoulos
 *
 */
public class ByteParser implements TypeParser {

  @Override
  public Object parse(String s) {
    return Byte.parseByte(s, 16);
  }
}
