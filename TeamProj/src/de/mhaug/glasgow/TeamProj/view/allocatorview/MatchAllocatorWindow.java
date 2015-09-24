package de.mhaug.glasgow.TeamProj.view.allocatorview;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import de.mhaug.glasgow.TeamProj.controller.InvalidInputException;
import de.mhaug.glasgow.TeamProj.controller.MatchAllocationListener;
import de.mhaug.glasgow.TeamProj.model.Area;
import de.mhaug.glasgow.TeamProj.model.Match;
import de.mhaug.glasgow.TeamProj.model.Referee;

public class MatchAllocatorWindow extends JFrame {
	private static volatile MatchAllocatorWindow instance;

	private SuitableRefereesComponent refComp = new SuitableRefereesComponent();
	private MatchDetailsComponent matchComp = new MatchDetailsComponent();
	private JButton allocateButton = new JButton("Search Referees");

	public static synchronized MatchAllocatorWindow getInstance() {
		if (instance == null) {
			instance = new MatchAllocatorWindow();
		}

		return instance;
	}

	public MatchAllocatorWindow() {
		super("Match Allocator");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.add(refComp, BorderLayout.NORTH);

		this.add(matchComp, BorderLayout.CENTER);

		allocateButton.addActionListener(new MatchAllocationListener());
		this.add(allocateButton, BorderLayout.SOUTH);

		this.pack();
		this.validate();
	}

	public void emptyValues() {
		refComp.emptyValues();
		matchComp.emptyValues();
	}

	public Match createMatchFromDisplay() throws InvalidInputException {
		List<Referee> selectedReferees = refComp.getSelectedReferees();
		if (selectedReferees.size() != 2)
			throw new InvalidInputException("You have to select exactly two Referees.");
		return new Match(matchComp.getWeek(), matchComp.getArea(), matchComp.isJuniorMatch(), selectedReferees.get(0),
				selectedReferees.get(1));
	}

	public int getWeek() {
		return matchComp.getWeek();
	}

	public Area getArea() {
		return matchComp.getArea();
	}

	public boolean isJuniorMatch() {
		return matchComp.isJuniorMatch();
	}

	public int getNumberOfSuitableReferees() {
		return refComp.getNumberOfDisplayedReferees();
	}

	public void setButtonText(String text) {
		allocateButton.setText(text);
	}

	public SuitableRefereesComponent getSuitableRefereesComponent() {
		return refComp;
	}
}
