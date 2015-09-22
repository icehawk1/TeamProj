package de.mhaug.glasgow.TeamProj;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import de.mhaug.glasgow.TeamProj.data.Allocation;
import de.mhaug.glasgow.TeamProj.data.Referee;

public class WindowClosingListener implements WindowListener {

	private ArrayList<Referee> refereeList;
	private static final File refereeFile = new File("./RefereesOut.txt");
	private static final File allocationFile = new File("./MatchAllocs.txt");

	public WindowClosingListener(ArrayList<Referee> refereeList) {
		this.refereeList = refereeList;
	}

	@Override
	public void windowClosing(WindowEvent event) {
		System.out.println("Referee Editor closed");
		writeAllocationFile(createAllocationList());
		writeRefereeFile(refereeList);
	}

	private List<Allocation> createAllocationList() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	private void writeAllocationFile(List<Allocation> allocationList) {

	}

	private void writeRefereeFile(List<Referee> refereeList) {
		assert !refereeFile.exists() || refereeFile.canWrite();

		// Sort by ID
		refereeList.sort(new Comparator<Referee>() {
			@Override
			public int compare(Referee ref1, Referee ref2) {
				return ref1.getID().compareTo(ref2.getID());
			}
		});

		try {
			PrintWriter writer = new PrintWriter(refereeFile);
			for (Referee currentReferee : refereeList) {
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
