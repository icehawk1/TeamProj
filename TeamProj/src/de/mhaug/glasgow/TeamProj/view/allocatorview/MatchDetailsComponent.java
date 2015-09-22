package de.mhaug.glasgow.TeamProj.view.allocatorview;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MatchDetailsComponent extends JPanel {
	public MatchDetailsComponent() {
		this.setLayout(new GridLayout(4, 2));

		this.add(new JLabel("Week the match is held in:"));
		this.add(new JTextField(15));

		this.add(new JLabel("Area the match is held in:"));
		this.add(new JTextField(15));

		this.add(new JLabel("Level of the match:"));
		this.add(new JTextField(15));
	}
}
