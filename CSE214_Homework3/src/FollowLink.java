/**
 * This class represents the L: FollowLink” command for the Safari app. 
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class FollowLink extends Safari implements Command {
	private String link;

	/**
	 * Constructs this FollowLink instance accordingly after reading input from the scanner.
	 * @param scanner
	 * Uses scanner to take in a String for the "link" for FollowLink
	 */
	public FollowLink(Scanner scanner) {
		System.out.print("Please enter a link: ");
		link = scanner.nextLine().toString();
	}

	/**
	 * Returns whether or not pushing this FollowLink command will be valid for the given stack.
	 * This cannot be placed on top of an empty stack
	 * @return
	 * True if FollowLink can be inserted into the CommandStack, else false when CommandStack is empty
	 */
	public boolean validCommand(CommandStack stack) {
		if (stack.isEmpty()) { // cannot put on top of an empty stack
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Returns the String representation of this Command in long form (for current screen display)
	 * @return
	 * A String that describes FollowLink
	 */
	public String toString() {
		return "Current Screen: " + link;
	}

	/**
	 * Returns the String representation of this Command in short form (for stack display)
	 * @return
	 * A shorter String that represents the FollowLink
	 */
	public String toShortString() {
		return "L:" + link;
	}

}
