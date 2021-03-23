package src;

/**
 *  @author adev-exe
 *  Class implements BookCatalogInterface. Class used to create an ArrayList of Books, 
 *  loads data from a file and puts books into the arraylist, display catalog, it can add, remove, update
 *  sort books in the arraylist. Save changes back into the textfile.
 */

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class BookCatalog implements BookCatalogInterface {

	private ArrayList<Book> bookList = new ArrayList<>();
	private String fileName;

	/**
	 * Default Constructor, Creates arraylist
	 */
	public BookCatalog() {
		bookList = new ArrayList<>();
	}

	/**
	 * Opens given file and stores contents into the BookList(ArrayList) If file
	 * can't be open it displays an error
	 * 
	 * @param fileName, the given fileName
	 */
	public void loadData(String fileName) {

		String ISBN;
		String title;
		String author;
		String pub;
		String year;
		Scanner fileContent = null;
		this.fileName = fileName;

		try {
			fileContent = new Scanner(new File(fileName));

		} catch (FileNotFoundException e) {
			System.out.println("Error openning the file " + fileName);
			System.exit(1);
		}
		while (fileContent.hasNextLine()) {

			ISBN = fileContent.nextLine();
			title = fileContent.nextLine();
			author = fileContent.nextLine();
			pub = fileContent.nextLine();
			year = fileContent.nextLine();

			Book book = new Book(ISBN, title, author, pub, year);

			bookList.add(book);

			if (!fileContent.hasNext()) {
				break;
			} else {
				fileContent.nextLine();
			}

		}
		fileContent.close();

	}

	/**
	 * Displays Every Book and its information in the bookList
	 */
	public void displayCatalog() {

		Iterator<Book> iter = bookList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

	/**
	 * Searches if book is in the bookList
	 * 
	 * @param title, the given title
	 * @return book if found, returns null if not found
	 */
	public Book searchForBook(String title) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equals(title)) {
				return bookList.get(i);
			}
		}

		return null;
	}

	/**
	 * Adds new book into the arrayList, as long as a book does not extist already
	 * in the Catalog
	 * 
	 * @param ISBN, title, author, pub, year --- The given ISBN, title, author, pub,
	 *              year
	 * @return true if book was added, returns false if book was not added
	 */
	public boolean addBook(String ISBN, String title, String author, String pub, String year) {

		if (searchForBook(title) == null) {
			Book book = new Book(ISBN, title, author, pub, year);
			bookList.add(book);
			return true;

		} else {
			System.out.println("Book already Exists");
		}

		return false;
	}

	/**
	 * Updates book if it is present arrayList(catalog) exist already in the Catalog
	 * 
	 * @param ISBN, title, author, pub, year --- The given ISBN, title, author, pub,
	 *              year
	 * 
	 * @return true if book was updated, returns false if book was not updated
	 */
	public boolean updateBook(String ISBN, String title, String author, String pub, String year) {

		int index;

		if (searchForBook(title) == null) {

			System.out.println("Book does not Exists");

			return false;
		}

		Book book = new Book(ISBN, title, author, pub, year);

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equals(title)) {
				index = i;
				bookList.set(index, book);
			}
		}

		return true;

	}

	/**
	 * Removes book if present in bookList(catalog)
	 * 
	 * @param title, the given title
	 * @return true if book was remove, returns false if book was not remove
	 */
	public boolean removeBook(String title) {

		if (searchForBook(title) == null) {
			System.out.println("No book Exists ");
			return false;
		}

		else {
			for (int i = 0; i < bookList.size(); i++) {
				if (bookList.get(i).getTitle().equals(title)) {
					bookList.remove(i);
				}
			}
			return true;
		}
	}

	/**
	 * Created new ArrayList that stores all books created by a specific publisher
	 * if there are no books created by a the given publisher the size stays at 0
	 * 
	 * @param pub, the given pub
	 * @return publisherList , the new arraylist that stores books by a specific
	 *         publisher
	 */
	public ArrayList<Book> getBooksByPublisher(String pub) {
		ArrayList<Book> publisherList = new ArrayList<>();

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getPublisher().equals(pub)) {
				publisherList.add(bookList.get(i));
			}
		}

		if (publisherList.isEmpty()) {
			for (int i = 0; i < publisherList.size(); i++) {
				System.out.println(publisherList.get(i));
			}
		} else {
			System.out.println("No Books by Publisher");
		}

		return publisherList;

	}

	/**
	 * Sorts Books in bookList (Catalog) by alphabetic order
	 */
	public void sort() {
		Collections.sort(bookList);
	}

	/**
	 * Writes updates changes in the original arrayList(catalog) to the file
	 */
	public void save() {

		try {
			PrintWriter writer = new PrintWriter(fileName);
			BufferedWriter buffer = new BufferedWriter(writer);

			for (int i = 0; i < bookList.size(); i++) {
				buffer.write(bookList.get(i).getISBN() + "\n");
				buffer.write(bookList.get(i).getTitle() + "\n");
				buffer.write(bookList.get(i).getAuthor() + "\n");
				buffer.write(bookList.get(i).getPublisher() + "\n");
				buffer.write(bookList.get(i).getYear() + "\n" + "\n");
			}
			buffer.close();

		} catch (IOException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}

	}

}