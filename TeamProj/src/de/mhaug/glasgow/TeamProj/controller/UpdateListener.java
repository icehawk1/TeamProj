package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.view.ErrorReporter;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;

public class UpdateListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			Referee referee = MainWindow.getInstance().getRefereeList().getSelectedReferee();
			// There was no referee selected
			if (referee.getID().equalsIgnoreCase("id"))
				return;
			referee.validate();

			MainWindow.getInstance().getRefereeList().getSelectedReferee();
			MainWindow.getInstance().updateReferee(referee);
			UtilController.updateViewsFromModel();
		} catch (InvalidInputException ex) {
			ErrorReporter.displayErrorMessage("The referee information you entered were invalid", ex.getMessage());
		}
	}
}
