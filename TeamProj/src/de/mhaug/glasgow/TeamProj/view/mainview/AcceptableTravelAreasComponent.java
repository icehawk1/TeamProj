package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.mhaug.glasgow.TeamProj.model.Area;

public class AcceptableTravelAreasComponent extends JPanel {
	public AcceptableTravelAreasComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel description = new JLabel("Travels to: ");
		this.add(description);

		for (Area elem : Area.values()) {
			this.add(new JCheckBox(elem.name(), true));
		}
	}
}
