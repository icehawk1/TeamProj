package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import de.mhaug.glasgow.TeamProj.controller.WindowClosingListener;
import de.mhaug.glasgow.TeamProj.model.RefereeList;

public class MainWindow extends JFrame {
	public MainWindow() {
		super("Referee Manager");
		createMainWindow();
		makeMainWindowVisible();
	}

	private void createMainWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowClosingListener(RefereeList.getReadOnlyList()));

		this.setLayout(new BorderLayout());

		RefereeListComponent listComp = new RefereeListComponent();
		this.add(listComp, BorderLayout.NORTH);

		RefereeSearchComponent searchComp = new RefereeSearchComponent();
		this.add(searchComp, BorderLayout.CENTER);

		RefereeEditorComponent editorComp = new RefereeEditorComponent();
		this.add(editorComp, BorderLayout.SOUTH);
	}

	private void makeMainWindowVisible() {
		this.pack();
		this.validate();
		this.setVisible(true);
	}
}
