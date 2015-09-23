package de.mhaug.glasgow.TeamProj.model;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class holds the referees that are available to be allocated to matches.
 */
public final class RefereeList {
	private static SortedSet<Referee> referees = new TreeSet<>();

	// Don't initialize me
	private RefereeList() {
	}

	/**
	 * Returns a set view of the available referees. This is read-only to
	 * prevent tampering with the set outside of the CRUD-Methods.
	 */
	public static SortedSet<Referee> getReadOnlySet() {
		return Collections.unmodifiableSortedSet(referees);
	}

	/**
	 * Will make every Referee in the given List available for match allocation.
	 * This method will skip any Referees that are already available. It will
	 * not update the details of any preexisting referee.
	 */
	public static void create(List<Referee> refereeList) {
		referees.addAll(refereeList);
	}

	/**
	 * Will make the given referee available for match allocation. This method
	 * will skip the Referees if he is already available. It will not update his
	 * details.
	 */
	public static void create(Referee referee) {
		referees.add(referee);
	}

	/**
	 * Returns the referee with the given ID.
	 * 
	 * @throws NoSuchElementException
	 *             If there is no referee with that ID
	 */
	public static Referee request(String id) {
		for (Referee ref : referees)
			if (ref.getID().equalsIgnoreCase(id))
				return ref;
		throw new NoSuchElementException("There is no Referee with ID " + id);
	}

	/**
	 * Returns the referee with the given name.
	 * 
	 * @throws NoSuchElementException
	 *             If there is no referee with that name
	 */
	public static Referee request(String forename, String lastname) {
		assert forename != null;
		assert lastname != null;

		for (Referee ref : referees)
			if (ref.getForename().equalsIgnoreCase(forename) && ref.getLastname().equalsIgnoreCase(lastname))
				return ref;
		throw new NoSuchElementException("There is no Referee named " + forename + " " + lastname);
	}

	/**
	 * Updates the details of the referee. If the referee was not present before
	 * it will create it.
	 */
	public static void update(Referee referee) {
		referees.remove(referee);
		referees.add(referee);
	}

	/**
	 * Deletes the Referee with the given ID. If he isn't present it does
	 * nothing.
	 */
	public static void delete(String id) {
		for (Referee ref : referees)
			if (ref.getID().equalsIgnoreCase(id))
				referees.remove(ref);
	}

	/**
	 * Deletes the Referee with the given name. If he isn't present it does
	 * nothing.
	 */
	public static void delete(String forename, String lastname) {
		assert forename != null;
		assert lastname != null;

		for (Referee ref : referees)
			if (ref.getForename().equalsIgnoreCase(forename) && ref.getLastname().equalsIgnoreCase(lastname))
				referees.remove(ref);
	}
}
