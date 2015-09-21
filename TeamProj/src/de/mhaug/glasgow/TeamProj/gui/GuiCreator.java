package de.mhaug.glasgow.TeamProj.gui;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import de.mhaug.glasgow.TeamProj.data.Referee;

public class GuiCreator {
	private ArrayList<Referee> refereeList;

	public GuiCreator(ArrayList<Referee> refereeList) {
		this.refereeList = refereeList;
		assert !refereeList.isEmpty();
	}

	public void createMainWindow() {
		JFrame mainWindow = new JFrame("Referee Manager");
		JSplitPane mainContainer = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		final DefaultListModel<Referee> refereeListModel = new DefaultListModel<>();
		JList<Referee> refereeList = new JList<>(refereeListModel);
		JScrollPane refereeListScrollPane = new JScrollPane(refereeList);

		mainWindow.add(mainContainer);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(500, 750);

		mainContainer.add(refereeListScrollPane);

		for (Referee toAdd : this.refereeList)
			refereeListModel.addElement(toAdd);

		System.out.println(refereeListModel.getSize());

		mainWindow.validate();
		mainWindow.setEnabled(true);
		mainWindow.setVisible(true);
	}
}
