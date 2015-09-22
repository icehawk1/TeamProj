package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchListener implements ActionListener {
	private String forename;
	private String lastname;

	public SearchListener(String forename, String lastname) {
		this.forename = forename;
		this.lastname = lastname;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Search button pressed: " + forename + " " + lastname);
	}
}
