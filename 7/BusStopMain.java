import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusStopMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Reading bus stops data...");
        List<BusStop> stops = readStops();

        System.out.println("Calculating distances between bus stops...");
        System.out.println("Checking if bus stops are in the same area...");
        System.out.println();

        for (int i = 0; i < 5; i++) {
            BusStop stop1 = getRandomStop(stops);
            BusStop stop2 = getRandomStop(stops);
            double distance = BusStop.getDistance(stop1, stop2);
            boolean sameArea = BusStop.isSameArea(stop1, stop2);
            System.out.printf("Distance between %s in %s and %s in %s is %.1f km%n",
                    stop1.name(), stop1.area(), stop2.name(), stop2.area(), distance);
            System.out.println("Are they in the same area? " + sameArea);
        }
    }

    static List<BusStop> readStops() throws Exception {
        List<BusStop> stops = new ArrayList<>();
        File file = new File("stops.txt");
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
        scanner.nextLine(); // skip header

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",", -1);
            if (parts.length <= 15) continue;
            String area = parts[15].trim();
            if (area.isEmpty()) continue;
            try {
                String id = parts[0];
                String name = parts[2];
                double lat = Double.parseDouble(parts[3]);
                double lon = Double.parseDouble(parts[4]);
                stops.add(new BusStop(id, name, lat, lon, area));
            } catch (NumberFormatException e) {
                // skip invalid rows
            }
        }

        scanner.close();
        return stops;
    }

    static BusStop getRandomStop(List<BusStop> stops) {
        int index = (int) (Math.random() * stops.size());
        return stops.get(index);
    }
}
