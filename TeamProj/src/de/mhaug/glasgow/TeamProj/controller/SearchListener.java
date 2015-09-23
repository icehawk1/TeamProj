package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;
import de.mhaug.glasgow.TeamProj.view.mainview.MainWindow;
import de.mhaug.glasgow.TeamProj.view.mainview.RefereeEditorComponent;

public class SearchListener implements ActionListener {
	private JTextField forenameField;
	private JTextField lastnameField;

	public SearchListener(JTextField forenameField, JTextField lastnameField) {
		this.forenameField = forenameField;
		this.lastnameField = lastnameField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String forename = forenameField.getText();
		String lastname = lastnameField.getText();
		System.out.println("Search button pressed: " + forename + " " + lastname);

		Referee ref;
		try {
			ref = RefereeList.request(forename, lastname);
		} catch (NoSuchElementException ex) {
			JOptionPane.showMessageDialog(new JFrame("Error"), ex.getMessage(), "Referee not found",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		RefereeEditorComponent editor = MainWindow.getInstance().getEditorComponent();
		editor.displayRefereeDetails(ref);
	}
}
