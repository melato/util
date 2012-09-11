/* $Header: c:\\cvsroot/dev/java/aa/progress/NullProgressHandler.java,v 1.2 2007/12/04 03:26:19 athana Exp $
 * Copyright (c) Alex Athanasopoulos 2007
 */
package org.melato.progress;

/** A progress handler that does nothing.
 *  Used as the default progress handler. */
public class NullProgressHandler implements ProgressHandler {

	@Override
	public boolean isCanceled() {
		return false;
	}

	@Override
	public void setLimit(int limit) {
	}

	@Override
	public void setPosition(int pos) {
	}

	@Override
	public void setText(String text) {
	}
}
