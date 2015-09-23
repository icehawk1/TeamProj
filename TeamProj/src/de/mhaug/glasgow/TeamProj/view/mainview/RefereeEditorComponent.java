package de.mhaug.glasgow.TeamProj.view.mainview;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import de.mhaug.glasgow.TeamProj.model.Referee;

public class RefereeEditorComponent extends JPanel {
	private PersonalInformationComponent personalInformationComponent = new PersonalInformationComponent();
	private QualNAreaComponent qualNAreaComponent = new QualNAreaComponent();
	private AcceptableTravelAreasComponent acceptableTravelAreasComponent = new AcceptableTravelAreasComponent();
	private ActionComponent actionComponent = new ActionComponent();

	public RefereeEditorComponent() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(new JSeparator(SwingConstants.HORIZONTAL));

		this.add(personalInformationComponent);
		this.add(qualNAreaComponent);
		this.add(acceptableTravelAreasComponent);
		this.add(actionComponent);
	}

	public void displayRefereeDetails(Referee ref) {
		personalInformationComponent.displayRefereeDetails(ref);
		qualNAreaComponent.displayRefereeDetails(ref);
		acceptableTravelAreasComponent.displayRefereeDetails(ref);
	}

	public String getRefereeID() {
		return personalInformationComponent.getRefereeID();
	}

	public Referee buildReferee() {
		Referee result = new Referee(personalInformationComponent.getRefereeID(),
				personalInformationComponent.getForename(), personalInformationComponent.getLastname(),
				qualNAreaComponent.getQualification(), personalInformationComponent.getNumAllocations(),
				qualNAreaComponent.getHomeArea(), acceptableTravelAreasComponent.getBoolValues());
		return result;
	}
}
