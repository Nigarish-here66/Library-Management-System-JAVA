package LMS;

import java.util.ArrayList;

public class Borrower extends Person {
    private ArrayList<Loan> borrowedBooks;
    private ArrayList<HoldRequest> onHoldBooks;

    public Borrower(int id, String name, String address, int phoneNum) {
        super(id, name, address, phoneNum);
        this.borrowedBooks = new ArrayList<>();
        this.onHoldBooks = new ArrayList<>();
    }

    // Getters and Setters (Only for Data Access)
    public ArrayList<Loan> getBorrowedBooks() {
        return borrowedBooks;
    }

    public ArrayList<HoldRequest> getOnHoldBooks() {
        return onHoldBooks;
    }

    public void addBorrowedBook(Loan loan) {
        borrowedBooks.add(loan);
    }

    public void removeBorrowedBook(Loan loan) {
        borrowedBooks.remove(loan);
    }

    public void addHoldRequest(HoldRequest hr) {
        onHoldBooks.add(hr);
    }

    public void removeHoldRequest(HoldRequest hr) {
        onHoldBooks.remove(hr);
    }
}
