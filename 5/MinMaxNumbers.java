import java.util.Scanner;

public class MinMaxNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        boolean hasNumbers = false;

        while (true) {
            System.out.print("Enter a number (or any character to quit): ");
            String input = scanner.nextLine();

            try {
                double number = Double.parseDouble(input);
                hasNumbers = true;
                if (number < min) min = number;
                if (number > max) max = number;
            } catch (NumberFormatException e) {
                break;
            }
        }

        if (hasNumbers) {
            System.out.println("Min = " + min + ", Max = " + max);
        } else {
            System.out.println("No numbers were entered");
        }

        scanner.close();
    }
}
