package org.melato.convert;

/**
 * An interface for matching TypeParsers to target types.
 * @author Alex Athanasopoulos
 */
public interface TypeParserFactory {
  TypeParser getParser(Class<?> type);
}
