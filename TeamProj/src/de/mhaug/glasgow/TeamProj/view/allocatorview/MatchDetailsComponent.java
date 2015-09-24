package de.mhaug.glasgow.TeamProj.view.allocatorview;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.mhaug.glasgow.TeamProj.model.Area;

class MatchDetailsComponent extends JPanel {
	private JTextField weekField = new JTextField(15);
	private JComboBox<Area> areaBox = new JComboBox<Area>(Area.values());
	private JCheckBox levelBox = new JCheckBox();

	public MatchDetailsComponent() {
		this.setLayout(new GridLayout(4, 2));

		this.add(new JLabel("Week the match is held in:"));
		this.add(weekField);

		this.add(new JLabel("Area the match is held in:"));
		this.add(areaBox);

		this.add(new JLabel("Level of the match:"));
		this.add(levelBox);
	}

	public int getWeek() {
		return Integer.parseInt(weekField.getText());
	}

	public Area getArea() {
		return areaBox.getItemAt(areaBox.getSelectedIndex());
	}

	public boolean isJuniorMatch() {
		return levelBox.isSelected();
	}

	public void emptyValues() {
		weekField.setText("");
		areaBox.setSelectedIndex(0);
		levelBox.setSelected(false);
	}
}
