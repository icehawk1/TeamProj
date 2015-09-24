package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;
import de.mhaug.glasgow.TeamProj.view.allocatorview.ErrorReporter;

public class UpdateListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			Referee referee = UtilController.getRefereeFromView();
			// There was no referee selected
			if (referee.getID().equalsIgnoreCase("id"))
				return;

			RefereeList.update(referee);
			UtilController.updateViewsFromModel();
		} catch (InvalidInputException ex) {
			ErrorReporter.displayErrorMessage("The referee information you entered were invalid", ex.getMessage());
		}
	}
}
