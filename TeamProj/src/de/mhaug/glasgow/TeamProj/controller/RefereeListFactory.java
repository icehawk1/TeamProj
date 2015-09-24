package de.mhaug.glasgow.TeamProj.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.view.allocatorview.ErrorReporter;

public class RefereeListFactory {
	private static final int maxInitialReferees = 12;

	public List<Referee> readInputFile() {
		return readInputFile(new File("./RefereesIn.txt"));
	}

	public List<Referee> readInputFile(File inputFile) {
		if (!inputFile.canRead())
			ErrorReporter.displayErrorMessage("Read error", "Could not read file " + inputFile);

		ArrayList<Referee> result = new ArrayList<>(maxInitialReferees);

		Scanner inputScanner;
		try {
			inputScanner = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			ErrorReporter.displayErrorMessage("Input file not found", "The file " + inputFile.getAbsolutePath()
					+ " could not be found");
			e.printStackTrace();
			return new ArrayList<Referee>();
		}

		while (inputScanner.hasNextLine()) {
			String line = inputScanner.nextLine();
			// Skip empty lines
			if (line.matches("\\s*"))
				continue;
			result.add(createRefereeFromLine(line));
		}

		inputScanner.close();
		return result;
	}

	private Referee createRefereeFromLine(String inputLine) {
		// The + causes several spaces to be parsed as one separator
		// e.g. "Dave  Gray" is parsed to {"Dave", "Gray"}
		String[] splittedLine = inputLine.split("[ \t]+");
		assert splittedLine.length == 7 : "line of length " + splittedLine.length;

		for (int i = 0; i < splittedLine.length; i++) {
			splittedLine[i] = splittedLine[i].trim();
		}

		Referee result = new Referee(splittedLine);
		return result;
	}

}
