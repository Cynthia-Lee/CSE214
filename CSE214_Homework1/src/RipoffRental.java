/**
 * This class creates 3 bookshelves (Bookshelf object) and provides an interface for a user to manipulate the list.
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class RipoffRental {
	private static Bookshelf shelfA;
	private static Bookshelf shelfB;
	private static Bookshelf shelfC;
	
	/**
	 * The main method that runs a menu driven application which first creates three empty Bookshelves and then prompts the
	 * user for a menu command selecting the operation. The required information is then requested from the user based on
	 * the selected operation. 
	 */
	public static void main(String args[]) {
		shelfA = new Bookshelf();
		shelfB = new Bookshelf();
		shelfC = new Bookshelf();
		String option;
		Bookshelf current = shelfA;
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Jack's aMAzin' Textbook Rentals, highest price guaranteed!");
		System.out.println();
		do {
			System.out.println("Menu:");
			System.out.println("     A) Add Book");
			System.out.println("     S) Swap Books");
			System.out.println("     L) Loan Book");
			System.out.println("     R) Remove Book");
			System.out.println("     D) Duplicate Book");
			System.out.println("     C) Change Shelf");
			System.out.println("     O) Overwrite shelf with clone of current shelf");
			System.out.println("     E) Check if two shelves are equal");
			System.out.println("     P) Print current bookshelf");
			System.out.println("     Q) Quit");

			System.out.print("Please select an option: ");
			option = input.nextLine();
			if (option.equalsIgnoreCase("A")) { // adding book: title,author,condition,position
				System.out.print("Please enter a title: ");
				String t = input.nextLine();
				System.out.print("Please enter an author: ");
				String a = input.nextLine();
				System.out.print("Please enter condition (1-5): ");
				int c = Integer.parseInt(input.nextLine());
				try {
					if (c < 1 || c > 5) {
						System.out.println("The condition number for the book was invalid.");
						System.out.println();
					} else {
						/*
						 * while(c<1 || c>5) {
						 * System.out.println("The condition number for the book was invalid.");
						 * System.out.print("Please enter condition (1-5): "); c =
						 * Integer.parseInt(input.nextLine()); }
						 */
						Book aBook = new Book(t, a, c);
						System.out.print("Please enter position on shelf: ");
						int p = Integer.parseInt(input.nextLine()) - 1;
						current.addBook(p, aBook);
						System.out.println("Book added!\n");
					}

				} catch (FullShelfException ex) {
					System.out.println("The shelf is full! Could not add another book.");
					System.out.println();
				} catch (IllegalArgumentException ex) {
					System.out.println("The position entered should not create spaces between books.");
					System.out.println();
				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("The position entered is not valid for the shelf.");
					System.out.println();
				}

			} else if (option.equalsIgnoreCase("S")) {
				System.out.print("Please enter an index: ");
				int pos1 = Integer.parseInt(input.nextLine()) - 1;
				System.out.print("Please enter another index: ");
				int pos2 = Integer.parseInt(input.nextLine()) - 1;
				try {
					current.swapBooks(pos1, pos2);
					Book book1 = current.getBook(pos1);
					Book book2 = current.getBook(pos2);
					System.out.println(book1.getTitle() + " has been swaped with " + book2.getTitle() + ".\n");
				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Invalid position(s). There is no book at the index(s).");
					System.out.println();
				}

			} else if (option.equalsIgnoreCase("L")) {
				System.out.print("Please enter an index: ");
				int pos = Integer.parseInt(input.nextLine()) - 1;
				System.out.print("Please enter a recipient: ");
				String recip = input.nextLine();
				System.out.print("Please enter a condition: ");
				int c = Integer.parseInt(input.nextLine());
				// if condition number does not match
				try {
					if (c < 1 || c > 5) {
						System.out.println("Invalid condition number.");
						System.out.println();
					} else if (current.getBook(pos).getCondition() != c) {
						System.out.println("Wrong condition number for that book.");
						System.out.println();
					} else {
						Book aBook = current.getBook(pos);
						aBook.setBorrower(recip);
						System.out.println("\n" + aBook.getTitle() + " has been loaned to " + recip + "\n");
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Invalid position. There is no book at that index.");
					System.out.println();
				}

			} else if (option.equalsIgnoreCase("R")) {
				System.out.print("Please enter an index: ");
				int ind = Integer.parseInt(input.nextLine()) - 1;
				try {
					current.removeBook(ind);
				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Invalid position. There is no book at that index.");
					System.out.println();
				} catch (EmptyShelfException ex) {
					System.out.println("The shelf is empty, there are no books to be loaned.");
					System.out.println();
				}

			} else if (option.equalsIgnoreCase("D")) {
				System.out.print("Please enter a source index: ");
				int source = Integer.parseInt(input.nextLine()) - 1;
				System.out.print("Please enter a destination index: ");
				int dest = Integer.parseInt(input.nextLine()) - 1;
				// make sure source and destination index are valid
				try {
					Book oBook = current.getBook(source);
					Book dupeBook = oBook.clone();
					current.addBook(dest, dupeBook);
					System.out.println("A new copy of " + oBook.getTitle() + " is in index " + dest + ".");
					System.out.println();
				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Invalid position. There is no book at that index.");
					System.out.println();
				} catch (IllegalArgumentException ex) {
					System.out.println("The destination index entered should not create spaces between books.");
					System.out.println();
				} catch (FullShelfException ex) {
					System.out.println("The shelf is full! Could not add the book.");
					System.out.println();
				}

			} else if (option.equalsIgnoreCase("C")) {
				System.out.print("Please select shelf to look at: ");
				String shelf = input.nextLine();
				// shelf must be valid
				boolean validShelf = true;
				String sName = "";
				if (shelf.equalsIgnoreCase("A")) {
					Bookshelf look = shelfA;
					current = look;
					sName = "Shelf A";
				} else if (shelf.equalsIgnoreCase("B")) {
					Bookshelf look = shelfB;
					current = look;
					sName = "Shelf B";
				} else if (shelf.equalsIgnoreCase("C")) {
					Bookshelf look = shelfC;
					current = look;
					sName = "Shelf C";
				} else { // other choice
					validShelf = false;
					// System.out.println("Shelf does not exist. Invalid shelf to change to.");
				}
				if (validShelf) {
					System.out.println(sName + " Selected.");
					System.out.println();
				} else {
					System.out.println("Shelf does not exist. Invalid shelf to change to.");
					System.out.println();
				}

			} else if (option.equalsIgnoreCase("O")) { // overwrite destination shelf with current shelf
				String currentShelf = "";
				if (current == (shelfA)) {
					currentShelf = "Shelf A";
				} else if (current == (shelfB)) {
					currentShelf = "Shelf B";
				} else if (current == (shelfC)) {
					currentShelf = "Shelf C";
				}
				System.out.print("Please select a shelf to overwrite with the current shelf: ");
				String shelf = input.nextLine();	
				try {
					if (shelf.equalsIgnoreCase("A")) {
						if(current==shelfA) { throw new SameShelfException(); }
						shelfA = current.clone();
					} else if (shelf.equalsIgnoreCase("B")) {
						if(current==shelfB) { throw new SameShelfException(); }
						shelfB = current.clone();
					} else if (shelf.equalsIgnoreCase("C")) {
						if(current==shelfC) { throw new SameShelfException(); }
						shelfC = current.clone();
					} else { // other choice
						throw new InvalidShelfException();
						// System.out.println("Shelf does not exist. Invalid shelf to change to.");
					}
					System.out.println("Shelf " + shelf.toUpperCase() + " overwritten with a copy of " + currentShelf + ".");
					System.out.println();
				} catch (SameShelfException ex) {
					System.out.println("Cannot overwrite to the same shelf.");
					System.out.println();
				} catch (InvalidShelfException ex) {
					System.out.println("Shelf does not exist. Invalid shelf to change to.");
					System.out.println();
				}
				/*
				 * //destS = current.clone(); System.out.println(destS);//just a reference,
				 * shelfB actually not changed System.out.println(shelfB);
				 */

				// System.out.println("Shelf "+shelf.toUpperCase()+" overwritten with a copy of
				// "+currentShelf+".");

			} else if (option.equalsIgnoreCase("E")) {
				System.out.print("Please select a shelf: ");
				String s1 = input.nextLine();
				System.out.print("Please select another shelf: ");
				String s2 = input.nextLine();
				// check if shelves are valid
				Bookshelf shelf1;
				Bookshelf shelf2;
				if (s1.equalsIgnoreCase("A")) {
					shelf1 = shelfA;
				} else if (s1.equalsIgnoreCase("B")) {
					shelf1 = shelfB;
				} else if (s1.equalsIgnoreCase("C")) {
					shelf1 = shelfC;
				} else {
					shelf1 = null;
					System.out.println("Invalid first shelf selected.");
				}
				if (s2.equalsIgnoreCase("A")) {
					shelf2 = shelfA;
				} else if (s2.equalsIgnoreCase("B")) {
					shelf2 = shelfB;
				} else if (s2.equalsIgnoreCase("C")) {
					shelf2 = shelfC;
				} else {
					shelf2 = null;
					System.out.println("Invalid second shelf selected.");
				}
				if (shelf1 != null && shelf2 != null) {
					if (shelf1.equals(shelf2)) {
						System.out.println("The shelves are equal.");
						System.out.println();
					} else {
						System.out.println("The shelves are not equal.");
						System.out.println();
					}
				}

			} else if (option.equalsIgnoreCase("P")) {
				String shelfName = "";
				if (current == (shelfA)) {
					shelfName = "Bookshelf A:";
				} else if (current == (shelfB)) {
					shelfName = "Bookshelf B:";
				} else if (current == (shelfC)) {
					shelfName = "Bookshelf C:";
				}
				// printing out the shelf header
				System.out.println(shelfName);
				// System.out.format("%0s,%44s,%20s%1s", "Shop Title", "Author", "Cond.",
				// "Borrower");
				System.out.format("%-4s %-48s %-25s %-5s %s%n", "Spot", "Title", "Author", "Cond.", "Borrower");
				String line = "----------------------------------------------------------------------------------------------------------------";
				System.out.println(line);
				System.out.print(current.toString());

			} else if (!option.equalsIgnoreCase("Q")) { // any other letters or numbers (invalid)
				System.out.println("Please enter a valid option!");
			}

		} while (!option.equalsIgnoreCase("Q"));
		// option was Q
		System.out.println("Goodbye!");
	}
}
