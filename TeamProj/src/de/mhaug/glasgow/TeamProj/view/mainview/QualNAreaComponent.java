package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.mhaug.glasgow.TeamProj.model.Area;
import de.mhaug.glasgow.TeamProj.model.Qualification;

public class QualNAreaComponent extends JPanel {
	public QualNAreaComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.add(new JLabel("Qualification: "));
		JComboBox<Qualification> qualification = new JComboBox<>(Qualification.getPossibleQualifications());
		this.add(qualification);

		this.add(new JLabel("Home Area: "));
		JComboBox<Area> homeArea = new JComboBox<>(Area.values());
		this.add(homeArea);
	}
}
