/**
 * This class represents the driver class for the phone app. User can input choices. 
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class iCatchUp {
	static int menu = 1;
	static Maps maps;
	static Safari safari;

	/**
	 * The main method runs a menu driven application which allows the user to create two instances of the Application class and 
	 * then prompts the user for input based on which screen it is currently in (Home, Maps, or Safari). 
	 * The required information for each command is then requested from the user based on the selected operation.
	 * @param args
	 */
	public static void main(String[] args) {
		maps = new Maps(); // creates new CommandStack from Application
		safari = new Safari();
		Scanner input = new Scanner(System.in);
		String option;

		System.out.println("Welcome to the iPhony pocket telegraph simulator. You are on the home screen.");

		while (menu == 3 || menu == 2 || menu == 1) {
			
			if (menu == 1) { // Home options
				System.out.println("Home Options: ");
				System.out.println("\tS - Safari");
				System.out.println("\tM - Maps");
				System.out.println("\tQ - Quit");
				System.out.print("Please select an option: ");
				option = input.nextLine();
				System.out.println();
				if (option.equalsIgnoreCase("S")) {
					menu = 2;
					System.out.println(debugTitle() + safari.stack.toString());
					System.out.println(safari.stack.getScreenCommand());
				} else if (option.equalsIgnoreCase("M")) {
					menu = 3;
					System.out.println(debugTitle() + maps.stack.toString());
					System.out.println(maps.stack.getScreenCommand());
				} else if (option.equalsIgnoreCase("Q")) {
					System.out.println("Sorry to see you go, tell the iPod I said hi!");
					menu = 0;
				} else {
					System.out.println("Invalid option. Please select another option.");
				}
			} 
			
			if (menu == 3) { // MAPS
				System.out.println("Maps Options:");
				System.out.println("\tF) Find a place");
				System.out.println("\tP) Plan a route");
				System.out.println("\tN) Start Navigation");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Safari");
				System.out.println("\tB) Back");
				System.out.print("Please enter an option: ");
				try {
					maps.readCommand(input);
					if (menu == 3) {
						System.out.println(debugTitle() + maps.stack.toString());
						System.out.println(maps.stack.getScreenCommand());
					} else if (menu == 2) { // switch to safari
						System.out.println(debugTitle() + safari.stack.toString());
						System.out.println(safari.stack.getScreenCommand());
					}

				} catch (InvalidCommandException ex) {
					System.out.println("Invalid option. Please select another option.");
				} catch (EmptyStackException ex) {
					System.out.println("No route or destination!");
					System.out.println();
					System.out.println(debugTitle() + maps.stack.toString());
					// System.out.println(maps.stack.getScreenCommand());
				}
			}

			if (menu == 2) { // SAFARI
				System.out.println("Safari Options:");
				System.out.println("\tG) Google Something");
				System.out.println("\tF) Go to a favorite (bookmark)");
				System.out.println("\tL) Follow a link");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Maps");
				System.out.println("\tB) Back");
				System.out.print("Please enter an option: ");
				try {
					safari.readCommand(input);
					if (menu == 2) {
						System.out.println(debugTitle() + safari.stack.toString());
						System.out.println(safari.stack.getScreenCommand());
					} else if (menu == 3) { // switch to maps
						System.out.println(debugTitle() + maps.stack.toString());
						System.out.println(maps.stack.getScreenCommand());
					}

				} catch (InvalidCommandException ex) {
					System.out.println("Invalid option. Please select another option.");
				} catch (EmptyStackException ex) {
					System.out.println("Could not execute the option because stack is empty.");
				}
			}
		}
	}

	/**
	 * A method that is used to print out the beginning of the String of the display stack and screen
	 * @return
	 * A String for the beginning of the String that represents the display stack and display screen
	 */
	public static String debugTitle() {
		// if (iCatchUp.menu == 3) {
		// System.out.println("Current Screen: Map Home");
		// }
		// if (iCatchUp.menu == 2) {
		// System.out.println("Current Screen: Safari Home");
		// }
		String s = "Stack Debug:\n[Home->";
		if (menu == 3) {
			s = s + "MapsHome";
			if (maps.stack.isEmpty()) {
				s += "\nCurrent Screen: Maps Home";
			}
		} else if (menu == 2) {
			s = s + "SafariHome";
			if (safari.stack.isEmpty()) {
				s += "\nCurrent Screen: Safari Home";
			}

		}

		return s;
	}

}
