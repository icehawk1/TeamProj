package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import de.mhaug.glasgow.TeamProj.model.Allocation;
import de.mhaug.glasgow.TeamProj.model.Area;
import de.mhaug.glasgow.TeamProj.model.Match;
import de.mhaug.glasgow.TeamProj.model.MatchLevel;
import de.mhaug.glasgow.TeamProj.view.allocatorview.ErrorReporter;
import de.mhaug.glasgow.TeamProj.view.allocatorview.MatchAllocatorWindow;
import de.mhaug.glasgow.TeamProj.view.barchartview.BarChartWindow;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;

public class MatchAllocationListener implements ActionListener {
	private static final File allocationFile = new File("./MatchAllocs.txt");

	@Override
	public void actionPerformed(ActionEvent event) {
		MatchAllocatorWindow maw = MatchAllocatorWindow.getInstance();
		maw.setVisible(true);

		if (event.getActionCommand().contains("Search"))
			displayMatch();
		else if (event.getActionCommand().contains("Allocate")) {
			boolean matchWasAllocated = allocateMatch();
			if (matchWasAllocated)
				maw.setVisible(false);
		} else
			assert false : "The Button in the allocator window had an illegal text";
	}

	private void displayMatch() {
		MatchAllocatorWindow maw = MatchAllocatorWindow.getInstance();

		Area area = maw.getArea();
		boolean isJuniorMatch = maw.isJuniorMatch();
		maw.getSuitableRefereesComponent().displayRefereeList(
				RefereeChooser.computeRefereesByAllocationPreference(area, isJuniorMatch));

		if (maw.getNumberOfSuitableReferees() < 2)
			ErrorReporter.displayErrorMessage("Not enough suitable Referees",
					"There are only " + maw.getNumberOfSuitableReferees()
							+ " referees who could be allocated. You need at least two. Sorry.");
		else
			maw.setButtonText("Allocate Match");
	}

	private boolean allocateMatch() {
		Match match;
		try {
			match = MatchAllocatorWindow.getInstance().createMatchFromDisplay();
			match.validate();

			Allocation allocation = new Allocation(match.getWeek(), match.isJuniorMatch() ? MatchLevel.JUNIOR
					: MatchLevel.SENIOR, match.getAreaOfVenue(), match.getReferee1(), match.getReferee2());

			appendToAllocationFile(allocation);

			allocation.getReferee1().increaseNumberOfAllocations();
			allocation.getReferee2().increaseNumberOfAllocations();
			MainWindow.getInstance().updateView();
			BarChartWindow.getInstance().updateView();

			MatchAllocatorWindow.getInstance().setButtonText("Search Referees");
			return true;
		} catch (InvalidInputException ex) {
			ErrorReporter.displayErrorMessage("Invalid input", ex.getMessage());
			return false;
		} catch (NumberFormatException ex) {
			ErrorReporter.displayErrorMessage("Invalid input",
					"You have to enter a week. This has to be a number between 1 and 52.");
			return false;
		}
	}

	private void appendToAllocationFile(Allocation allocation) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(allocationFile, true)));
			out.println(allocation.getWeekNumber() + " " + allocation.getMatchLevel() + " " + allocation.getArea()
					+ " " + allocation.getReferee1().getName() + " " + allocation.getReferee2().getName());
			out.close();

			System.out.println(allocation.getWeekNumber() + " " + allocation.getMatchLevel() + " "
					+ allocation.getArea() + " " + allocation.getReferee1().getName() + " "
					+ allocation.getReferee2().getName());
		} catch (IOException e) {
			ErrorReporter.displayErrorMessage("Write Error", "Could not append to match allocation file");
		}
	}
}
