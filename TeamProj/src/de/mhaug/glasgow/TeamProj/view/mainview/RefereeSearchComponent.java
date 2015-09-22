package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.mhaug.glasgow.TeamProj.controller.SearchListener;

public class RefereeSearchComponent extends JPanel {
	public RefereeSearchComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.add(new JLabel("Forename:"));
		final JTextField forenameField = new JTextField(10);
		this.add(forenameField);

		this.add(new JLabel("Lastname:"));
		final JTextField lastnameField = new JTextField(10);
		this.add(lastnameField);

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new SearchListener(forenameField.getText(), lastnameField.getText()));
		this.add(searchButton);
	}
}
