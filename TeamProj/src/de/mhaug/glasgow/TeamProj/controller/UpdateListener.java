package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.SortedSet;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;
import de.mhaug.glasgow.TeamProj.view.barchartview.BarChartWindow;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;
import de.mhaug.glasgow.TeamProj.view.mainview.RefereeEditorComponent;

public class UpdateListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		Referee referee = getRefereeFromView();
		// There was no referee selected
		if (referee.getID().equalsIgnoreCase("id"))
			return;

		RefereeList.update(referee);
		updateViewsFromModel();
	}

	private Referee getRefereeFromView() {
		RefereeEditorComponent refEditor = MainWindow.getInstance().getEditorComponent();
		Referee result = refEditor.buildReferee();
		return result;
	}

	/**
	 * This will update all the views which display Data from RefereeList.
	 * Please note that this method does not change the RefereeList, it just
	 * causes views, that have outdated data to use the current one.
	 */
	public static void updateViewsFromModel() {
		SortedSet<Referee> referees = RefereeList.getReadOnlySet();

		BarChartWindow.getInstance().updateDataset(referees);
		MainWindow.getInstance().updateRefereeList(referees);
	}
}
