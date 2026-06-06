import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printTitle();
            printMainMenu();
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> showLevel2(scanner, "THE DARK FOREST",
                        "You enter the dark forest. Strange sounds echo around you.\nA path splits ahead - left or right?");
                case "2" -> showLevel2(scanner, "THE ANCIENT RUINS",
                        "You discover ancient ruins covered in moss.\nA chest sits in the corner, locked with a strange symbol.");
                case "3" -> showLevel2(scanner, "THE MOUNTAIN PASS",
                        "The mountain wind cuts through your armor.\nYou spot a cave that might offer shelter.");
                case "4" -> showLevel2(scanner, "THE VILLAGE",
                        "A small village comes into view.\nThe locals look at you with a mix of hope and fear.");
                case "5" -> showLevel2(scanner, "THE RIVER CROSSING",
                        "A mighty river blocks your path.\nA rickety bridge sways in the wind.");
                case "Q", "q" -> { System.out.println("\nFarewell, brave adventurer!"); running = false; }
                // ignore any other input
            }
        }

        scanner.close();
    }

    static void printTitle() {
        System.out.println("\n================================");
        System.out.println("   LEGENDS OF THE LOST REALM   ");
        System.out.println("================================");
    }

    static void printMainMenu() {
        System.out.println("\nWhere do you go?");
        System.out.println("1. Enter the Dark Forest");
        System.out.println("2. Explore the Ancient Ruins");
        System.out.println("3. Cross the Mountain Pass");
        System.out.println("4. Visit the Village");
        System.out.println("5. Find the River Crossing");
        System.out.println("Q. Quit game");
        System.out.print("> ");
    }

    static void showLevel2(Scanner scanner, String location, String text) {
        System.out.println("\n--- " + location + " ---");
        System.out.println(text);
        System.out.println("\nPress Q to return to the main menu.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Q")) break;
            // ignore everything else
        }
    }
}
