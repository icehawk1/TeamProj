package de.mhaug.glasgow.TeamProj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import de.mhaug.glasgow.TeamProj.data.Referee;

public class TeamProj {

	private static final int maxInitialReferees = 12;
	private static final File inputFile = new File("./RefereesIn.txt");

	public static void main(String[] args) {
		TeamProj main = new TeamProj();
		ArrayList<Referee> refereeList = null;

		try {
			refereeList = main.readInputFile();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame("Error"), "The file " + inputFile.getAbsolutePath()
					+ " could not be found", "Input file not found", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return;
		}

		main.interactWithUser(refereeList);
	}

	private ArrayList<Referee> readInputFile() throws FileNotFoundException {
		assert inputFile.canRead();

		ArrayList<Referee> result = new ArrayList<>(maxInitialReferees);

		Scanner inputScanner = new Scanner(inputFile);
		while (inputScanner.hasNextLine()) {
			result.add(createRefereeFromLine(inputScanner.nextLine()));
		}

		return result;
	}

	private Referee createRefereeFromLine(String inputLine) {
		// The + causes several spaces to be parsed as one separator
		// e.g. "Dave  Gray" is parsed to {"Dave", "Gray"}
		String[] splittedLine = inputLine.split(" +");
		assert splittedLine.length == 7 : "line of length " + splittedLine.length;

		for (int i = 0; i < splittedLine.length; i++) {
			splittedLine[i] = splittedLine[i].trim();
		}

		Referee result = new Referee(splittedLine);
		return result;
	}

	private void interactWithUser(ArrayList<Referee> refereeList) {
		JFrame mainWindow = new JFrame("Referee Manager");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(500, 750);
		mainWindow.add(new JLabel(String.format("%tT", new Date())));
		mainWindow.setVisible(true);
	}
}
