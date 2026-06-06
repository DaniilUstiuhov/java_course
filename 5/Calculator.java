import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        calculate();
    }

    static void calculate() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        while (true) {
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                sum += number;
                count++;
            } catch (NumberFormatException e) {
                break;
            }
        }

        double avg = count > 0 ? (double) sum / count : 0;
        System.out.printf("SUM = %d AVG = %.1f%n", sum, avg);
        scanner.close();
    }
}
