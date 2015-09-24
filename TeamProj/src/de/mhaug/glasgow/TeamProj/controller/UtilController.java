package de.mhaug.glasgow.TeamProj.controller;

import java.util.SortedSet;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;
import de.mhaug.glasgow.TeamProj.view.barchartview.BarChartWindow;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;
import de.mhaug.glasgow.TeamProj.view.mainview.RefereeEditorComponent;

/**
 * This class was created to delegate Requests from a View to the Model and vice
 * versa. It helps to avoid Dependencies between Model and View.
 */
public final class UtilController {
	private UtilController() {
	}

	/**
	 * Delegates to {@link RefereeList#getReadOnlyView()}
	 */
	public static SortedSet<Referee> getAvailableReferees() {
		return RefereeList.getReadOnlyView();
	}

	/**
	 * This will update all the views which display Data from RefereeList.
	 * Please note that this method does not change the RefereeList, it just
	 * causes views, that have outdated data to use the current one.
	 */
	public static void updateViewsFromModel() {
		SortedSet<Referee> referees = RefereeList.getReadOnlyView();

		BarChartWindow.getInstance().updateDataset(referees);
		MainWindow.getInstance().updateRefereeList(referees);
	}

	/**
	 * Builds a referee from the values currently in the editor component. The
	 * returned referee is not necessarily in the list of available referees.
	 * 
	 * @throws InvalidInputException
	 *             If editor contains invalid values
	 */
	public static Referee getRefereeFromView() throws InvalidInputException {
		RefereeEditorComponent refEditor = MainWindow.getInstance().getEditorComponent();
		Referee result = refEditor.buildReferee();

		Referee.validate(result);
		return result;
	}
}
