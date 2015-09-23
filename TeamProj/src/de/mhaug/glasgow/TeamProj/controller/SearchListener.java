package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import javax.swing.JTextField;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;
import de.mhaug.glasgow.TeamProj.view.allocatorview.ErrorReporter;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;
import de.mhaug.glasgow.TeamProj.view.mainview.RefereeEditorComponent;

public class SearchListener implements ActionListener {
	private JTextField forenameField;
	private JTextField lastnameField;

	public SearchListener(JTextField forenameField, JTextField lastnameField) {
		this.forenameField = forenameField;
		this.lastnameField = lastnameField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String forename = forenameField.getText();
		String lastname = lastnameField.getText();

		displayReferee(forename, lastname);
	}

	public void displayReferee(String forename, String lastname) {
		Referee ref;
		try {
			ref = RefereeList.request(forename, lastname);
		} catch (NoSuchElementException ex) {
			ErrorReporter.displayErrorMessage("Referee not found", ex.getMessage());
			return;
		}

		displayReferee(ref);
	}

	public void displayReferee(String id) {
		Referee ref;
		try {
			ref = RefereeList.request(id);
		} catch (NoSuchElementException ex) {
			ErrorReporter.displayErrorMessage("Referee not found", ex.getMessage());
			return;
		}

		displayReferee(ref);
	}

	private void displayReferee(Referee ref) {
		RefereeEditorComponent editor = MainWindow.getInstance().getEditorComponent();
		editor.displayRefereeDetails(ref);
	}
}
