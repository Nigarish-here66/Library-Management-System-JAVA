package LMS;

public abstract class Person {
    protected int id; // Unique ID for the person
    protected String password; // Password for the person
    protected String name; // Person's name
    protected String address; // Person's address
    protected int phoneNo; // Person's phone number

    static int currentIdNumber = 0; // Unique ID counter

    // Constructor initializes the person data.
    public Person(int idNum, String name, String address, int phoneNum) {
        currentIdNumber++;

        // If idNum is -1, assign a new unique id; otherwise use the given id.
        if (idNum == -1) {
            this.id = currentIdNumber;
        } else {
            this.id = idNum;
        }

        // For simplicity, we generate a default password using the id.
        this.password = Integer.toString(this.id);
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNum;
    }

    // Setter methods (for updating the data)
    public void setAddress(String a) {
        address = a;
    }

    public void setPhone(int p) {
        phoneNo = p;
    }

    public void setName(String n) {
        name = n;
    }

    // Getter methods (for accessing the data)
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNo;
    }

    public int getID() {
        return id;
    }

    public static void setIDCount(int n) {
        currentIdNumber = n;
    }
}
