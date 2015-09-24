package de.mhaug.glasgow.TeamProj.model;

import de.mhaug.glasgow.TeamProj.controller.InvalidInputException;

public class Match {
	private int week;
	private Area areaOfVenue;
	private boolean juniorMatch;
	private Referee referee1;
	private Referee referee2;

	public Match() {
	}

	public Match(int week, Area areaOfVenue, boolean juniorMatch, Referee referee1, Referee referee2) {
		this.week = week;
		this.areaOfVenue = areaOfVenue;
		this.juniorMatch = juniorMatch;
		this.referee1 = referee1;
		this.referee2 = referee2;
	}

	public int getWeek() {
		return week;
	}

	public Area getAreaOfVenue() {
		return areaOfVenue;
	}

	public boolean isJuniorMatch() {
		return juniorMatch;
	}

	public Referee getReferee1() {
		return this.referee1;
	}

	public Referee getReferee2() {
		return this.referee2;
	}

	public void validate() throws InvalidInputException {
		if (week < 1 || week > 52)
			throw new InvalidInputException("The week has to be a number between 1 and 52.");
		if (referee1 == null || referee2 == null)
			throw new InvalidInputException("Please select exactly two referees.");
	}
}
