package de.mhaug.glasgow.TeamProj.view.mainview;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.mhaug.glasgow.TeamProj.controller.DeleteListener;
import de.mhaug.glasgow.TeamProj.controller.UpdateListener;

public class ActionComponent extends JPanel {
	public ActionComponent() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		final JButton updateButton = new JButton("Update Referee");
		updateButton.addActionListener(new UpdateListener());
		this.add(updateButton);

		final JButton deleteButton = new JButton("Delete Referee");
		deleteButton.addActionListener(new DeleteListener());
		this.add(deleteButton);
	}
}
