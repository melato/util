package org.melato.util;

import java.io.File;

public class Filenames {
	public static String getExtension( File file ) {
		String name = file.getName();
		int dot = name.indexOf( '.' );
		return dot >= 0 ? name.substring( dot + 1 ) : null;
	}
  public static String getBasename( String name ) {
    int dot = name.indexOf( '.' );
    return dot >= 0 ? name.substring( 0, dot ) : name;
  }
	public static String getBasename( File file ) {
	  return getBasename(file.getName());
	}
	public static File replaceExtension( File file, String newExtension ) {
		String name = getBasename( file ) + "." + newExtension;
		return new File( file.getParentFile(), name );
	}

}
