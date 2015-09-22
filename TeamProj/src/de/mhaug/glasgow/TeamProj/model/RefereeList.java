package de.mhaug.glasgow.TeamProj.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RefereeList extends ArrayList<Referee> {

	public static List<Referee> getReadOnlyList() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(new ArrayList<Referee>());
	}

	public static void create(List<Referee> refereeList) {
		// TODO Auto-generated method stub
	}

	public static void create(Referee referee) {
		// TODO Auto-generated method stub
	}

	public static void request(String id) {
		// TODO Auto-generated method stub
	}

	public static void request(String forename, String lastname) {
		// TODO Auto-generated method stub
	}

	public static void update(Referee referee) {
		// TODO Auto-generated method stub
	}

	public static void delete(String id) {
		// TODO Auto-generated method stub
	}

	public static void delete(String forename, String lastname) {
		// TODO Auto-generated method stub
	}
}
