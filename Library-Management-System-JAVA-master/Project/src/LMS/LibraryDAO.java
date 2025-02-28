package LMS;

import java.io.IOException;
import java.sql.*;

public class LibraryDAO {

    // Returns a database connection
    public Connection getConnection() {
        try {
            String host = "jdbc:derby://localhost:1527/LMS";
            String user = "haris";
            String password = "123";
            return DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            System.out.println("Database connection error: " + ex.getMessage());
            return null;
        }
    }

    // Populates the Library from the database
    public void populateLibrary(Library library) throws SQLException, IOException {
        Connection con = getConnection();
        if (con == null)
            return;

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM BOOK");
        while (rs.next()) {
            String title = rs.getString("TITLE");
            String author = rs.getString("AUTHOR");
            String subject = rs.getString("SUBJECT");
            int id = rs.getInt("ID");
            boolean issued = rs.getBoolean("IS_ISSUED");
            Book b = new Book(id, title, subject, author, issued);
            library.addBook(b);
        }
        // Similar queries would populate persons and loans.
        con.close();
    }

    // Persists the Library data back to the database
    public void persistLibrary(Library library) throws SQLException {
        Connection con = getConnection();
        if (con == null)
            return;

        // For demonstration, we persist only books.
        String sql = "INSERT INTO BOOK (ID, TITLE, AUTHOR, SUBJECT, IS_ISSUED) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        for (Book b : library.getBooks()) {
            pstmt.setInt(1, b.getID());
            pstmt.setString(2, b.getTitle());
            pstmt.setString(3, b.getAuthor());
            pstmt.setString(4, b.getSubject());
            // pstmt.setBoolean(5, b.getIssuedStatus());
            pstmt.executeUpdate();
        }
        con.close();
    }
}
