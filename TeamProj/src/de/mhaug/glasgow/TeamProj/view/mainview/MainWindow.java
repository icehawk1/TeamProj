package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.BorderLayout;
import java.util.SortedSet;

import javax.swing.JFrame;

import de.mhaug.glasgow.TeamProj.controller.ExitListener;
import de.mhaug.glasgow.TeamProj.controller.UtilController;
import de.mhaug.glasgow.TeamProj.model.Referee;

public class MainWindow extends JFrame {
	private static volatile MainWindow instance;
	private RefereeListComponent listComp;

	private RefereeSearchComponent searchComp;
	private RefereeEditorComponent editorComp;

	private MainWindow() {
		super("Referee Manager");
		createMainWindow();
		this.pack();
		this.validate();
	}

	public static MainWindow getInstance() {
		if (instance == null) {
			instance = new MainWindow();
		}

		return instance;
	}

	private void createMainWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new ExitListener());

		this.setLayout(new BorderLayout());

		listComp = new RefereeListComponent();
		this.add(listComp, BorderLayout.NORTH);

		searchComp = new RefereeSearchComponent();
		this.add(searchComp, BorderLayout.CENTER);

		editorComp = new RefereeEditorComponent();
		this.add(editorComp, BorderLayout.SOUTH);
	}

	public RefereeListComponent getListComponent() {
		return listComp;
	}

	public RefereeSearchComponent getSearchComponent() {
		return searchComp;
	}

	public RefereeEditorComponent getEditorComponent() {
		return editorComp;
	}

	public void updateRefereeList(SortedSet<Referee> referees) {
		listComp.updateList(referees);
	}

	public void updateView() {
		updateRefereeList(UtilController.getAvailableReferees());
	}
}
