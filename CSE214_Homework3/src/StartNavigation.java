/**
 * This class represents the “N: Start Navigation” command for the Maps app. 
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
public class StartNavigation extends Maps implements Command {
	private String source = null;
	private String destination = null;

	/**
	 * Constructs this StartNavigation instance accordingly after grabbing navigation information from the last instruction.
	 * @param commandStack
	 * CommandStack that the Command will be inserted into
	 * @throws EmptyStackException
	 * If the CommandStack is empty
	 * @throws InvalidCommandException
	 * If the Command cannot be created because it has invalid parameters
	 */
	public StartNavigation(CommandStack commandStack) throws EmptyStackException, InvalidCommandException { // gets info from previous (F or P)
		// can throw exceptions?
		Command prev = commandStack.peekCommand();
		if (prev != null) {
			if (prev instanceof FindPlace) {
				destination = ((FindPlace)prev).getDestination();
			} else if (prev instanceof PlanRoute) {
				source = ((PlanRoute)prev).getSource();
				destination = ((PlanRoute)prev).getDestination();
			}
		}
	}

	/**
	 * Returns whether or not pushing this StartNavigation command will be valid for the given stack.
	 * This cannot be placed on top of another StartNavigation command or an empty stack
	 * @return
	 * True if StartNavigation Command can be created, else it would return false when the CommandStack is empty
	 * or when the previous Command is not applicable so that a StartNavigation can occur
	 */
	public boolean validCommand(CommandStack stack) {
		// cannot be placed on top of another StartNavigation command or empty stack
		try {
			if (stack.peekCommand() instanceof StartNavigation) {
				return false;
			} else {
				return true;
			}
		} catch (EmptyStackException ex){
			return false;
		}
	}

	/**
	 * Returns the String representation of this Command in long form (for current screen display)
	 * @return
	 * A String that represents the StartNavigation
	 */
	public String toString() {
		if (source != null) { // P
			return "Current Screen: Navigating from " + source + " to " + destination;
		} else { // F
			return "Current Screen: Navigating to " + destination;
		}
	}

	/**
	 * Returns the String representation of this Command in short form (for stack display)
	 * @return
	 * A shorter String that represents the StartNavigation
	 */
	public String toShortString() {
		if (source != null) { // P
			return "N:" + source + "-" + destination;
		} else { // F
			return "N:" + destination;
		}
	}
}
