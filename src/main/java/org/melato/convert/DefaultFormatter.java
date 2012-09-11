package org.melato.convert;


/**
 * A ParserFactory with our built-in parsers.
 * @author Alex Athanasopoulos
 */
public class DefaultFormatter implements TypeFormatter {

  @Override
  public String format(Object obj) {
    if ( obj == null )
      return "";
    return obj.toString();
  }
  
}
