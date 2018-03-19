/**
 * This class represents the Safari app for the phone app. It has all the choices when in the Safari app.
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class Safari extends Application{
	
	/**
	 * The method reads in scanner inputs depending on the choice the user picked, and populates it to the 
	 * specific Command 
	 * @throws InvalidCommandException
	 * If the Command is invalid as it cannot create a Command
	 * @throws EmptyStackException
	 * If the CommandStack is empty
	 */
	public void readCommand(Scanner scanner) throws InvalidCommandException, EmptyStackException {
		String option = scanner.nextLine().toString();
		Command c = null;
		if (option.equalsIgnoreCase("G")) {
			//System.out.print("Please enter a query: ");
			c = new GoogleSomething(scanner);
			stack.pushCommand(c);
		} else if (option.equalsIgnoreCase("F")) {
			//System.out.print("Please enter bookmark name: ");
			c = new GoToBookmark(scanner);
			stack.pushCommand(c);
		} else if (option.equalsIgnoreCase("L")) {
			//System.out.print("Please enter a link: ");
			c = new FollowLink(scanner);
			stack.pushCommand(c);
		} else if (option.equalsIgnoreCase("H")) {
			iCatchUp.menu = 1;
		} else if (option.equalsIgnoreCase("S")) {
			iCatchUp.menu = 3;
		} else if (option.equalsIgnoreCase("B")) {
			if(stack.isEmpty()) { //
				iCatchUp.menu = 1;
			} else {
				this.goBack();
			}
		} else {
			throw new InvalidCommandException();
		}
		//stack.pushCommand(c);
	}
	
	/**
	 * The method allows the user to go back to their previous Command
	 * @throws EmptyStackException
	 * If the CommandStack is empty
	 */
	public void goBack() throws EmptyStackException {
		stack.popCommand();
	}
}
