public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountNumber("ACC-001");
        account.setCustomerName("John Doe");
        account.setEmail("john@example.com");
        account.setPhoneNumber("+1234567890");
        account.setBalance(1000.0);

        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(2000.0);
    }
}
