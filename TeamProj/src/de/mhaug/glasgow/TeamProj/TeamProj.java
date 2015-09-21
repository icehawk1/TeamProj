package de.mhaug.glasgow.TeamProj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import de.mhaug.glasgow.TeamProj.data.Referee;

public class TeamProj {

	private static final int maxInitialReferees = 12;

	public static void main(String[] args) {
		TeamProj main = new TeamProj();
		ArrayList<Referee> refereeList = main.readInputFile();
		main.interactWithUser(refereeList);
	}

	private ArrayList<Referee> readInputFile() {
		File inputFile = new File("./RefereesIn.txt");
		ArrayList<Referee> result = new ArrayList<>(maxInitialReferees);

		try {
			Scanner inputScanner = new Scanner(inputFile);
			while (inputScanner.hasNextLine()) {
				result.add(createRefereeFromLine(inputScanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			// TODO Print real error message
			e.printStackTrace();
		}

		return result;
	}

	private Referee createRefereeFromLine(String inputLine) {
		// The + makes sure that more that several spaces are parsed as one
		// separator
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

	}
}
