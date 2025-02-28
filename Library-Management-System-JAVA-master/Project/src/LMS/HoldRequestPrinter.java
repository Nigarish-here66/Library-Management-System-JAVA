package LMS;

public class HoldRequestPrinter {

    /**
     * Prints the details of a HoldRequest.
     * 
     * @param holdRequest The hold request to be printed.
     */
    public static void print(HoldRequest holdRequest) {
        System.out.println(holdRequest.getBook().getTitle() + "\t\t"
                + holdRequest.getBorrower().getName() + "\t\t"
                + holdRequest.getRequestDate());
    }
}
