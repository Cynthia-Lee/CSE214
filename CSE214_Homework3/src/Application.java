/**
 * This class represents the applications of the phone app. (Map and Safari)
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

// Note: you may make this abstract and have two implementing classes Maps and Safari. 
// You may make all private methods and variables protected in this case.
public abstract class Application {
	protected CommandStack stack = new CommandStack();

	/**
	 * Reads in input from the scanner to construct a Command and add it to the CommandStack.
	 * After determining command type, use the command's built in method to read from scanner to populate data fields
	 * @param scanner
	 * Uses a scanner to get the Strings to use for the Command
	 * @throws InvalidCommandException
	 * If the Command is invalid given the current state of the stack
	 * @throws EmptyStackException
	 * If the CommandStack is empty
	 */
	public void readCommand(Scanner scanner) throws InvalidCommandException, EmptyStackException {
		// Reads in input from the scanner to construct a Command and add it to the
		// CommandStack.
		// After determining command type, use the command's built in method
		// to read from scanner to populate data fields
	}
	
	/**
	 * Returns the application to the state it was before the most recent Command.
	 * @throws EmptyStackException
	 * If there was no Command entered
	 */
	public void goBack() throws EmptyStackException {
		// Returns the application to the state it was before the most recent Command.
		// Throws:EmptyStackException if there was no Command entered
	}

}
