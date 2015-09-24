package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.mhaug.glasgow.TeamProj.view.barchartview.BarChartWindow;

public class BarChartListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BarChartWindow.getInstance().setVisible(true);
	}
}
