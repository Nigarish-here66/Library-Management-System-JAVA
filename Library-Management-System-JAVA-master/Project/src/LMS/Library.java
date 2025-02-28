package LMS;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private Librarian librarian;
    private List<Person> persons;
    private List<Book> books;
    private List<Loan> loans;
    private int bookReturnDeadline;
    private double perDayFine;
    private int holdRequestExpiry;

    // Singleton instance
    private static Library instance = null;

    private Library() {
        this.name = "";
        this.librarian = null;
        this.persons = new ArrayList<>();
        this.books = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public int getBookReturnDeadline() {
        return bookReturnDeadline;
    }

    public void setBookReturnDeadline(int deadline) {
        this.bookReturnDeadline = deadline;
    }

    public double getPerDayFine() {
        return perDayFine;
    }

    public void setPerDayFine(double perDayFine) {
        this.perDayFine = perDayFine;
    }

    public int getHoldRequestExpiry() {
        return holdRequestExpiry;
    }

    public void setHoldRequestExpiry(int holdRequestExpiry) {
        this.holdRequestExpiry = holdRequestExpiry;
    }

    // Methods to add items to collections
    public void addPerson(Person p) {
        persons.add(p);
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void addLoan(Loan l) {
        loans.add(l);
    }
}
