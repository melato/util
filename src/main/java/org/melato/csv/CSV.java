package org.melato.csv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** A CSV parser/joiner.  May not cover all cases.  Needs review and unit tests. */
public class CSV implements StringSplitter {
	public static final char QUOTE = '"'; 
	public static final char OPENOFFICE_QUOTE = (char) 8221; 
	public static String[] parse( String line ) {
		char delimiter = ',';
		List<String> fields = new ArrayList<String>();
		int n = line.length();
		boolean inQuote = false;
		StringBuilder buf = new StringBuilder();
		for( int i = 0; i < n; i++ ) {
			char c = line.charAt( i );
			if ( c == delimiter && ! inQuote ) {
				fields.add( buf.toString() );
				buf.setLength(0);
			} else if ( c == QUOTE ) {
			  if ( ! inQuote && buf.length() > 0 ) {
			    buf.append(QUOTE);			    
              }
			  inQuote = ! inQuote;
			} else if ( c == OPENOFFICE_QUOTE && inQuote ){
				buf.append( QUOTE );
			} else {
				buf.append( c );
			}
		}
		fields.add( buf.toString() );
		return fields.toArray( new String[0] );
	}
  @Override
  public String[] split(String line) {
    return parse(line);
  }
  
  private static void quote(StringBuilder buf, char delimiter, String field) {
    buf.append( QUOTE );
    int n = field.length();
    for( int i = 0; i < n; i++ ) {
      char c = field.charAt( i );
      if ( c == QUOTE ) {
        // quote it
        buf.append(QUOTE);
      }
      buf.append(c);
    }
    buf.append(QUOTE);
  }
  public static String join(char delimiter, Iterable<String> fields) {
    StringBuilder buf = new StringBuilder();
    boolean first = true;
    for(String field: fields ) {
      if ( ! first ) {
        buf.append( delimiter );
      }
      first = false;
      if ( field != null ) {
        if ( field.indexOf(delimiter) >= 0 || field.indexOf(QUOTE) >= 0 ) {
          quote(buf, delimiter, field);
        } else {
          buf.append(field);
        }
      }
    }
    return buf.toString();
  }
  public static String join(Iterable<String> fields) {
    return join( ',', fields);
  }
  public static String join(String[] fields) {
    return join( ',', fields);
  }
  public static String join(char delimiter, String[] fields) {
    return join(',', Arrays.asList(fields));
  }

}
