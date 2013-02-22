package org.melato.util;

import java.io.File;
import java.io.IOException;

/** Interface for processing files.  Used by FileTask. */
public interface FileProcessor {
	void processFile( File file ) throws IOException; 

}
