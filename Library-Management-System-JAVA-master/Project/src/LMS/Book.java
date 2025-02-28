package LMS;

public class Book {
    private int bookID;
    private String title;
    private String subject;
    private String author;
    private boolean isIssued;

    private static int currentIdNumber = 0;

    public Book(int id, String title, String subject, String author, boolean issued) {
        currentIdNumber++;
        this.bookID = (id == -1) ? currentIdNumber : id;
        this.title = title;
        this.subject = subject;
        this.author = author;
        this.isIssued = issued;
    }

    // Getters and setters (Only data handling, no operations)
    public int getID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }

    public static void setIDCount(int n) {
        currentIdNumber = n;
    }
}
