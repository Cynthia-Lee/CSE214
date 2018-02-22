/**
 * This class represents a bookshelf, which has an array of textbooks (Book objects).
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
public class Bookshelf {
	// bookshelf should contain a list of all books on the shelf
	// It may not contain "holes" in the array
	// (there should not be a non-null array element with a higher index than any
	// null element in the array).
	private Book[] books;
	private int count;
	private final int CAPACITY = 20;

	/**
	 * This default constructor creates a new Bookshelf which contains an array of Book objects.
	 * <dt><b>Postconditions:</b><dd>
	 * The array books has been initialized, and count has been set to 0.
	 */
	public Bookshelf() { 
		books = new Book[CAPACITY];
		count = 0;
	}

	/**
	 * The method returns the total number of Books on the bookshelf.
	 * @return Number of textbooks on a shelf
	 */
	public int numBooks() {
		return count;
	}

	/**
	 * The method gets the Book object at the given index from the bookshelf.
	 * @param index
	 * Index for the book on the bookshelf
	 * @return
	 * The book at the index on the bookshelf
	 * @throws ArrayIndexOutOfBoundsException
	 * If the index is invalid and does not exist
	 */
	public Book getBook(int index) throws ArrayIndexOutOfBoundsException { // list should be unchanged
		if (index > 19 || index < 0 || index >= count) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return books[index];
		}
	}

	/**
	 * The method removes the book from the bookshelf and moves all the books to the right of it leftwards by one index.
	 * @param index
	 * Index for the book on the bookshelf
	 * @return
	 * The book at the index on the bookshelf
	 * @throws ArrayIndexOutOfBoundsException
	 * If the index is invalid and does not exist
	 * @throws EmptyShelfException
	 * If there is no book on the shelf
	 */
	public Book removeBook(int index) throws ArrayIndexOutOfBoundsException, EmptyShelfException {
		Book theBook = books[index];
		if (count == 0) { // if the shelf is empty, throw custom exception
			throw new EmptyShelfException();
		} else if (index > 19 || index < 0 || index >= count) {
			throw new ArrayIndexOutOfBoundsException();
		} else { // successful: removes the given book and moves all books to the right of it leftwards by one box
			for (int r = index; r < books.length - 1; r++) {
				if (books[r + 1] == null) { // nothing to move leftwards
					break;
				} else {
					books[r] = books[r + 1];
				}
			}
			count--;
			return theBook;
		}
	}

	/**
	 * The method adds a book at the given index, moving all books at or after the given index one index to the right.
	 * @param index
	 * Index for the book on the bookshelf
	 * @param book
	 * Book object
	 * @throws IllegalArgumentException
	 * If the index is too high and would create a hole in the array
	 * @throws FullShelfException
	 * If more than 20 books are added to the shelf
	 * @throws ArrayIndexOutOfBoundsException
	 * If the index is invalid and does not exist
	 */
	public void addBook(int index, Book book) throws IllegalArgumentException, FullShelfException, ArrayIndexOutOfBoundsException {
		if (count == CAPACITY) {
			throw new FullShelfException();
		} else if (index > count) { // if index too high and would create a hole ->illegal argument
			throw new IllegalArgumentException();
		} else if (index < 0 || index > 19) {
			throw new ArrayIndexOutOfBoundsException();
		} else { // successful: adds book at the given index, moving all books at or after 1 index to the right
			/*
			 * if(index==count) { //book was added to the end, no need to move books[index]
			 * = book; } else {
			 */
			for (int i = count; i > index; i--) {
				books[i] = books[i - 1];
			}
			books[index] = book;
			// }
			count++;
		}
	}

	/**
	 * The method swaps two books at the given indices if the indices are valid.
	 * @param index1
	 * First index to swap a book to
	 * @param index2
	 * Second index to swap a book to
	 * @throws ArrayIndexOutOfBoundsException
	 * If either index is invalid or does not exist
	 */
	public void swapBooks(int index1, int index2) throws ArrayIndexOutOfBoundsException {
		if (books[index1] != null && books[index2] != null) { // index are valid
			Book temp = books[index1];
			books[index1] = books[index2];
			books[index2] = temp;
		}
		if (books[index1] == null || books[index2] == null) {
			throw new ArrayIndexOutOfBoundsException();
		}

	}

	/**
	 * The method creates a deep copy of this Bookshelf object, all books are copied (without borrower fields).
	 * @return 
	 * The Bookshelf copy
	 */
	public Bookshelf clone() { // borrower fields for each book is not copied!
		Bookshelf BookshelfCopy = new Bookshelf();
		for (int i = 0; i < count; i++) {
			Book cloneBook = this.books[i].clone();
			BookshelfCopy.books[i] = cloneBook;
			BookshelfCopy.count = BookshelfCopy.count + 1;
		}
		return BookshelfCopy;
	}

	/**
	 * The method checks if the Bookshelf is equal to another object. (equal books in the same order)
	 * @return
	 * Returns true if the Bookshelf and object are equal, otherwise return false
	 */
	public boolean equals(Object o) {
		if (o instanceof Bookshelf) {
			Bookshelf b = (Bookshelf) o;
			if (b.count == this.count) {
				for (int i = 0; i < count; i++) {
					if (!(this.books[i].equals(b.books[i]))) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * A method that returns a printable representation of the Bookshelf.
	 * @return
	 * A string of every book in the bookshelf. Book number, title, author, condition and borrower
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < count; i++) {
			String borrowerS = books[i].getBorrower();
			if (borrowerS == null) {
				borrowerS = "<none>";
			}
			s = s + String.format("%-5s",(i+1)+".") + String.format("%-48s %-25s %-5s %-5s", books[i].getTitle(), books[i].getAuthor(), books[i].getCondition(), borrowerS) + "\n";
			
		}
		return s;
	}

}
