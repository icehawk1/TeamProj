package de.mhaug.glasgow.TeamProj;

import java.util.List;

import de.mhaug.glasgow.TeamProj.controller.RefereeListFactory;
import de.mhaug.glasgow.TeamProj.controller.SearchListener;
import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;

public class TeamProj {
	public static void main(String[] args) {
		RefereeListFactory rlf = new RefereeListFactory();

		List<Referee> refereeList = rlf.readInputFile();
		RefereeList.create(refereeList);

		SearchListener.displayReferee(RefereeList.getReadOnlySet().first().getID());
		MainWindow.getInstance().setVisible(true);
	}
}
