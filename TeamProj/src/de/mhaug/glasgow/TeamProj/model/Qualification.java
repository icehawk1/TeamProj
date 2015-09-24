package de.mhaug.glasgow.TeamProj.model;

import java.util.ArrayList;
import java.util.List;

public class Qualification {
	private League league;
	private int level;

	private static final int minLevel = 1;
	private static final int maxLevel = 4;

	public Qualification(String leagueStr, int level) {
		this(League.valueOf(leagueStr), level);
	}

	public Qualification(League league, int level) {
		this.league = league;
		this.level = level;
	}

	public static Qualification[] getPossibleQualifications() {
		List<Qualification> result = new ArrayList<>(League.values().length * (maxLevel - minLevel + 1));

		for (League currentLeague : League.values()) {
			for (int currentLevel = minLevel; currentLevel < maxLevel; currentLevel++) {
				result.add(new Qualification(currentLeague, currentLevel));
			}
		}

		return result.toArray(new Qualification[] {});
	}

	@Override
	public String toString() {
		return league + "" + level;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Qualification))
			return false;
		else {
			Qualification qual = (Qualification) obj;
			return this.league == qual.league && this.level == qual.level;
		}
	}

	public int getLevel() {
		return level;
	}
}

enum League {
	NJB, IJB
}