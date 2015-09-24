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

	public ActionComponent getActionComponent() {
		return actionComponent;
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

	/**
	 * Set the values of all fields to an 'empty' value, so it becomes apparent
	 * to the user that he should enter new data. This method is used when
	 * creating a new referee.
	 */
	public void emptyValues() {
		personalInformationComponent.emptyValues();
		qualNAreaComponent.emptyValues();
		acceptableTravelAreasComponent.emptyValues();
	}

	/**
	 * Locks the field for the referee's name and for the number of matches he
	 * has been allocated, so that the user CAN NOT enter values.
	 */
	public void unlockNameAndMatches() {
		personalInformationComponent.unlockNameAndMatches();
	}

	/**
	 * Unlocks the field for the referee's name and for the number of matches he
	 * has been allocated, so that the user CAN enter values.
	 */
	public void lockNameAndMatches() {
		personalInformationComponent.lockNameAndMatches();
	}
}
