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
			RefereeList.delete(referee.getForename(), referee.getLastname());
			UtilController.updateViewsFromModel();
		} catch (InvalidInputException ex) {
			ex.printStackTrace();
			ErrorReporter.displayErrorMessage("The referee information you entered were invalid", ex.getMessage());
		}
	}
}
