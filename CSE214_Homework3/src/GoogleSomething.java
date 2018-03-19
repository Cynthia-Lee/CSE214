/**
 * This class represents the “G: Google something” command for the Safari app.
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class GoogleSomething extends Safari implements Command {
	private String query;

	/**
	 * Constructs this GoogleSomething instance accordingly after reading input from the scanner.
	 * @param scanner
	 * Uses scanner to take a String for the "query" to create GoogleSomething
	 */
	public GoogleSomething(Scanner scanner) {
		System.out.print("Please enter a query: ");
		query = scanner.nextLine().toString();
	}

	/**
	 * Returns whether or not pushing this GoogleSomething command will be valid for the given stack.
	 * @return
	 * True if can insert GoogleSomething into the CommandStack
	 */
	public boolean validCommand(CommandStack stack) {
		// Returns whether or not pushing this GoogleSomething command will be valid for
		// the given stack.
		return true;
	}

	/**
	 * Returns the String representation of this Command in long form (for current screen display)
	 * @return
	 * A String that describes GoogleSomething 
	 */
	public String toString() {
		return "Current Screen: Google: " + query;
	}

	/**
	 * Returns the String representation of this Command in short form (for stack display)
	 * @return
	 * A shorter String that represents the GoogleSomething
	 */
	public String toShortString() {
		return "G:" + query;
	}
}
