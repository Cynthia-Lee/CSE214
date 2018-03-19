/**
 * This class represents the “F: Go to favorite/bookmark” command for the Safari app. 
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class GoToBookmark extends Safari implements Command {
	private String bookmark;

	/**
	 * Constructs this GoToBookmark instance accordingly after reading input from the scanner.
	 * @param scanner
	 * Uses scanner to take in a String to be used as the "bookmark name" for GoToBookmark
	 */
	public GoToBookmark(Scanner scanner) {
		System.out.print("Please enter bookmark name: ");
		bookmark = scanner.nextLine().toString();
	}

	/**
	 * Returns whether or not pushing this GoToBookmark command will be valid for the given stack.
	 * @return
	 * True if can insert GoToBookmark into the CommandStack
	 */
	public boolean validCommand(CommandStack stack) {
		// Returns whether or not pushing this GoToBookmark command will be valid for
		// the given stack.
		return true;
	}

	/**
	 * Returns the String representation of this Command in long form (for current screen display)
	 * @return
	 * A String that represents the GoToBookmark
	 */
	public String toString() {
		return "Current Screen: " + bookmark;
	}

	/**
	 * Returns the String representation of this Command in short form (for stack display)
	 * @return
	 * A shorter String that represents the GoToBookmark
	 */
	public String toShortString() {
		return "F:" + bookmark;
	}
}
