package LMS;

public class LibrarianService {
    private Library library;

    public LibrarianService(Library library) {
        this.library = library;
    }

    /**
     * Adds a librarian to the library if one is not already present.
     * 
     * @param lib The librarian to add.
     * @return true if the librarian was added successfully; false otherwise.
     */
    public boolean addLibrarian(Librarian lib) {
        if (library.getLibrarian() == null) {
            library.setLibrarian(lib);
            library.getPersons().add(lib);
            return true;
        } else {
            System.out.println("\nSorry, the library already has one librarian. New Librarian can't be created.");
            return false;
        }
    }
}
