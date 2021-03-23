package src;

/**
 * @author adev-exe
 */

import java.util.ArrayList;

public interface BookCatalogInterface {

    /**
     * Uses given fileName to read file and store the data containing all the books
     * from a given file and puts the books into an ArrayList
     * 
     * @param fileName the given fileName
     */
    public void loadData(String fileName);

    /**
     * Display all the information of every book in arraylist
     */
    public void displayCatalog();

    /**
     * Searches list for the given title
     * 
     * @param title the given title
     * @return the Book object if found, or null if not found.
     */
    public Book searchForBook(String title);

    /**
     * Checks if the title isn't already in the list, if it is it prints statement
     * that book can't be added if the title is not in use then it adds the given
     * book
     * 
     * @param ISBN   The given ISBN
     * @param title  The given title
     * @param author The given author
     * @param pub    The given pub
     * @param year   The given year
     * @return a boolean value. If the book is added, it returns true; otherwise it
     *         returns false.
     */
    public boolean addBook(String ISBN, String title, String author, String pub, String year);

    /**
     * Checks if title is present in the arraylist, if true then it updates to the
     * given param, the title will not be changed if the title is not present then
     * it will print message that the book cannnot be updated
     * 
     * @param ISBN   The given ISBN
     * @param title  The given title
     * @param author The given author
     * @param pub    The given pub
     * @param year   The given year
     * @return true if book was updated, returns false if the book did not update
     */
    public boolean updateBook(String ISBN, String title, String author, String pub, String year);

    /**
     * Checks list to see if the title of the book is in the list, if true then it
     * will remove the whole book if the book is not in the arraylist, then it will
     * print message that the book is not in the list
     * 
     * @param title the given title
     * @return true if the book was removed successfully, returns false if book is
     *         not removed, or present in the arraylist
     */
    public boolean removeBook(String title);

    /**
     * Creates a new arraylist and stores all the books by the given pub, if there
     * is no books then the arraylist size remains at zero and prints that no books
     * by the given pub is was found
     * 
     * @param pub the given publisher
     * @return arraylist of books from the given publisher
     */
    public ArrayList<Book> getBooksByPublisher(String pub);

    /**
     * Sorts the arraylist of books by alphabetic order by title
     */
    public void sort();

    /**
     * Saves changes(add,updated,removed) into the textfile was was originally used
     * to loadData
     */
    public void save();

}
