package LMS;

public class Staff extends Person {
    private double salary;

    public Staff(int id, String name, String address, int phone, double salary) {
        super(id, name, address, phone);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    // Additional business methods for Staff (if needed) go here.
}
