package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.mhaug.glasgow.TeamProj.model.Area;
import de.mhaug.glasgow.TeamProj.model.Referee;

class AcceptableTravelAreasComponent extends JPanel {
	private ArrayList<JCheckBox> areaCheckBoxes = new ArrayList<>();

	public AcceptableTravelAreasComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel description = new JLabel("Travels to: ");
		this.add(description);

		for (Area elem : Area.values()) {
			JCheckBox box = new JCheckBox(elem.name(), true);
			areaCheckBoxes.add(box);
			this.add(box);
		}
	}

	public void displayRefereeDetails(Referee ref) {
		assert ref.getAcceptableTravelAreas().length == areaCheckBoxes.size();
		for (int i = 0; i < areaCheckBoxes.size(); i++) {
			areaCheckBoxes.get(i).setSelected(ref.getAcceptableTravelAreas()[i]);
		}
	}
}
