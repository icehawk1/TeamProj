package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.mhaug.glasgow.TeamProj.controller.AllocationListener;
import de.mhaug.glasgow.TeamProj.controller.BarChartListener;
import de.mhaug.glasgow.TeamProj.controller.CreateListener;
import de.mhaug.glasgow.TeamProj.controller.DeleteListener;
import de.mhaug.glasgow.TeamProj.controller.UpdateListener;

class ActionComponent extends JPanel {
	private final JButton barchartButton = new JButton("Show Barchart");
	private final JButton allocateButton = new JButton("Allocate Match");
	private final JButton createButton = new JButton("Create Referee");
	private final JButton updateButton = new JButton("Update Referee");
	private final JButton deleteButton = new JButton("Delete Referee");

	public ActionComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		barchartButton.addActionListener(new BarChartListener());
		this.add(barchartButton);

		allocateButton.addActionListener(new AllocationListener());
		this.add(allocateButton);

		createButton.addActionListener(new CreateListener());
		this.add(createButton);

		updateButton.addActionListener(new UpdateListener());
		this.add(updateButton);

		deleteButton.addActionListener(new DeleteListener());
		this.add(deleteButton);
	}

	public JButton getCreateButton() {
		return createButton;
	}
}
