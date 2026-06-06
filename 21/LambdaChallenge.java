import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LambdaChallenge {
    public static void main(String[] args) {
        // Anna and Bob are palindromes (same forwards and backwards)
        String[] names = {"Anna", "Bob", "Charlie", "Alice", "Hannah", "Frank", "Grace"};

        List<String> namesList = Arrays.asList(names);

        // 1. transform to uppercase
        namesList.replaceAll(String::toUpperCase);
        System.out.println("Uppercase:");
        namesList.forEach(n -> System.out.println("  " + n));

        // 2. add random middle initial
        Random random = new Random(42); // fixed seed for reproducible output
        namesList.replaceAll(n -> n + " " + (char)('A' + random.nextInt(26)) + ".");
        System.out.println("\nWith middle initial:");
        namesList.forEach(n -> System.out.println("  " + n));

        // 3. add last name = reverse of the first name
        namesList.replaceAll(n -> {
            String first = n.split(" ")[0];
            return n + " " + new StringBuilder(first).reverse();
        });
        System.out.println("\nWith reversed last name:");
        namesList.forEach(n -> System.out.println("  " + n));

        // create new modifiable ArrayList from the array
        ArrayList<String> filtered = new ArrayList<>(List.of(names));

        // remove names where first name == last name (palindromes)
        filtered.removeIf(n -> {
            String[] parts = n.split(" ");
            return parts[0].equals(parts[parts.length - 1]);
        });
        System.out.println("\nAfter removing palindromes:");
        filtered.forEach(n -> System.out.println("  " + n));
    }
}
