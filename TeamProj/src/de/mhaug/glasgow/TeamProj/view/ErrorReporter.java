package de.mhaug.glasgow.TeamProj.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class ErrorReporter {
	private ErrorReporter() {
	}

	public static void displayErrorMessage(String title, String message) {
		JOptionPane.showMessageDialog(new JFrame("Error"), message, title, JOptionPane.ERROR_MESSAGE);
	}
}
