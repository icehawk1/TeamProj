package de.mhaug.glasgow.TeamProj;

import java.io.File;
import java.util.List;

import de.mhaug.glasgow.TeamProj.controller.RefereeListFactory;
import de.mhaug.glasgow.TeamProj.controller.SearchListener;
import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;

public class TeamProj {
	public static void main(String[] args) {
		RefereeListFactory rlf = new RefereeListFactory();

		List<Referee> refereeList;
		if (args.length > 0)
			refereeList = rlf.readInputFile(new File(args[0]));
		else
			refereeList = rlf.readInputFile();
		RefereeList.create(refereeList);

		SearchListener.displayReferee(RefereeList.getReadOnlyView().first().getID());
		MainWindow.getInstance().setVisible(true);
	}
}
