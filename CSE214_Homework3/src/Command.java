/**
 * This class is a interface to represent each command entered on the phone app. 
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
//interface
public interface Command {
	
	/**
	 * Returns whether this Command is valid and can be added to the given CommandStack. 
	 * Specific behavior will be outlined in the following classes.
	 * @param stack
	 * The CommandStack that the Command would be inserted to
	 * @return
	 * True if the command can be inserted in the CommandStack, else it would return false
	 */
	public boolean validCommand(CommandStack stack); // if stack is valid, add to the stack

	/**
	 * Returns the String representation of this Command in long form (for current screen display)
	 * @return
	 * A String that describes the Command in "long" form (Current Screen: )
	 */
	public String toString();// returns String representation of Command form

	/**
	 * Returns the String representation of this Command in short form (for stack display)
	 * @return
	 * A String that is short to describes the Command shown in a stack
	 */
	public String toShortString(); // String representation of this Command in short form (for stack display)
}
