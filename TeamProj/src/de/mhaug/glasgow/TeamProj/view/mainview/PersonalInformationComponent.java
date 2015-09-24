package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.mhaug.glasgow.TeamProj.model.Referee;

class PersonalInformationComponent extends JPanel {
	private JLabel idLabel = new JLabel("id");
	private JTextField nameField = new JTextField("forename lastname");
	private JTextField allocationsField = new JTextField("0");

	public PersonalInformationComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.add(idLabel);

		this.add(new JLabel("Name:"));
		nameField.setEditable(false);
		nameField.setColumns(10);
		this.add(nameField);

		this.add(new JLabel("Number of allocated matches:"));
		allocationsField.setEditable(false);
		allocationsField.setColumns(3);
		this.add(allocationsField);
	}

	public void displayRefereeDetails(Referee ref) {
		idLabel.setText(ref.getID());
		nameField.setText(ref.getName());
		allocationsField.setText(ref.getNumberOfAllocations() + "");
	}

	public String getRefereeID() {
		return idLabel.getText();
	}

	public String getForename() {
		return nameField.getText().split(" +")[0];
	}

	public String getLastname() {
		return nameField.getText().split(" +")[1];
	}

	public int getNumAllocations() {
		return Integer.parseInt(allocationsField.getText());
	}

	public void emptyValues() {
		idLabel.setText("id");
		nameField.setText("");
		allocationsField.setText("");
	}

	public void lockNameAndMatches() {
		nameField.setEditable(false);
		allocationsField.setEditable(false);
	}

	public void unlockNameAndMatches() {
		nameField.setEditable(true);
		allocationsField.setEditable(true);
	}
}
