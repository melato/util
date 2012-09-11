package org.melato.progress.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.melato.progress.ProgressTask;


/** Create a demo frame that lets the user start a long process
 *  and monitor its progress.
 */
public class ProgressUIDemo implements Runnable {
	/** Setup the UI */
	public void run() {
		final JFrame frame = new JFrame( "Progress Demo" );
		JPanel buttons = new JPanel( new FlowLayout(FlowLayout.LEFT) );
		JButton startButton = new JButton( "Start" );
		buttons.add( startButton );
		JPanel panel = new JPanel( new BorderLayout() );
		panel.add( buttons, BorderLayout.SOUTH );
		frame.setContentPane( panel );
		startButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event ) {
				ProgressTask task = new ProgressTask() {
					public void runTask() throws Exception {
						new ProgressDemoComputation().runOperation();
					}
				};
				task.start( frame );
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater( new ProgressUIDemo() );
	}

}
