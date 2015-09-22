package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class PersonalInformationComponent extends JPanel {
	public PersonalInformationComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.add(new JLabel("id"));

		this.add(new JLabel("Name:"));
		JTextField nameField = new JTextField("forename lastname");
		nameField.setEditable(false);
		this.add(nameField);

		this.add(new JLabel("Number of allocated matches:"));
		JTextField allocationsField = new JTextField("forename lastname");
		allocationsField.setEditable(false);
		this.add(allocationsField);
	}
}
