package src;

/**
 * @author adev-exe
 * 
 *         This class creates a Book Object that contains ISBN, Title,
 *         publisher, and year for each book created. There is a toString method
 *         to print out formatted book information equals and a compareTo method
 */

public class Book implements Comparable<Book> {

    private String ISBN;
    private String title;
    private String author;
    private String pub;
    private String year;

    /**
     * Constructor
     * 
     * @param ISBN   the given ISBN
     * @param title  the given title
     * @param author the given author
     * @param pub    he given pub
     * @param year   the given year
     */
    public Book(String ISBN, String title, String author, String pub, String year) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.pub = pub;
        this.year = year;
    }

    /**
     * @return ISBN the given ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Modify the ISBN
     * 
     * @param ISBN, the given ISBN
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return title the given title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modify the author
     * 
     * @param author, the given author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return author the given author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Modify the pub
     * 
     * @param pub, the given pub
     */
    public void setPublisher(String pub) {
        this.pub = pub;
    }

    /**
     * @return pub the given pub
     */
    public String getPublisher() {
        return pub;
    }

    /**
     * Modify the year
     * 
     * @param year, the given year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return year the given year
     */
    public String getYear() {
        return year;
    }

    /**
     * @return Formatted book info
     */
    @Override
    public String toString() {

        return "ISBN: " + getISBN() + " Title: " + getTitle() + " Author: " + getAuthor() + " Publisher: "
                + getPublisher() + " Publishing Year: " + getYear();
    }

    /**
     * Compares Book title with another Book title
     * 
     * @param obj, the given obj
     * @return returns true if the Book titles are the same false if obj is null, is
     *         two book titles are not equal r
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Book) {
            Book temp = (Book) obj;
            return (this.title == temp.title);
        } else {
            return false;
        }
    }

    /**
     * @param temp, given give temp
     * @returns compares two titles and returns comparison value(int)
     */
    @Override
    public int compareTo(Book temp) {
        return this.title.compareTo(temp.title);

    }

}
