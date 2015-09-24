package de.mhaug.glasgow.TeamProj.model;

public class Allocation {
	private int weekNumber;
	private MatchLevel level;
	private Area area;
	private Referee referee1;
	private Referee referee2;

	public Allocation(int weekNumber, MatchLevel level, Area area, Referee referee1, Referee referee2) {
		this.weekNumber = weekNumber;
		this.level = level;
		this.area = area;
		this.referee1 = referee1;
		this.referee2 = referee2;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public Referee getReferee1() {
		return referee1;
	}

	public Referee getReferee2() {
		return referee2;
	}

	@Override
	public String toString() {
		return "" + weekNumber + " " + level + " " + area + " " + referee1.getName() + " " + referee2.getName();
	}

	public MatchLevel getMatchLevel() {
		return level;
	}

	public Area getArea() {
		return area;
	}
}
