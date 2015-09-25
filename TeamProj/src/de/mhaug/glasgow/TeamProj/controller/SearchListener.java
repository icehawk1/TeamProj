package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.view.ErrorReporter;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;

public class SearchListener implements ActionListener {
	private String forename;
	private String lastname;

	@Override
	public void actionPerformed(ActionEvent e) {
		Referee ref;
		try {
			forename = MainWindow.getInstance().getSearchForename();
			lastname = MainWindow.getInstance().getSearchLastname();
			MainWindow.getInstance().getRefereeList().selectReferee(forename, lastname);
			ref = MainWindow.getInstance().getRefereeList().getSelectedReferee();
		} catch (NoSuchElementException ex) {
			ErrorReporter.displayErrorMessage("Referee not found", ex.getMessage());
			return;
		}

		MainWindow.getInstance().displayRefereeDetails(ref);
	}
}
