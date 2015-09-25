package de.mhaug.glasgow.TeamProj.controller;

/**
 * This gets thrown when there is invalid user input.
 */
public class InvalidInputException extends Exception {

	public InvalidInputException(String message) {
		super(message);
	}

}
