package src;

/**
 * @author adev-exe
 * This class is the main method. It prints out a menu for user to choice what they want to do. The program loads 
 * data then the user can decide to add,remove,update, sort, and print all books by publisher. Once the user
 * exits, if there was any changes it saves data back in to the same textFile
 */

import java.util.Scanner;

public class LibraryApplication {

    public static void main(String[] args) {

        BookCatalog library = new BookCatalog();

        // final name stays the same for the whole program
        final String fileName = "bookCatalog.txt";

        String ISBN;
        String title;
        String author;
        String pub;
        String year;

        library.loadData(fileName);

        Scanner scan = new Scanner(System.in);

        int choice;
        int subChoice;
        String str;

        // used to see if files needs to update textfile when exiting
        boolean updateTextFile = false;

        // used to ask user to press enter to continue
        boolean enter = false;

        do {

            if (enter) {
                System.out.println("\nPress <Enter> to Continue ");
                str = scan.nextLine();
            }

            System.out.println("\n\t\tMenu");
            System.out.println("1. Display all the books\n" + "2. Search for a book\n" + "3. Add a new book\n"
                    + "4. Update an existing book\n" + "5. Remove a book\n" + "6. Search for books by publisher\n"
                    + "7. Sort all the books based on title\n" + "8. Save data\n" + "9. Exit\n");
            System.out.print("Enter Option: ");
            choice = Integer.parseInt(scan.nextLine()); // used to avoid skipping the next line

            switch (choice) {
            case 1:
                library.displayCatalog();
                enter = true;
                break;

            case 2:
                System.out.println("Enter book title to search: ");
                str = scan.nextLine();
                if (library.searchForBook(str) == null) {
                    System.out.println("Book not found");
                } else {
                    System.out.println(library.searchForBook(str));
                }
                enter = true;
                break;

            case 3:
                System.out.print("Enter book to ISBN: ");
                ISBN = scan.nextLine();
                System.out.print("Enter book to Title: ");
                title = scan.nextLine();
                System.out.print("Enter book to Author: ");
                author = scan.nextLine();
                System.out.print("Enter book to Publisher: ");
                pub = scan.nextLine();
                System.out.print("Enter book to year: ");
                year = scan.nextLine();

                if (library.addBook(ISBN, title, author, pub, year)) {
                    System.out.println("Book added");
                    updateTextFile = true;
                }
                enter = true;
                break;

            case 4:

                System.out.print("Enter book to Title: ");
                title = scan.nextLine();

                // Checks to see if book is in the arraylist
                Book temp = null;
                temp = library.searchForBook(title);

                if (temp == null) {
                    System.out.println("Book not in Catalog ");
                    enter = true;
                    break;
                }

                do {

                    temp = library.searchForBook(title);

                    System.out.println("\n\tMenu");
                    System.out.println("1. ISBN \n" + "2. author \n" + "3. publisher \n" + "4. year \n" + "0. Exit ");
                    subChoice = Integer.parseInt(scan.nextLine());

                    switch (subChoice) {
                    case 1:
                        System.out.print("Enter book to ISBN: ");
                        ISBN = scan.nextLine();

                        if (library.updateBook(ISBN, temp.getTitle(), temp.getAuthor(), temp.getPublisher(),
                                temp.getYear())) {
                            System.out.println("Book updated");
                            updateTextFile = true;
                        }

                        break;

                    case 2:
                        System.out.print("Enter book to Author: ");
                        author = scan.nextLine();

                        if (library.updateBook(temp.getISBN(), temp.getTitle(), author, temp.getPublisher(),
                                temp.getYear())) {

                            System.out.println("Book updated");
                            updateTextFile = true;
                        }

                        break;

                    case 3:
                        System.out.print("Enter book to Publisher: ");
                        pub = scan.nextLine();

                        if (library.updateBook(temp.getISBN(), temp.getTitle(), temp.getAuthor(), pub,
                                temp.getYear())) {
                            System.out.println("Book updated");
                            updateTextFile = true;
                        }

                        break;

                    case 4:
                        System.out.print("Enter book to year: ");
                        year = scan.nextLine();

                        if (library.updateBook(temp.getISBN(), temp.getTitle(), temp.getAuthor(), temp.getPublisher(),
                                year)) {
                            System.out.println("Book updated");
                            updateTextFile = true;
                        }
                        break;

                    default:
                        break;

                    }

                } while (subChoice != 0);
                enter = true;
                break;

            case 5:
                System.out.print("Enter book to Title to remove: ");
                title = scan.nextLine();

                if (library.removeBook(title)) {
                    System.out.println("Book removed");
                    updateTextFile = true;
                }
                enter = true;
                break;

            case 6:
                System.out.println("Enter Publisher to search: ");
                pub = scan.nextLine();
                library.getBooksByPublisher(pub);
                enter = true;
                break;

            case 7:
                library.sort();
                System.out.println("Library Sorted");
                enter = true;
                break;

            case 8:
                library.save();
                System.out.println("Library Saved");
                enter = true;
                break;

            case 9:
                if (updateTextFile) {
                    library.save();
                }
                enter = true;
                break;

            default:
                break;
            }

        } while (choice != 9);

        scan.close();

    }
}
