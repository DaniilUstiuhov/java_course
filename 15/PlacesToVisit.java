import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlacesToVisit {
    public static void main(String[] args) {
        LinkedList<Place> itinerary = new LinkedList<>();

        // add places ordered by distance from Tallinn (no duplicates)
        addInOrder(itinerary, new Place("Tallinn", 0));
        addInOrder(itinerary, new Place("Pärnu", 127));
        addInOrder(itinerary, new Place("Viljandi", 147));
        addInOrder(itinerary, new Place("Tartu", 179));
        addInOrder(itinerary, new Place("Põlva", 224));
        addInOrder(itinerary, new Place("Võru", 246));

        Scanner scanner = new Scanner(System.in);
        ListIterator<Place> iter = itinerary.listIterator();
        boolean goingForward = true;

        printMenu();

        while (true) {
            System.out.print("\nEnter choice: ");
            String input = scanner.nextLine().trim().toUpperCase();

            switch (input) {
                case "F", "FORWARD" -> {
                    if (!goingForward) {
                        // switching direction: call next() once to compensate cursor
                        goingForward = true;
                        if (iter.hasNext()) iter.next();
                    }
                    if (iter.hasNext()) {
                        System.out.println("Moving forward to: " + iter.next());
                    } else {
                        System.out.println("No more places ahead.");
                    }
                }
                case "B", "BACKWARD" -> {
                    if (goingForward) {
                        // switching direction: call previous() once to compensate cursor
                        goingForward = false;
                        if (iter.hasPrevious()) iter.previous();
                    }
                    if (iter.hasPrevious()) {
                        System.out.println("Moving backward to: " + iter.previous());
                    } else {
                        System.out.println("No more places behind.");
                    }
                }
                case "L", "LIST PLACES" -> listPlaces(itinerary);
                case "M", "MENU"        -> printMenu();
                case "Q", "QUIT"        -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // insert place in order by distance, skip if duplicate
    static void addInOrder(LinkedList<Place> list, Place place) {
        for (Place p : list) {
            if (p.town().equalsIgnoreCase(place.town())) {
                System.out.println("Duplicate skipped: " + place.town());
                return;
            }
        }
        ListIterator<Place> iter = list.listIterator();
        while (iter.hasNext()) {
            if (iter.next().distance() > place.distance()) {
                iter.previous();
                iter.add(place);
                return;
            }
        }
        list.add(place);
    }

    static void printMenu() {
        System.out.println("\nAvailable actions (select word or letter):");
        System.out.println("(F)orward");
        System.out.println("(B)ackward");
        System.out.println("(L)ist Places");
        System.out.println("(M)enu");
        System.out.println("(Q)uit");
    }

    static void listPlaces(LinkedList<Place> itinerary) {
        System.out.println("\nPlaces to visit:");
        for (Place p : itinerary) {
            System.out.println("  " + p);
        }
    }
}
