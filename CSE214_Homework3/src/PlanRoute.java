/**
 * This class represents the “P: Plan a route” command for the Maps app.
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class PlanRoute extends Maps implements Command {
	private String source;
	private String destination;

	/**
	 * Constructs this PlanRoute instance accordingly after reading input from the scanner.
	 * @param scanner
	 * Uses scanner to take a String for the "source" and "destination to create PlanRoute 
	 */
	public PlanRoute(Scanner scanner) {
		System.out.print("Please enter a source: ");
		source = scanner.nextLine().toString();
		System.out.print("Please enter a destination: ");
		destination = scanner.nextLine().toString();
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	/**
	 * Returns whether or not pushing this PlanRoute command will be valid for the given stack.
	 * @return
	 * True if the Command can be inserted into the stack, else it would return false
	 */
	public boolean validCommand(CommandStack stack) {
		// Returns whether or not pushing this PlanRoute command will be valid for the
		// given stack.
		return true;
	}

	/**
	 * Returns the String representation of this Command in long form (for current screen display)
	 * @return
	 * A String that represents the PlanRoute
	 */
	public String toString() {
		return "Current Screen: Planning route from " + source + " to " + destination;
	}

	/**
	 * Returns the String representation of this Command in short form (for stack display)
	 * @return
	 * A shorter String that represents the PlanRoute
	 */
	public String toShortString() {
		return "P:" + source + "-" + destination;
	}
}
