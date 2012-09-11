package org.melato.progress.test;

import org.melato.progress.ConsoleProgressHandler;
import org.melato.progress.ProgressGenerator;


/** Create a demo of progress indication that uses no UI other than the console.
 */
public class ProgressConsoleDemo {
	public static void main(String[] args) throws Exception {
		ProgressGenerator.setHandler( new ConsoleProgressHandler() );
		new ProgressDemoComputation().runOperation();
	}

}
