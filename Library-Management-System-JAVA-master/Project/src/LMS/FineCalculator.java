package LMS;

import java.time.temporal.ChronoUnit;
import java.util.Date;

public class FineCalculator {

    /**
     * Computes the fine for the given loan.
     * 
     * @param loan               The loan for which to compute the fine.
     * @param bookReturnDeadline Allowed number of days before fine applies.
     * @param perDayFine         Fine amount per overdue day.
     * @return The total fine.
     */
    public double computeFine(Loan loan, int bookReturnDeadline, double perDayFine) {
        // Use the return date if available; otherwise, use current date.
        Date issuedDate = loan.getIssuedDate();
        Date returnDate = loan.getDateReturned() != null ? loan.getDateReturned() : new Date();

        long totalDays = ChronoUnit.DAYS.between(issuedDate.toInstant(), returnDate.toInstant());
        long overdueDays = totalDays - bookReturnDeadline;
        if (overdueDays > 0) {
            return overdueDays * perDayFine;
        }
        return 0.0;
    }
}
