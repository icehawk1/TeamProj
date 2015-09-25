package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.view.ErrorReporter;

class PersonalInformationComponent extends JPanel {
	private JLabel idLabel = new JLabel("id");
	private JTextField forenameField = new JTextField("forename");
	private JTextField lastnameField = new JTextField("lastname");
	private JTextField allocationsField = new JTextField("0");

	public PersonalInformationComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.add(idLabel);

		this.add(new JLabel("Name:"));
		forenameField.setEditable(false);
		forenameField.setColumns(7);
		this.add(forenameField);
		lastnameField.setEditable(false);
		lastnameField.setColumns(7);
		this.add(lastnameField);

		this.add(new JLabel("Number of allocated matches:"));
		allocationsField.setEditable(false);
		allocationsField.setColumns(3);
		this.add(allocationsField);
	}

	public void displayRefereeDetails(Referee ref) {
		idLabel.setText(ref.getID());
		forenameField.setText(ref.getForename());
		lastnameField.setText(ref.getLastname());
		allocationsField.setText(ref.getNumberOfAllocations() + "");
	}

	public String getRefereeID() {
		return idLabel.getText();
	}

	public String getForename() {
		return forenameField.getText();
	}

	public String getLastname() {
		return lastnameField.getText();
	}

	public int getNumAllocations() {
		try {
			return Integer.parseInt(allocationsField.getText());
		} catch (NumberFormatException ex) {
			ErrorReporter.displayErrorMessage("Invalid Input", "Please enter a valid number between 0 and 4 billion.");
			return 0;
		}
	}

	public void emptyValues() {
		idLabel.setText("id");
		forenameField.setText("");
		lastnameField.setText("");
		allocationsField.setText("");
	}

	public void lockNameAndMatches() {
		forenameField.setEditable(false);
		lastnameField.setEditable(false);
		allocationsField.setEditable(false);
	}

	public void unlockNameAndMatches() {
		forenameField.setEditable(true);
		lastnameField.setEditable(true);
		allocationsField.setEditable(true);
	}

	public void setID(String id) {
		idLabel.setText(id);
	}
}
