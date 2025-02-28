package LMS;

import java.util.Date;
import java.util.Scanner;

public class BookService {
    // Use an instance of HoldRequestRepository instead of static calls.
    private HoldRequestRepository holdRequestRepository = new HoldRequestRepository();

    // Issue a book
    public void issueBook(Book book, Borrower borrower, Staff staff) {
        if (book.isIssued()) {
            System.out.println("\nThe book " + book.getTitle() + " is already issued.");
            System.out.println("Would you like to place a hold request? (y/n)");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            if (choice.equals("y")) {
                makeHoldRequest(book, borrower);
            }
            return;
        }

        // Process Hold Requests
        if (!holdRequestRepository.getHoldRequests().isEmpty()) {
            if (holdRequestRepository.getHoldRequests().get(0).getBorrower() != borrower) {
                System.out.println("\nSorry, another user has requested this book earlier.");
                return;
            } else {
                serviceHoldRequest(holdRequestRepository.getHoldRequests().get(0));
            }
        }

        // Issue the book
        book.setIssued(true);
        Loan loan = new Loan(borrower, book, staff, null, new Date(), null, false);
        Library.getInstance().addLoan(loan);
        borrower.addBorrowedBook(loan);
        System.out.println("\nThe book " + book.getTitle() + " is successfully issued to " + borrower.getName() + ".");
    }

    // Handle hold request
    public void makeHoldRequest(Book book, Borrower borrower) {
        HoldRequest hr = new HoldRequest(borrower, book, new Date());
        holdRequestRepository.addHoldRequest(hr);
        borrower.addHoldRequest(hr);
        System.out.println("\nThe book " + book.getTitle() + " has been placed on hold by " + borrower.getName());
    }

    // Service a hold request
    public void serviceHoldRequest(HoldRequest hr) {
        holdRequestRepository.removeHoldRequest(hr);
        hr.getBorrower().removeHoldRequest(hr);
    }

    public void returnBook(Book book, Borrower borrower, Loan loan, Staff staff) {
        book.setIssued(false);
        loan.setDateReturned(new Date());
        loan.setReceiver(staff);
        borrower.removeBorrowedBook(loan);
        // Loan.renewLoan();
        System.out.println("\nThe book " + book.getTitle() + " has been returned by "
                + borrower.getName());
    }
}
