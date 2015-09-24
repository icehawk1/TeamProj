package de.mhaug.glasgow.TeamProj.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import de.mhaug.glasgow.TeamProj.controller.UtilController;
import de.mhaug.glasgow.TeamProj.model.Area;
import de.mhaug.glasgow.TeamProj.model.Referee;

public final class RefereeChooser {
	public static List<Referee> computeRefereesByAllocationPreference(Area area, boolean isJuniorMatch) {
		List<Referee> result = new ArrayList<>();

		result.addAll(addRefereesInSameArea(area, isJuniorMatch));
		result.addAll(addRefereesInAdjacentAreas(area, isJuniorMatch));
		result.addAll(addRefereesInNonAdjacentAreas(area, isJuniorMatch));

		return result;
	}

	private static ArrayList<Referee> addRefereesInSameArea(Area area, boolean isJuniorMatch) {
		ArrayList<Referee> result = new ArrayList<>();

		for (Referee ref : UtilController.getAvailableReferees()) {
			if (!isJuniorMatch && ref.getQualification().getLevel() <= 1)
				continue;
			else if (ref.getHomeArea() == area)
				result.add(ref);
		}

		sortList(result);

		return result;
	}

	private static ArrayList<Referee> addRefereesInAdjacentAreas(Area area, boolean isJuniorMatch) {
		ArrayList<Referee> result = new ArrayList<>();

		for (Referee ref : UtilController.getAvailableReferees()) {
			if (!isJuniorMatch && ref.getQualification().getLevel() <= 1)
				continue;
			else if (Math.abs(ref.getHomeArea().ordinal() - area.ordinal()) == 1
					&& ref.getAcceptableTravelAreas()[area.ordinal()] == true)
				result.add(ref);
		}

		sortList(result);

		return result;
	}

	private static ArrayList<Referee> addRefereesInNonAdjacentAreas(Area area, boolean isJuniorMatch) {
		ArrayList<Referee> result = new ArrayList<>();

		for (Referee ref : UtilController.getAvailableReferees()) {
			if (!isJuniorMatch && ref.getQualification().getLevel() <= 1)
				continue;
			else if (Math.abs(ref.getHomeArea().ordinal() - area.ordinal()) > 1
					&& ref.getAcceptableTravelAreas()[area.ordinal()] == true)
				result.add(ref);
		}

		sortList(result);

		return result;
	}

	private static void sortList(ArrayList<Referee> result) {
		result.sort(new Comparator<Referee>() {
			@Override
			public int compare(Referee ref1, Referee ref2) {
				if (ref1.getNumberOfAllocations() < ref2.getNumberOfAllocations())
					return -1;
				else if (ref1.getNumberOfAllocations() == ref2.getNumberOfAllocations())
					return 0;
				else
					return 1;
			}
		});
	}
}
