import java.util.Scanner;

public class InvalidNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;

        while (count < 5) {
            System.out.print("Enter number #" + (count + 1) + ": ");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                sum += number;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }

        System.out.println("Sum = " + sum);
        scanner.close();
    }
}
