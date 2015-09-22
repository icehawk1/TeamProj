package de.mhaug.glasgow.TeamProj.view.allocatorview;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;

class SuitableRefereesComponent extends JScrollPane {
	public SuitableRefereesComponent() {
		super(new JList<>(new RefereeListModel()));
	}
}

class RefereeListModel extends DefaultListModel<Referee> {
	public RefereeListModel() {
		for (Referee ref : RefereeList.getReadOnlyList())
			if (isSuitable(ref))
				this.addElement(ref);
	}

	private boolean isSuitable(Referee ref) {
		// TODO Auto-generated method stub
		return true;
	}
}