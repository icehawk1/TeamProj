package de.mhaug.glasgow.TeamProj.data;

public class Qualification {
	private League league;
	private int level;

	public Qualification(String leagueStr, int level) {
		this.league = League.valueOf(leagueStr);
		this.level = level;
	}
}

enum League {
	NJB, IJB
}