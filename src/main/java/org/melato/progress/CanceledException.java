/* $Header: c:\\cvsroot/dev/java/aa/progress/CanceledException.java,v 1.2 2007/12/04 03:26:18 athana Exp $
 * Copyright (c) Alex Athanasopoulos 2007
 */
package org.melato.progress;

/**
 * Exception thrown by the progress indication framework when an operation is canceled.
 * @author Alex Athanasopoulos
 * @date Dec 1, 2007
 */
public class CanceledException extends RuntimeException {
  // The american spelling is canceled.  The british spelling is cancelled.
	static private final long serialVersionUID = 1L;
}
