package de.mhaug.glasgow.TeamProj.data;

import org.apache.commons.lang3.BooleanUtils;

public class Referee {

	private String id;
	private String forename;
	private String lastname;
	private Qualification qualification;
	private int numAllocations;
	private Area homeArea;
	private boolean[] acceptableTravelAreas;

	public Referee(String[] refereeDetails) {
		assert refereeDetails.length == 7;

		this.id = refereeDetails[0];
		assert this.id.length() == 3;

		this.forename = refereeDetails[1];
		assert !this.forename.isEmpty();
		this.lastname = refereeDetails[2];
		assert !this.lastname.isEmpty();

		String rawQual = refereeDetails[3];
		this.qualification = new Qualification(rawQual.substring(0, rawQual.length() - 1), Integer.parseInt(""
				+ rawQual.charAt(rawQual.length() - 1)));

		this.numAllocations = Integer.parseInt(refereeDetails[4]);
		assert this.numAllocations >= 0;

		this.homeArea = Area.valueOf(refereeDetails[5].toUpperCase());

		this.acceptableTravelAreas = createAcceptableTravelAreas(refereeDetails[6]);
		// Spec says: All Referees are willing to travel within their home area
		assert this.acceptableTravelAreas[this.homeArea.ordinal()] == true;
	}

	private boolean[] createAcceptableTravelAreas(String areaStr) {
		final int numAreas = Area.values().length;
		assert areaStr.length() == numAreas;

		boolean[] result = new boolean[numAreas];
		for (int i = 0; i < numAreas; i++) {
			result[i] = BooleanUtils.toBoolean(areaStr.charAt(i));
		}
		return result;
	}

	public String getID() {
		return this.id;
	}

	@Override
	public String toString() {
		String result = id + " " + getName() + " " + qualification + " " + numAllocations + " " + homeArea + " ";
		for (boolean elem : acceptableTravelAreas)
			result += (elem ? "Y" : "N");
		return result;
	}

	public String getName() {
		return forename + " " + lastname;
	}

	public Number getNumberOfAllocations() {
		return numAllocations;
	}
}
