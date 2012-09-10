package org.melato.convert;

import java.util.HashMap;
import java.util.Map;


public class ParserManager implements TypeParserFactory {
  private Map<String,TypeParser> parsersForName = new HashMap<String,TypeParser>();
  private Map<Class<?>,TypeParser> parsersForType = new HashMap<Class<?>,TypeParser>();
  private TypeParserFactory factory = new DefaultParserFactory();
  
  /** Specify the parser to use for a field of a given type. */
  public void setParser(Class<?> type, TypeParser parser) {
    parsersForType.put(type,  parser);    
  }

  /** Specify the parser to use for a specific field. */
  public void setParser(String fieldName, TypeParser parser) {
    parsersForName.put(fieldName,  parser);    
  }
    
  @Override
  public TypeParser getParser(Class<?> type) {
    TypeParser parser = parsersForType.get(type);
    if ( parser != null || parsersForType.containsKey(type))
      return parser;
    parser = factory.getParser(type);
    return parser;    
  }

  public TypeParser getParser(String name, Class<?> type ) {
    TypeParser parser = parsersForName.get(name);
    if ( parser != null || parsersForType.containsKey(name))
      return parser;
    return getParser(type);
  }
}
