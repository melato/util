package org.melato.convert;



public class FormatManager extends TypeManager<TypeFormatter> {
  public static final TypeFormatter DEFAULT_FORMATTER = new DefaultFormatter();
  @Override
  protected TypeFormatter getDefault(Class<?> type) {
    return DEFAULT_FORMATTER;
  }
  
}
