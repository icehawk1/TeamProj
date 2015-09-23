package de.mhaug.glasgow.TeamProj.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import de.mhaug.glasgow.TeamProj.model.Allocation;
import de.mhaug.glasgow.TeamProj.model.Referee;

public class ExitListener implements WindowListener {

	private SortedSet<Referee> refereeList;
	private static final File refereeFile = new File("./RefereesOut.txt");
	private static final File allocationFile = new File("./MatchAllocs.txt");

	public ExitListener(SortedSet<Referee> set) {
		this.refereeList = set;
	}

	@Override
	public void windowClosing(WindowEvent event) {
		System.out.println("Referee Editor closed: " + event);
		writeAllocationFile(createAllocationList());
		writeRefereeFile(refereeList);
	}

	private List<Allocation> createAllocationList() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	private void writeAllocationFile(List<Allocation> allocationList) {
		assert !allocationFile.exists() || allocationFile.canWrite();

		// Sort by ID
		allocationList.sort(new Comparator<Allocation>() {
			@Override
			public int compare(Allocation alloc1, Allocation alloc2) {
				if (alloc1.getWeekNumber() < alloc2.getWeekNumber()) {
					return -1;
				} else if (alloc1.getWeekNumber() == alloc2.getWeekNumber()) {
					return 0;
				} else
					return 1;
			}
		});

		try {
			PrintWriter writer = new PrintWriter(allocationFile);
			writer.println("# Matches played this season");
			writer.println("# Format of this file: WeekNumber Area Referees");
			writer.println("# ---------------------------------------------------------");

			for (Allocation currentAllocation : allocationList) {
				writer.println(currentAllocation);
			}

			writer.close();
			System.out.println("alloc file written");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void writeRefereeFile(Set<Referee> refereeList2) {
		assert !refereeFile.exists() || refereeFile.canWrite();

		try {
			PrintWriter writer = new PrintWriter(refereeFile);
			for (Referee currentReferee : refereeList2) {
				writer.println(currentReferee);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent event) { /* Empty */
	}

	@Override
	public void windowDeiconified(WindowEvent event) { /* Empty */
	}

	@Override
	public void windowIconified(WindowEvent event) { /* Empty */
	}

	@Override
	public void windowActivated(WindowEvent event) { /* Empty */
	}

	@Override
	public void windowDeactivated(WindowEvent event) { /* Empty */
	}

	@Override
	public void windowOpened(WindowEvent event) { /* Empty */
	}
}
