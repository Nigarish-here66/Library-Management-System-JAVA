package LMS;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    // Finds a borrower by ID
    public Borrower findBorrower(Library library, int id) {
        for (Person p : library.getPersons()) {
            if (p instanceof Borrower && p.getID() == id) {
                return (Borrower) p;
            }
        }
        return null;
    }

    // Finds a clerk by ID
    public Clerk findClerk(Library library, int id) {
        for (Person p : library.getPersons()) {
            if (p instanceof Clerk && p.getID() == id) {
                return (Clerk) p;
            }
        }
        return null;
    }

    // Searches for books based on search type (1: title, 2: subject, 3: author)
    public List<Book> searchBooks(Library library, int searchType, String query) {
        List<Book> matchedBooks = new ArrayList<>();
        for (Book b : library.getBooks()) {
            if (searchType == 1 && b.getTitle().equalsIgnoreCase(query)) {
                matchedBooks.add(b);
            } else if (searchType == 2 && b.getSubject().equalsIgnoreCase(query)) {
                matchedBooks.add(b);
            } else if (searchType == 3 && b.getAuthor().equalsIgnoreCase(query)) {
                matchedBooks.add(b);
            }
        }
        return matchedBooks;
    }

    // public double computeTotalFine(Library library, Borrower borrower) {
    // double totalFine = 0.0;
    // for (Loan loan : library.getLoans()) {
    // if (loan.getBorrower().equals(borrower)) {
    // totalFine += loan.computeFine(); // Ensure computeFine() exists in Loan
    // }
    // }
    // return totalFine;
    // }

}
