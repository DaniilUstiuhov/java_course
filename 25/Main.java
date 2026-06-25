import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course jac = new Course("JAC", "Java Advanced Class", 100);
        Course pbc = new Course("PBC", "Python Bootcamp", 50);
        Course cgj = new Course("CGJ", "Creating Games in Java"); // default lecture count

        // 5000 random students enrolled in jac and pbc
        var students = Stream.generate(() -> Student.getRandomStudent(jac, pbc))
                .limit(5000)
                .toList();

        // average % complete for JAC using reduce
        double avgJac = students.stream()
                .map(s -> s.getPercentComplete("JAC"))
                .reduce(0.0, (a, b) -> a + b) / students.size();
        System.out.printf("Average JAC complete:    %.2f%%%n", avgJac);

        // threshold = average * 1.25
        double threshold = avgJac * 1.25;
        System.out.printf("Threshold (avg * 1.25):  %.2f%%%n%n", threshold);

        // students who completed more than the threshold
        var topStudents = students.stream()
                .filter(s -> s.getPercentComplete("JAC") > threshold)
                .toList();
        System.out.println("Students above threshold: " + topStudents.size());

        // sort by longest enrolled who are still active, take 10
        var selected = topStudents.stream()
                .filter(s -> s.getMonthsSinceActive() < 12)
                .sorted(Comparator.comparingInt(Student::getYearsSinceEnrolled).reversed())
                .limit(10)
                .toList();

        System.out.println("\nTop 10 long-enrolled active students:");
        selected.forEach(s -> System.out.printf(
                "  id=%-5d enrolled=%d yrs  active=%2d months ago  JAC=%.1f%%%n",
                s.getStudentId(), s.getYearsSinceEnrolled(),
                s.getMonthsSinceActive(), s.getPercentComplete("JAC")));

        // add new course to the 10 selected students
        System.out.println("\nAdding '" + cgj.getTitle() + "' to selected students:");
        selected.forEach(s -> {
            s.addCourse(cgj);
            System.out.println("  Student " + s.getStudentId()
                    + " -> courses: " + s.getEngagementMap().keySet());
        });
    }
}
