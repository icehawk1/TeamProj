package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;

public class ExitListener implements WindowListener {

	private static final File refereeFile = new File("./RefereesOut.txt");

	@Override
	public void windowClosing(WindowEvent event) {
		System.out.println("Referee Editor closed");
		writeRefereeFile();
	}

	private void writeRefereeFile() {
		assert !refereeFile.exists() || refereeFile.canWrite();

		try {
			PrintWriter writer = new PrintWriter(refereeFile);
			for (Referee currentReferee : MainWindow.getInstance().getRefereeList()) {
				writer.println(currentReferee);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent event) { /* Empty */
	}

	@Override
	public void windowDeiconified(WindowEvent event) { /* Empty */
	}

	@Override
	public void windowIconified(WindowEvent event) { /* Empty */
	}

	@Override
	public void windowActivated(WindowEvent event) { /* Empty */
	}

	@Override
	public void windowDeactivated(WindowEvent event) { /* Empty */
	}

	@Override
	public void windowOpened(WindowEvent event) { /* Empty */
	}
}
