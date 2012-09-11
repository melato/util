/* $Header: c:\\cvsroot/dev/java/aa/progress/ConsoleProgressHandler.java,v 1.4 2007/12/04 03:33:29 athana Exp $
 * Copyright (c) Alex Athanasopoulos 2007
 */
package org.melato.progress;


/** A ProgressHandler that reports progress to stderr.
 * @author Alex Athanasopoulos
 * @date Dec 1, 2007
 */
public class ConsoleProgressHandler implements ProgressHandler {
	private int limit;
	private String text;
	private long lastTime;
	/** The number of milliseconds to wait between printing progress indication changes.
	 */
	public static final int UPDATE_INTERVAL = 1000;

	@Override
	public boolean isCanceled() {
		return false;
	}

	@Override
	public void setPosition(int pos) {
		long time = System.currentTimeMillis();
		if ( time - lastTime < UPDATE_INTERVAL ) {
			return;
		}
		lastTime = time;
		System.err.println( text + " " + pos + "/" + limit );
	}

	@Override
	public void setLimit(int limit) {
		this.limit = limit;
		//System.err.println( "Progress limit: " + limit );
	}

	@Override
	public void setText(String text) {
		this.text = text;
		//System.err.println( "Progress text: " + text );
	}
}
