package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.view.ErrorReporter;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;

public class DeleteListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Referee referee;
		try {
			referee = UtilController.getRefereeFromView();
			if (!MainWindow.getInstance().getRefereeList().hasReferee(referee.getID())) {
				ErrorReporter.displayErrorMessage("Unknown ID", "There is no Referee with id " + referee.getID());
				return;
			}

			MainWindow.getInstance().getRefereeList().delete(referee.getID());
			UtilController.updateViewsFromModel();
		} catch (InvalidInputException ex) {
			// Can be ignored for deletion
		}
	}
}
