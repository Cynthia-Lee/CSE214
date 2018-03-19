/**
 * This class represents the Map app for the phone app. It has all the choices when in the Map app.
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class Maps extends Application {

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
		if (option.equalsIgnoreCase("F")) {
			System.out.println();
			//System.out.print("Please enter a location: ");
			c = new FindPlace(scanner);
			System.out.println();
			stack.pushCommand(c);
		} else if (option.equalsIgnoreCase("P")) {
			c = new PlanRoute(scanner);
			System.out.println();
			stack.pushCommand(c);
		} else if (option.equalsIgnoreCase("N")) {
			c = new StartNavigation(stack);
			stack.pushCommand(c);
		} else if (option.equalsIgnoreCase("H")) {
			iCatchUp.menu = 1;
		} else if (option.equalsIgnoreCase("S")) {
			iCatchUp.menu = 2;
		} else if (option.equalsIgnoreCase("B")) {
			if(stack.isEmpty()) { //
				iCatchUp.menu = 1;
			} else {
				this.goBack();
			}
		} else {
			throw new InvalidCommandException();
		}
		
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
