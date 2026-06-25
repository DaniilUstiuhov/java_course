import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course jac = new Course("JAC", "Java Advanced Class",      100);
        Course pbc = new Course("PBC", "Python Bootcamp",           50);
        Course cgj = new Course("CGJ", "Creating Games in Java",    45);
        Course jse = new Course("JSE", "JavaScript Essentials",     60);

        // 10,000 students enrolled in the past 4 years
        var students = Stream.generate(() -> Student.getRandomStudent(jac, pbc, cgj, jse))
                .limit(10_000)
                .toList();

        // 1. how many students are enrolled in each course
        System.out.println("=== Students per course ===");
        students.stream()
                .flatMap(s -> s.getEngagementMap().keySet().stream())
                .collect(Collectors.groupingBy(code -> code, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println("  " + e.getKey() + ": " + e.getValue()));

        // 2. how many students are taking 1, 2, 3, or 4 courses
        System.out.println("\n=== Students by number of courses ===");
        students.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getEngagementMap().size(),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println("  " + e.getKey() + " course(s): " + e.getValue()));

        // 3. average % complete per course using Collectors.averagingDouble
        System.out.println("\n=== Average % complete per course ===");
        students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,
                        Collectors.averagingDouble(CourseEngagement::getPercentComplete)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("  %s: %.2f%%%n", e.getKey(), e.getValue()));

        // 4. activity counts by year per course
        System.out.println("\n=== Activity count by year per course ===");
        students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,
                        Collectors.groupingBy(
                                CourseEngagement::getLastActivityYear,
                                Collectors.counting())))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    System.out.println("  " + e.getKey() + ":");
                    e.getValue().entrySet().stream()
                            .sorted(Map.Entry.comparingByKey())
                            .forEach(y -> System.out.println("    " + y.getKey() + ": " + y.getValue()));
                });
    }
}
