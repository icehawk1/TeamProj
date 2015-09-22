package de.mhaug.glasgow.TeamProj.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.mhaug.glasgow.TeamProj.data.Referee;

public class MatchAllocatorCreator {
	public static void main(String[] args) {
		MatchAllocatorCreator mac = new MatchAllocatorCreator();
		JFrame mainWindow = mac.createMatchAllocatorWindow(new ArrayList<Referee>());
		mainWindow.pack();
		mainWindow.validate();
		mainWindow.setVisible(true);
	}

	public JFrame createMatchAllocatorWindow(final List<Referee> refereeList) {
		JFrame frame = new JFrame("Match Allocator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JComponent suitableRefereesComponent = createSuitableRefereesComponent();
		frame.add(suitableRefereesComponent, BorderLayout.NORTH);

		JComponent matchDetailsComponent = createMatchDetailsComponent();
		frame.add(matchDetailsComponent, BorderLayout.CENTER);

		frame.add(new JButton("Allocate Referees"), BorderLayout.SOUTH);

		return frame;
	}

	private JComponent createMatchDetailsComponent() {
		JPanel result = new JPanel();
		result.setLayout(new GridLayout(4, 2));

		result.add(new JLabel("Week the match is held in:"));
		result.add(new JTextField(15));

		result.add(new JLabel("Area the match is held in:"));
		result.add(new JTextField(15));

		result.add(new JLabel("Level of the match:"));
		result.add(new JTextField(15));

		return result;
	}

	private JComponent createSuitableRefereesComponent() {
		final DefaultListModel<Referee> refereeListModel = new DefaultListModel<>();
		JList<Referee> refereeList = new JList<>(refereeListModel);
		JScrollPane result = new JScrollPane(refereeList);

		return result;
	}
}
