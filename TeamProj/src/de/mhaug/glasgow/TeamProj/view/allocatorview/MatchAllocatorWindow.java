package de.mhaug.glasgow.TeamProj.view.allocatorview;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MatchAllocatorWindow extends JFrame {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MatchAllocatorWindow mac = new MatchAllocatorWindow();
		JFrame mainWindow = new MatchAllocatorWindow();
	}

	public MatchAllocatorWindow() {
		super("Match Allocator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		SuitableRefereesComponent refComp = new SuitableRefereesComponent();
		this.add(refComp, BorderLayout.NORTH);

		MatchDetailsComponent matchComp = new MatchDetailsComponent();
		this.add(matchComp, BorderLayout.CENTER);

		this.add(new JButton("Allocate Referees"), BorderLayout.SOUTH);

		this.pack();
		this.validate();
		this.setVisible(true);
	}
}
