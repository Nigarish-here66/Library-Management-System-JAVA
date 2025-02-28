package LMS;

public class BookPrinter {
    public static void printBookInfo(Book book) {
        System.out.println(book.getTitle() + "\t\t" + book.getAuthor() + "\t\t" + book.getSubject());
    }

    public static void printHoldRequests(HoldRequestRepository holdRequestRepository) {
        if (!holdRequestRepository.getHoldRequests().isEmpty()) {
            System.out.println("\nHold Requests:");
            System.out.println("------------------------------------------------------------------");
            System.out.println("No.\tBook Title\tBorrower Name\tRequest Date");
            System.out.println("------------------------------------------------------------------");
            for (int i = 0; i < holdRequestRepository.getHoldRequests().size(); i++) {
                System.out.print(i + "-\t");
                // Use the HoldRequestPrinter to print each hold request.
                HoldRequestPrinter.print(holdRequestRepository.getHoldRequests().get(i));
            }
        } else {
            System.out.println("\nNo Hold Requests.");
        }
    }
}
