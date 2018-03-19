/**
 * This class represents the stack of Commands for the phone app. 
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.LinkedList;

public class CommandStack extends LinkedList<Command> {
	// private CommandStack commandStack;
	LinkedList<Command> commandStack = new LinkedList<Command>();

	/**
	 * Pushes command onto the top of the backing data structure.
	 * @param command
	 * Command that would be inserted into the CommandStack
	 * @throws InvalidCommandException
	 * If the Command is invalid given the current state of this CommandStack.
	 */
	public void pushCommand(Command command) throws InvalidCommandException {
		if (command.validCommand(this)) {
			// Make sure safari commands aren't placed on top of map commands and vice versa
			// if (!commandStack.isEmpty()) { // if stack not empty
			// if ((commandStack.peek() instanceof Maps && command instanceof Maps)
			// || commandStack.peek() instanceof Safari && command instanceof Safari) {
			// // add to the head
			// commandStack.addFirst(command);
			// }
			// } else {
			commandStack.addFirst(command);
			// }
		} else {
			throw new InvalidCommandException();
		}
	}

	/**
	 * Removes the topmost Command from the stack and returns it.
	 * @return
	 * The Command that was popped from the CommandStack
	 * @throws EmptyStackException
	 * If the CommandStack was empty
	 */
	public Command popCommand() throws EmptyStackException {
		if (commandStack.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return commandStack.removeFirst();
		}
	}

	/**
	 * Returns the topmost Command from the stack without removing it. 
	 * The stack should be unchanged as a result of this method.
	 * @return
	 * The Command on the top of the CommandStack
	 * @throws EmptyStackException
	 * If the CommandStack was empty
	 */
	public Command peekCommand() throws EmptyStackException {
		if (commandStack.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return commandStack.peek();
		}
	}

	/**
	 * Returns true if the stack is empty, false otherwise.
	 * @return
	 * True if CommandStack is empty, else return false if CommandStack is not empty
	 */
	public boolean isEmpty() {
		return commandStack.isEmpty();
	}

	/**
	 * Returns a String representation of the Command that will be displayed on the screen.
	 * @return
	 * String representing the current screen of the Command
	 */
	public String getScreenCommand() {
		try {
			return this.peekCommand().toString();
		} catch (EmptyStackException e) {
			return "";
		}
	}

	/**
	 * Returns a String representation of this CommandStack. 
	 * @return
	 * String representing the short Strings of each Command with arrows
	 */
	public String toString() {
		String s = "";
		for (int i = commandStack.size() - 1; i >= 0; i--) {
			s += "->";
			s = s + commandStack.get(i).toShortString();
		}
		return s;
	}

}
