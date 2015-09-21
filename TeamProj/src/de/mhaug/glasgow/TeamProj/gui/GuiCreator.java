package de.mhaug.glasgow.TeamProj.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.mhaug.glasgow.TeamProj.data.Referee;

public class GuiCreator {
	private ArrayList<Referee> refereeList;

	public GuiCreator(ArrayList<Referee> refereeList) {
		this.refereeList = refereeList;
		assert !refereeList.isEmpty();
	}

	public void createGui() {
		JFrame mainWindow = createMainWindow();
		mainWindow.setVisible(true);
	}

	private JFrame createMainWindow() {
		JFrame result = new JFrame("Referee Manager");
		result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		result.setSize(500, 750);

		result.setLayout(new BorderLayout());

		JComponent refereeListComponent = createListComponent();
		result.add(refereeListComponent, BorderLayout.NORTH);

		JComponent refereeEditorComponent = createEditorComponent();
		result.add(refereeEditorComponent, BorderLayout.SOUTH);

		return result;
	}

	private JComponent createListComponent() {
		final DefaultListModel<Referee> refereeListModel = new DefaultListModel<>();
		JList<Referee> refereeList = new JList<>(refereeListModel);
		JScrollPane result = new JScrollPane(refereeList);

		for (Referee toAdd : this.refereeList)
			refereeListModel.addElement(toAdd);

		return result;
	}

	private JComponent createEditorComponent() {
		return new JPanel();
	}
}
