package de.mhaug.glasgow.TeamProj.view.allocatorview;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import de.mhaug.glasgow.TeamProj.model.Referee;

public class SuitableRefereesComponent extends JScrollPane {
	private final static JList<Referee> internallist = new JList<>(SuitableRefereesModel.getInstance());

	public SuitableRefereesComponent() {
		super(internallist);
	}

	public void emptyValues() {
		SuitableRefereesModel.getInstance().clear();
	}

	public void displayRefereeList(List<Referee> reflist) {
		SuitableRefereesModel.getInstance().displayList(reflist);
		if (reflist.size() >= 2)
			internallist.setSelectedIndices(new int[] { 0, 1 });
	}

	private static class SuitableRefereesModel extends DefaultListModel<Referee> {
		private static volatile SuitableRefereesModel instance;

		private SuitableRefereesModel() {
		}

		public void displayList(List<Referee> reflist) {
			this.removeAllElements();
			for (Referee item : reflist)
				this.addElement(item);
			fireContentsChanged(this, 0, reflist.size());
		}

		public static synchronized SuitableRefereesModel getInstance() {
			if (instance == null) {
				instance = new SuitableRefereesModel();
			}

			return instance;
		}
	}

	public int getNumberOfDisplayedReferees() {
		return internallist.getModel().getSize();
	}

	public List<Referee> getSelectedReferees() {
		List<Referee> result = internallist.getSelectedValuesList();
		// System.out.println(result);
		return result;
	}
}
