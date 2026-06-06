public class CustomerMain {
    public static void main(String[] args) {
        Customer c1 = new Customer("Alice", 2000.0, "alice@example.com");
        Customer c2 = new Customer();
        Customer c3 = new Customer("Bob", "bob@example.com");

        System.out.println(c1.getName() + " | " + c1.getCreditLimit() + " | " + c1.getEmail());
        System.out.println(c2.getName() + " | " + c2.getCreditLimit() + " | " + c2.getEmail());
        System.out.println(c3.getName() + " | " + c3.getCreditLimit() + " | " + c3.getEmail());
    }
}
