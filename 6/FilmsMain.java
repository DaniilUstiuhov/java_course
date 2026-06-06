import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmsMain {
    public static void main(String[] args) throws Exception {
        List<Film> films = loadFilms();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== STUDIO GHIBLI FILMS ===");
            System.out.println("1. List all films");
            System.out.println("2. Search by title");
            System.out.println("3. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> listFilms(films, scanner);
                case "2" -> searchFilm(films, scanner);
                case "3" -> running = false;
            }
        }

        scanner.close();
    }

    static List<Film> loadFilms() throws Exception {
        List<Film> films = new ArrayList<>();
        File file = new File("./src/data.json");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\|");
            films.add(new Film(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
        }
        scanner.close();
        return films;
    }

    static void listFilms(List<Film> films, Scanner scanner) {
        System.out.println("\n--- ALL FILMS ---");
        for (int i = 0; i < films.size(); i++) {
            System.out.println((i + 1) + ". " + films.get(i).getTitle() + " (" + films.get(i).getReleaseDate() + ")");
        }
        System.out.print("\nEnter number to see details (or 0 to go back): ");
        String input = scanner.nextLine().trim();
        try {
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < films.size()) {
                printFilm(films.get(index));
            }
        } catch (NumberFormatException e) {
            // ignore invalid input
        }
    }

    static void searchFilm(List<Film> films, Scanner scanner) {
        System.out.print("Enter title: ");
        String query = scanner.nextLine().toLowerCase();
        for (Film film : films) {
            if (film.getTitle().toLowerCase().contains(query)) {
                printFilm(film);
                return;
            }
        }
        System.out.println("Film not found");
    }

    static void printFilm(Film film) {
        System.out.println("\nTitle:        " + film.getTitle());
        System.out.println("Director:     " + film.getDirector());
        System.out.println("Producer:     " + film.getProducer());
        System.out.println("Release date: " + film.getReleaseDate());
        System.out.println("Running time: " + film.getRunningTime() + " min");
        System.out.println("Description:  " + film.getDescription());
    }
}
