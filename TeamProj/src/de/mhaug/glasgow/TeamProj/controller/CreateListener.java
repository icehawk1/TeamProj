package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;
import de.mhaug.glasgow.TeamProj.view.allocatorview.ErrorReporter;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;
import de.mhaug.glasgow.TeamProj.view.mainview.RefereeEditorComponent;

public class CreateListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		RefereeEditorComponent editor = MainWindow.getInstance().getEditorComponent();
		if (event.getActionCommand().contains("Create"))
			createButtonPressed(editor);
		else if (event.getActionCommand().contains("Add"))
			addButtonPressed(editor);
		else
			assert false : "The 'Add/Create Referee'-Button had an illegal text";
	}

	public void createButtonPressed(RefereeEditorComponent editor) {
		editor.emptyValues();
		editor.unlockNameAndMatches();
		editor.getActionComponent().getCreateButton().setText("Add Referee");
	}

	public void addButtonPressed(RefereeEditorComponent editor) {
		Referee referee;
		try {
			referee = UtilController.getRefereeFromView();
		} catch (InvalidInputException ex) {
			ErrorReporter.displayErrorMessage("The referee information you entered were invalid", ex.getMessage());
			return;
		}

		editor.lockNameAndMatches();
		referee.setID(computeNewIDFor(referee));

		RefereeList.update(referee);
		UtilController.updateViewsFromModel();
	}

	private String computeNewIDFor(Referee referee) {
		String result;
		int number = 1;
		do {
			result = referee.getForename().charAt(0) + referee.getLastname().charAt(0) + "" + number;
			System.out.println(result);
		} while (RefereeList.hasReferee(result));

		return result;
	}
}
