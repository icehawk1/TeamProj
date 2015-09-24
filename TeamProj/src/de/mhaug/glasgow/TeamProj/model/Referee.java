package de.mhaug.glasgow.TeamProj.model;

import org.apache.commons.lang3.BooleanUtils;

import de.mhaug.glasgow.TeamProj.controller.InvalidInputException;

public class Referee implements Comparable<Referee> {

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

	public Referee(String id, String forename, String lastname, Qualification qualification, int numAllocations,
			Area homeArea, boolean[] acceptableTravelAreas) {
		this.id = id;
		this.forename = forename;
		this.lastname = lastname;
		this.qualification = qualification;
		this.numAllocations = numAllocations;
		this.homeArea = homeArea;
		this.acceptableTravelAreas = acceptableTravelAreas;
	}

	public void validate() throws InvalidInputException {
		validate(true);
	}

	public void validate(boolean validateId) throws InvalidInputException {
		boolean result = true;
		String message = "Your input is incorrect:\n";
		String forename_up = forename.toUpperCase();
		String lastname_up = lastname.toUpperCase();

		if (forename == null || forename.isEmpty()) {
			message += "forename can not be empty\n";
			result = false;
		}

		if (lastname == null || lastname.isEmpty()) {
			message += "lastname can not be empty\n";
			result = false;
		}

		if (validateId && (id.charAt(0) != forename_up.charAt(0) || id.charAt(1) != lastname_up.charAt(0))) {
			message += "Invalid id: " + id + "\n";
			result = false;
		}

		if (forename.contains(" ")) {
			message += "forename contains spaces\n";
			result = false;
		}

		if (lastname.contains(" ")) {
			message += "lastname contains spaces\n";
			result = false;
		}

		if (numAllocations < 0) {
			message += "The number of allocations must be greator or equal to zero\n";
			result = false;
		}

		if ((acceptableTravelAreas[homeArea.ordinal()]) == false) {
			message += "A Referee must be willing to travel within his home area\n";
			result = false;
		}

		if (result == false)
			throw new InvalidInputException(message);
	}

	private boolean[] createAcceptableTravelAreas(String areaStr) {
		final int numAreas = Area.values().length;
		assert areaStr.length() == numAreas;

		boolean[] result = new boolean[numAreas];
		for (int i = 0; i < numAreas; i++) {
			result[i] = BooleanUtils.toBoolean("" + areaStr.charAt(i));
		}
		return result;
	}

	public String getID() {
		assert this.id != null;
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

	public int getNumberOfAllocations() {
		assert numAllocations >= 0;
		return numAllocations;
	}

	@Override
	public int compareTo(Referee other) {
		return this.getID().compareToIgnoreCase(other.getID());
	}

	public String getLastname() {
		assert lastname != null;
		return lastname;
	}

	public String getForename() {
		assert forename != null;
		return forename;
	}

	public boolean[] getAcceptableTravelAreas() {
		return acceptableTravelAreas;
	}

	public Qualification getQualification() {
		assert qualification != null;
		return qualification;
	}

	public Area getHomeArea() {
		assert homeArea != null;
		return homeArea;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void increaseNumberOfAllocations() {
		numAllocations++;
	}
}
