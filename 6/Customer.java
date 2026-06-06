public class Customer {
    private String name;
    private double creditLimit;
    private String email;

    // all-args constructor
    public Customer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    // no-args constructor
    public Customer() {
        this("Unknown", 500.0, "unknown@email.com");
    }

    // name and email constructor
    public Customer(String name, String email) {
        this(name, 1000.0, email);
    }

    public String getName() { return name; }
    public double getCreditLimit() { return creditLimit; }
    public String getEmail() { return email; }
}
