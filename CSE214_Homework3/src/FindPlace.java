/**
 * This class represents the “F: Find a place” command for the Maps app.
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class FindPlace extends Maps implements Command {
	private String destination;

	/**
	 * Constructs this FindPlace instance accordingly using the Scanner.
	 * @param scanner
	 * Uses scanner to take a String for the "location" to create FindPlace
	 */
	public FindPlace(Scanner scanner) {
		System.out.print("Please enter a location: ");
		destination = scanner.nextLine().toString();
	}

	public String getDestination() {
		return destination;
	}

	/**
	 * Returns whether or not pushing this FindPlace command will be valid for the given stack.
	 * @return
	 * True if can insert FindPlace into the CommandStack
	 */
	public boolean validCommand(CommandStack stack) {
		// Returns whether or not pushing this FindPlace command will be valid for the
		// given stack.
		return true;
	}

	/**
	 * Returns the String representation of this Command in long form (for current screen display)
	 * @return
	 * A String that describes FindPlace 
	 */
	public String toString() { // current String display
		return "Current Screen: Showing results for " + destination;
	}

	/**
	 * Returns the String representation of this Command in short form (for stack display)
	 * @return
	 * A String that describes FindPlace in a shorter way 
	 */
	public String toShortString() { // stack display
		return "F:" + destination;
	}
}
