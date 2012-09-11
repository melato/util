/* $Header: c:\\cvsroot/dev/java/aa/progress/ProgressTask.java,v 1.2 2007/12/04 03:26:19 athana Exp $
 * Copyright (c) Alex Athanasopoulos 2007
 */
package org.melato.progress;

import java.awt.Component;

import javax.swing.ProgressMonitor;

/** A Progress Task defines a task that is run in a separate thread,
 * and whose progress indication is monitored via a progress dialog.
 * @author Alex Athanasopoulos
 * @date Dec 1, 2007
 */
public class ProgressTask {
	Runnable run;
	ProgressHandler handler;
	ProgressMonitor monitor;
	
	public ProgressTask() {
	}
	public ProgressTask( Runnable run ) {
		this.run = run;
	}
	public void runTask() throws Exception {
		if ( run != null ) {
			run.run();
		}
	}
	public void taskCancelled() {
	}
	
	/** Called when a task failed by throwing an exception. */
	public void taskFailed( Throwable error ) {
		// Simply show the exception to stderr.
		error.printStackTrace();
		// For more sophisticated UI, modify to show an error dialog.
	}
	
	/** Setup the UI, start the task in a separate thread, and monitor its progress.
	 * @param component  The parent component for the progress monitor dialog.
	 */
	public void start( Component component ) {
		monitor = new ProgressMonitor( component, "", "", 0, 0 );
		handler = new ProgressMonitorHandler(monitor);
		Runnable r = new Runnable() {
			public void run() {
				ProgressGenerator.setHandler( handler );
				try {
					try {
						runTask();
					} finally {
						monitor.close();
					}
				} catch( CanceledException e ) {
					// do nothing
				} catch( Exception e ) {
					taskFailed( e );
				}
			}
		};
		new Thread(r).start();
	}
}
