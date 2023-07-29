package BaiscPractice.OnlineLibrary;


class Library {

    private static final int MAX_BOOKS = 50;
    private String[] books = new String[MAX_BOOKS];
    private int bookCount = 0;

    public void addBook(String bookTitle) {
        if (bookCount < MAX_BOOKS) {
            books[bookCount] = bookTitle;
            bookCount++;
        } else {
            System.out.println("Library is full");
        }
    }

    public void issueBook(String bookTitle) {
        boolean bookFound = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(bookTitle)) {
                System.out.println(bookTitle + " is issued");
                System.arraycopy(books, i + 1, books, i, bookCount - i - 1);
                bookCount--;
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println(bookTitle + " is not available");
        }
    }

    public void returnBooks(String bookTitle) {
        if (bookCount < MAX_BOOKS) {
            books[bookCount] = bookTitle;
            bookCount++;
            System.out.println(bookTitle + " is returned");
        } else {
            System.out.println("Library can't accept book at this time");
        }
    }

    public void showAvailableBooks() {
        System.out.println("Available Books:");
        if (bookCount == 0) {
            System.out.println("No book is available at this time");
        }
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }

    public void isBookAvailable(String bookTitle) {
        for(int i = 0; i < bookCount; i++) {
            if (books[i].equalsIgnoreCase(bookTitle)) {
                System.out.println(bookTitle + " is available");
                return;
            }
        }
        System.out.println(bookTitle + " is not available");

    }
}

public class OnlineLibrary {
    public static void main(String[] args) {
        Library b1 = new Library();
        b1.addBook("The Alchemist");
        b1.addBook("The 48 Laws of Power");
        b1.addBook("Think and Grow Rich");
        b1.addBook("Rich Dad Poor Dad");
        b1.addBook("The ONE Thing");
        b1.addBook("The Psychology of Money");
        b1.addBook("Deep Work");
        b1.addBook("The 7 Habits Of Highly Effective People");

        b1.isBookAvailable("The 48 laws of power");

        b1.issueBook("The 48 laws of power");
         b1.showAvailableBooks();

         b1.returnBooks("The 48 laws of Power");

         b1.showAvailableBooks();
    }
}
