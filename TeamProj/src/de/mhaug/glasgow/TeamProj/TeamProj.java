package de.mhaug.glasgow.TeamProj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import de.mhaug.glasgow.TeamProj.data.Referee;
import de.mhaug.glasgow.TeamProj.gui.GuiCreator;

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

		// main.writeOutputFiles(main.createAllocationList(), refereeList);
	}

	private ArrayList<Referee> readInputFile() throws FileNotFoundException {
		assert inputFile.canRead();

		ArrayList<Referee> result = new ArrayList<>(maxInitialReferees);

		Scanner inputScanner = new Scanner(inputFile);
		while (inputScanner.hasNextLine()) {
			String line = inputScanner.nextLine();
			// Skip empty lines
			if (line.matches("\\s*"))
				continue;
			result.add(createRefereeFromLine(line));
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
		GuiCreator creator = new GuiCreator(refereeList);
		creator.createGui();
	}
}
