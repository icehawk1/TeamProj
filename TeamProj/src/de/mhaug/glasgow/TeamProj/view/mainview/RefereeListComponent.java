package de.mhaug.glasgow.TeamProj.view.mainview;

import java.util.Iterator;
import java.util.SortedSet;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import de.mhaug.glasgow.TeamProj.controller.UtilController;
import de.mhaug.glasgow.TeamProj.model.Referee;

public class RefereeListComponent extends JScrollPane implements Iterable<Referee> {
	private final static JList<Referee> internallist = new JList<>(RefereeListModel.getInstance());

	public RefereeListComponent() {
		super(internallist);
		internallist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Disable the selection of items (user and programm)
		// internallist.setSelectionModel(new DefaultListSelectionModel() {
		// @Override
		// public void setSelectionInterval(int index0, int index1) {
		// super.setSelectionInterval(-1, -1);
		// }
		// });
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

		void updateDataSet(SortedSet<Referee> referees) {
			this.clear();
			for (Referee toAdd : referees)
				this.addElement(toAdd);
			fireContentsChanged(this, 0, referees.size());
		}

		static RefereeListModel getInstance() {
			if (instance == null) {
				instance = new RefereeListModel();
			}

			return instance;
		}
	}

	public void selectReferee(Referee ref) {
		internallist.setSelectedValue(ref, true);
	}

	public void insertReferee(Referee referee) {
		RefereeListModel.getInstance().addElement(referee);
	}

	public boolean hasReferee(String id) {
		for (Referee ref : this) {
			if (ref.getID().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}

	public void delete(String id) {
		RefereeListModel model = RefereeListModel.getInstance();
		for (int i = 0; i < model.getSize(); i++) {
			if (model.get(i).getID().equalsIgnoreCase(id)) {
				model.remove(i);
				break;
			}
		}
	}

	@Override
	public Iterator<Referee> iterator() {
		return new RefereeListIterator(internallist.getModel());
	}

	public Referee getSelectedReferee() {
		return internallist.getSelectedValue();
	}

	public void selectReferee(String forename, String lastname) {
		RefereeListModel model = RefereeListModel.getInstance();
		for (int i = 0; i < model.getSize(); i++) {
			if (model.get(i).getForename().equalsIgnoreCase(forename)
					&& model.get(i).getLastname().equalsIgnoreCase(lastname)) {
				internallist.setSelectedIndex(i);
				internallist.ensureIndexIsVisible(i);
				break;
			}
		}
	}

	public void updateReferee() {
		// TODO Auto-generated method stub

	}
}
