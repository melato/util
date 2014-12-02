package org.melato.csv;

/**
 * Interface for splitting a string into pieces.
 * @author Alex Athanasopoulos
 *
 */
public interface StringSplitter {
  String[] split(String line);
}
