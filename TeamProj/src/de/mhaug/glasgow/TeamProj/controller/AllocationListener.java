package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.mhaug.glasgow.TeamProj.view.allocatorview.MatchAllocatorWindow;

public class AllocationListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		MatchAllocatorWindow maw = MatchAllocatorWindow.getInstance();
		maw.emptyValues();
		maw.setVisible(true);
	}
}
