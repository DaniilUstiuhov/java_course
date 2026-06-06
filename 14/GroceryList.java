import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> groceries = new ArrayList<>();

        while (true) {
            printMenu();
            String input = scanner.nextLine().trim();

            switch (input) {
                case "0" -> {
                    System.out.println("Shutting down...");
                    scanner.close();
                    return;
                }
                case "1" -> {
                    System.out.print("Enter item(s) to add (comma delimited): ");
                    String[] items = scanner.nextLine().split(",");
                    for (String item : items) {
                        String trimmed = item.trim();
                        if (!trimmed.isEmpty()) {
                            groceries.add(trimmed);
                            System.out.println("Added: " + trimmed);
                        }
                    }
                }
                case "2" -> {
                    System.out.print("Enter item(s) to remove (comma delimited): ");
                    String[] items = scanner.nextLine().split(",");
                    for (String item : items) {
                        String trimmed = item.trim();
                        if (groceries.remove(trimmed)) {
                            System.out.println("Removed: " + trimmed);
                        } else {
                            System.out.println("Not found: " + trimmed);
                        }
                    }
                }
                default -> System.out.println("Invalid choice. Enter 0, 1 or 2.");
            }

            printList(groceries);
        }
    }

    static void printMenu() {
        System.out.println("\nAvailable actions:");
        System.out.println("0 - to shutdown");
        System.out.println("1 - to add item(s) to list (comma delimited list)");
        System.out.println("2 - to remove any items (comma delimited list)");
        System.out.print("Enter a number for which action you want to do: ");
    }

    static void printList(List<String> groceries) {
        if (groceries.isEmpty()) {
            System.out.println("Grocery list is empty.");
        } else {
            System.out.println("Current grocery list: " + groceries);
        }
    }
}
