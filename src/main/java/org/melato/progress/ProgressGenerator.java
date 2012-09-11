/* $Header: c:\\cvsroot/dev/java/aa/progress/ProgressGenerator.java,v 1.2 2007/12/04 03:26:19 athana Exp $
 * Copyright (c) Alex Athanasopoulos 2007
 */
package org.melato.progress;

/** An object that is used by any computational code to show progress
 *  and respond to cancellation requests.
 *  A ProgressGenerator is a decoupled wrapper for a ProgressHandler.
 *  Each thread has its own ProgressGenerator and ProgressHandler.
 */
public final class ProgressGenerator {
	private ProgressHandler handler;
	private boolean canceled;

	/** Contains the progress generator for the current thread.
	 *  In case one needs to change the progress generator of another thread,
	 *  this can be replaced with a WeakHashMap<Thread,ProgressGenerator>.
	 */
	private static ThreadLocal<ProgressGenerator> threadHandler = new ThreadLocal<ProgressGenerator> (); 
	
	/** Get the progress generator for the current thread.
	 * @return A ProgressGenerator that can be used by the current thread.
	 * It is never null.
	 */
	public static ProgressGenerator get() {
		ProgressGenerator p = threadHandler.get();
		if ( p == null ) {
			p = new ProgressGenerator( new NullProgressHandler() );
			threadHandler.set( p );
		}
		return p;
	}
	
	/**
	 * Set the progress handler and progress generator of the current thread. 
	 * @param handler The progress handler.  Called by the progress generator.
	 */
	public static void setHandler(ProgressHandler handler) {
		if ( handler == null )
			handler = new NullProgressHandler();
		threadHandler.set( new ProgressGenerator( handler ));
		
	}
	
	ProgressGenerator( ProgressHandler handler ) {
		this.handler = handler;
	}
	
	public boolean isCanceled() {
		if ( ! canceled ) {
			canceled = handler.isCanceled();
		}
		return canceled;		
	}
	
	public void checkCancelled() throws CanceledException {
		if ( isCanceled() )
			throw new CanceledException();
	}
	public void setPosition( int pos ) throws CanceledException {
		checkCancelled();
		handler.setPosition( pos );
	}
	public void setLimit( int limit ) throws CanceledException {
		checkCancelled();
		handler.setLimit( limit );
	}
	public void setText( String text ) throws CanceledException {
		checkCancelled();
		handler.setText( text );
	}

  @Override
  public String toString() {
    String name = handler != null ? handler.getClass().getName() : "null";
    return "ProgressGenerator handler: " + name;
  }
	
}
