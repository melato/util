package org.melato.progress.test;

import org.melato.progress.ProgressGenerator;

/** Base class for progress demos.
 *  Defines the progress computation.
 */
public class ProgressDemoComputation {
	/** Run the long operation that generates progress.
	 * @throws InterruptedException
	 */
	public void runOperation() throws InterruptedException {
		ProgressGenerator progress = ProgressGenerator.get();
		progress.setText( "Doing something" );
		int n = 50;
		progress.setLimit( n );
		long time = System.currentTimeMillis();
		for( int i = 0; i < n; i++ ) {
			progress.setPosition( i );
			/*
			for( int j = 0; j < 1000000; j++ ) {
				// loop to check the performance of very frequent calls to the progress handler.
				progress.setPosition( i );
			}
			*/
			Thread.sleep( 100 );
		}
		time = System.currentTimeMillis() - time;
		System.out.println( "time: " + time + " ms" );
	}
}
