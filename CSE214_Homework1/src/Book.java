/**
 * This class represents textbooks which has a title, author, borrower and condition number.
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
public class Book {
	private String title;
	private String author;
	private String borrower;
	private int condition;

	/**
	 * This is a constructor that creates a new Book object.
	 * <dt><b>Postconditions:</b><dd>
	 * This object has been initialized to a Book object with the required properties.
	 * @param t 
	 * The title of the book
	 * @param a 
	 * The author of the book
	 * @param c 
	 * The condition number of the book
	 */
	public Book(String t, String a, int c) { 
		title = t;
		author = a;
		condition = c;
		borrower = null;
	}

	public String getTitle() {	
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getBorrower() {
		return borrower;
	}

	public int getCondition() {
		return condition;
	}

	public void setTitle(String t) {
		title = t;
	}

	public void setAuthor(String a) {
		author = a;
	}

	public void setBorrower(String b) {
		borrower = b;
	}

	public void setCondition(int c) {
		condition = c;
	}

	/**
	 * A method that creates a clone of a book.
	 * @return 
	 * The new copied book
	 */
	public Book clone() {
		Book newBookCopy = new Book(this.title, this.author, this.condition);
		return newBookCopy;
	}

	/**
	 * A method that compares this book to another object for equality.
	 * @return 
	 * Returns true if the object refers to a Book object with the same properties as this book, otherwise returns false. 
	 * Does not compare the Book object's borrower fields.
	 */
	public boolean equals(Object o) {
		if (o instanceof Book && this.title.equals(((Book) o).title) && this.author.equals(((Book) o).author)
				&& this.condition == ((Book) o).condition) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * A method that returns a printable representation of the Book.
	 * @return 
	 * A String of the book's title, author, condition and borrower
	 */
	public String toString() {
		return "Book Title: " + this.title + "\tAuthor: " + this.author + "\tCondition: " + this.condition
				+ "\tBorrower: " + this.borrower;
	}

}