/* $Header: c:\\cvsroot/dev/java/aa/progress/ProgressHandler.java,v 1.2 2007/12/04 03:26:19 athana Exp $
 * Copyright (c) Alex Athanasopoulos 2007
 */
package org.melato.progress;

/** An interface used to monitor progress of computations.
 * This is generally implemented by a UI dialog or status bar
 * that shows progress indication to the user and lets the user cancel the computation.
 * @author Alex Athanasopoulos
 * @date Dec 1, 2007
 */
public interface ProgressHandler {
	/** Set the progress, as a number.
	 * @param pos  A value >= 0 and < limit.
	 */
	void setPosition( int pos );

	/** Set the maximum value of the progress.
	 */
	void setLimit( int limit );

	/** Set a textual message representing what the operation is currently doing.
	 * @param text
	 */
	void setText( String text );

	/** Find out if the computation should be canceled.
	 *  Generally this should return the state of a flag that is set
	 *  by a cancel button.
	 * @return true if the computation should stop, otherwise false.
	 */
	boolean isCanceled();
}
