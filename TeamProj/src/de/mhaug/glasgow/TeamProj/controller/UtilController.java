package de.mhaug.glasgow.TeamProj.controller;

import java.util.SortedSet;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;

/**
 * This class was created to delegate Requests from a View to the Model and vice
 * versa. It helps to avoid Dependencies between Model and View.
 */
public final class UtilController {
	private UtilController() {
	}

	/**
	 * Delegates to {@link RefereeList#getReadOnlySet()}
	 */
	public static SortedSet<Referee> getAvailableReferees() {
		return RefereeList.getReadOnlySet();
	}
}
