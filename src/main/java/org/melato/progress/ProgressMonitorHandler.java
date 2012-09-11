/* $Header: c:\\cvsroot/dev/java/aa/progress/ProgressMonitorHandler.java,v 1.2 2007/12/04 03:26:19 athana Exp $
 * Copyright (c) Alex Athanasopoulos 2007
 */
package org.melato.progress;

import javax.swing.ProgressMonitor;

/** A ProgressHandler that uses a swing ProgressMonitor
 * @author Alex Athanasopoulos
 * @date Dec 1, 2007
 */
class ProgressMonitorHandler implements ProgressHandler {
	private ProgressMonitor monitor;
	private long lastTime;

	public ProgressMonitorHandler(ProgressMonitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public boolean isCanceled() {
		return monitor.isCanceled();
	}

	@Override
	public void setLimit(int limit) {
		monitor.setMaximum(limit);
	}

	@Override
	public void setPosition(int pos) {		
		// Don't update the UI if it has been updated in the last 10 milliseconds.
		// This makes a slight performance improvement (about 5%).  
		// ProgressMonitor may be doing something similar.
		long time = System.currentTimeMillis();
		if ( time - lastTime < 10 ) {
			return;
		}
		lastTime = time;
		
		monitor.setProgress(pos);
	}

	@Override
	public void setText(String text) {
		monitor.setNote(text);
	}
}
