package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.mhaug.glasgow.TeamProj.controller.SearchListener;

class RefereeSearchComponent extends JPanel {
	private final JTextField forenameField = new JTextField(10);
	private final JTextField lastnameField = new JTextField(10);

	public RefereeSearchComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.add(new JLabel("Forename:"));
		this.add(forenameField);

		this.add(new JLabel("Lastname:"));
		this.add(lastnameField);

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new SearchListener());
		this.add(searchButton);
	}

	public String getForename() {
		return forenameField.getText().trim();
	}

	public String getLastname() {
		return lastnameField.getText().trim();
	}
}
