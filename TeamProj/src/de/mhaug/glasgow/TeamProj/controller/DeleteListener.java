package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;
import de.mhaug.glasgow.TeamProj.view.allocatorview.ErrorReporter;

public class DeleteListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Referee referee;
		try {
			referee = UtilController.getRefereeFromView();
			if (!RefereeList.hasReferee(referee.getID())) {
				ErrorReporter.displayErrorMessage("Unknown ID", "There is no Referee with id " + referee.getID());
				return;
			}

			RefereeList.delete(referee.getForename(), referee.getLastname());
			UtilController.updateViewsFromModel();
		} catch (InvalidInputException ex) {
			// Can be ignored for deletion
		}
	}
}
