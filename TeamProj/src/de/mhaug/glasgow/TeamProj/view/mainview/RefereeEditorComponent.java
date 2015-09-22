package de.mhaug.glasgow.TeamProj.view.mainview;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

class RefereeEditorComponent extends JPanel {
	public RefereeEditorComponent() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(new JSeparator(SwingConstants.HORIZONTAL));

		this.add(new PersonalInformationComponent());
		this.add(new QualNAreaComponent());
		this.add(new AcceptableTravelAreasComponent());
		this.add(new ActionComponent());
	}
}
