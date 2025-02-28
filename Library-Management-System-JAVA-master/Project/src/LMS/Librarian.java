package LMS;

public class Librarian extends Staff {
    private int officeNo;
    private static int currentOfficeNumber = 0;

    public Librarian(int id, String n, String a, int p, double s, int of) {
        super(id, n, a, p, s);
        if (of == -1) {
            this.officeNo = currentOfficeNumber;
        } else {
            this.officeNo = of;
        }
        currentOfficeNumber++;
    }

    // Getter for office number
    public int getOfficeNo() {
        return officeNo;
    }
}
