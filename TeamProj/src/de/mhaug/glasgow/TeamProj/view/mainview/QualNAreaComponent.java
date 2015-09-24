package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.mhaug.glasgow.TeamProj.model.Area;
import de.mhaug.glasgow.TeamProj.model.Qualification;
import de.mhaug.glasgow.TeamProj.model.Referee;

class QualNAreaComponent extends JPanel {
	private JComboBox<Qualification> qualBox = new JComboBox<>(Qualification.getPossibleQualifications());
	private JComboBox<Area> homeAreaBox = new JComboBox<>(Area.values());

	public QualNAreaComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.add(new JLabel("Qualification: "));
		this.add(qualBox);

		this.add(new JLabel("Home Area: "));
		this.add(homeAreaBox);
	}

	public void displayRefereeDetails(Referee ref) {
		for (int i = 0; i < qualBox.getItemCount(); i++) {
			if (qualBox.getItemAt(i).equals(ref.getQualification())) {
				qualBox.setSelectedIndex(i);
				break;
			}
		}

		for (int i = 0; i < homeAreaBox.getItemCount(); i++) {
			if (homeAreaBox.getItemAt(i) == ref.getHomeArea()) {
				homeAreaBox.setSelectedIndex(i);
				break;
			}
		}
	}

	public Qualification getQualification() {
		return qualBox.getItemAt(qualBox.getSelectedIndex());
	}

	public Area getHomeArea() {
		return homeAreaBox.getItemAt(homeAreaBox.getSelectedIndex());
	}

	public void emptyValues() {
		qualBox.setSelectedIndex(0);
		homeAreaBox.setSelectedIndex(0);
	}
}
