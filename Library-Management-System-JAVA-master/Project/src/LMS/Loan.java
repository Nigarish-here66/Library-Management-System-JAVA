package LMS;

import java.util.Date;

public class Loan {
    private Borrower borrower;
    private Book book;
    private Staff issuer;
    private Date issuedDate;
    private Date dateReturned;
    private Staff receiver;
    private boolean finePaid;

    public Loan(Borrower borrower, Book book, Staff issuer, Staff receiver, Date issuedDate, Date dateReturned,
            boolean finePaid) {
        this.borrower = borrower;
        this.book = book;
        this.issuer = issuer;
        this.receiver = receiver;
        this.issuedDate = issuedDate;
        this.dateReturned = dateReturned;
        this.finePaid = finePaid;
    }

    // Getters and setters
    public Borrower getBorrower() {
        return borrower;
    }

    public Book getBook() {
        return book;
    }

    public Staff getIssuer() {
        return issuer;
    }

    public Staff getReceiver() {
        return receiver;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public boolean isFinePaid() {
        return finePaid;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public void setReceiver(Staff receiver) {
        this.receiver = receiver;
    }

    public void setFinePaid(boolean finePaid) {
        this.finePaid = finePaid;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

}
