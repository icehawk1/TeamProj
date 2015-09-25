package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.view.ErrorReporter;
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
		MainWindow.getInstance().setCreateButtonText("Add Referee");
	}

	public void addButtonPressed(RefereeEditorComponent editor) {
		Referee referee;
		try {
			referee = UtilController.getRefereeFromView();
			referee.validate(false);
			referee.setID(computeNewIDFor(referee));
			editor.setID(referee.getID());
		} catch (InvalidInputException ex) {
			ErrorReporter.displayErrorMessage("The referee information you entered were invalid", ex.getMessage());
			return;
		}
		editor.lockNameAndMatches();

		// RefereeList.update(referee);
		// UtilController.updateViewsFromModel();
		MainWindow.getInstance().getRefereeList().insertReferee(referee);

		MainWindow.getInstance().setCreateButtonText("Create Referee");
	}

	private String computeNewIDFor(Referee referee) {
		String result;
		int number = 1;
		do {
			result = "" + referee.getForename().charAt(0) + referee.getLastname().charAt(0) + "" + number;
			result = result.toUpperCase();
			System.out.println(result);

			number++;
		} while (MainWindow.getInstance().getRefereeList().hasReferee(result));

		return result;
	}
}
