package org.melato.convert;

import org.melato.convert.types.BooleanParser;
import org.melato.convert.types.ByteParser;
import org.melato.convert.types.CharParser;
import org.melato.convert.types.DoubleParser;
import org.melato.convert.types.FloatParser;
import org.melato.convert.types.IntParser;
import org.melato.convert.types.LongParser;
import org.melato.convert.types.ShortParser;
import org.melato.convert.types.StringParser;

/**
 * A ParserFactory with our built-in parsers.
 * @author Alex Athanasopoulos
 */
public class DefaultParserFactory implements TypeParserFactory {
  @Override
  public TypeParser getParser(Class<?> type) {
    if ( String.class.equals(type)) {
      return new StringParser();
    }
    if ( int.class.equals(type) || Integer.class.equals(type)) {
      return new IntParser();
    }
    if ( float.class.equals(type) || Float.class.equals(type)) {
      return new FloatParser();
    }
    if ( boolean.class.equals(type) || Boolean.class.equals(type)) {
      return new BooleanParser();
    }
    if ( long.class.equals(type) || Long.class.equals(type)) {
      return new LongParser();
    }
    if ( double.class.equals(type) || Double.class.equals(type)) {
      return new DoubleParser();
    }
    if ( char.class.equals(type) || Character.class.equals(type)) {
      return new CharParser();
    }
    if ( short.class.equals(type) || Short.class.equals(type)) {
      return new ShortParser();
    }
    if ( byte.class.equals(type) || Byte.class.equals(type)) {
      return new ByteParser();
    }
    throw new IllegalArgumentException( "Unsupported data type: " + type.getName());
  }
}
