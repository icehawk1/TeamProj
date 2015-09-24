package de.mhaug.glasgow.TeamProj.view.mainview;

import java.util.SortedSet;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import de.mhaug.glasgow.TeamProj.controller.UtilController;
import de.mhaug.glasgow.TeamProj.model.Referee;

class RefereeListComponent extends JScrollPane {
	private final static JList internallist = new JList<>(RefereeListModel.getInstance());

	public RefereeListComponent() {
		super(internallist);
	}

	public void updateList(SortedSet<Referee> referees) {
		RefereeListModel.getInstance().updateDataSet(referees);
	}

	/**
	 * This class just wraps the list of available referees into a format that
	 * {@link JScrollPane} can use. It is a Singleton because there is only one
	 * list of referees.
	 */
	private static class RefereeListModel extends DefaultListModel<Referee> {
		private static volatile RefereeListModel instance;

		private RefereeListModel() {
			updateDataSet(UtilController.getAvailableReferees());
		}

		public void updateDataSet(SortedSet<Referee> referees) {
			this.clear();
			for (Referee toAdd : referees)
				this.addElement(toAdd);
			fireContentsChanged(this, 0, referees.size());
		}

		public static RefereeListModel getInstance() {
			if (instance == null) {
				instance = new RefereeListModel();
			}

			return instance;
		}
	}
}
