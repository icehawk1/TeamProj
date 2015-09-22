package de.mhaug.glasgow.TeamProj.view.mainview;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;

class RefereeListComponent extends JScrollPane {
	public RefereeListComponent() {
		super(new JList<>(new RefereeListModel()));
	}
}

class RefereeListModel extends DefaultListModel<Referee> {
	public RefereeListModel() {
		for (Referee toAdd : RefereeList.getReadOnlyList())
			this.addElement(toAdd);
	}
}