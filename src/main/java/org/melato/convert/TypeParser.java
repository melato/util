package org.melato.convert;

/**
 * An interface for parsing a string into an object of a given type.
 * @author Alex Athanasopoulos
 */
public interface TypeParser {
  Object parse(String s);
}
