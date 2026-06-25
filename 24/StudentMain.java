import java.util.stream.Stream;

public class StudentMain {
    public static void main(String[] args) {
        Course java   = new Course("JMC",  "Java Masterclass",  100);
        Course python = new Course("PYC",  "Python Masterclass", 80);
        Course web    = new Course("WDEV", "Web Development",    60);

        // generate 1000 random students using factory method as supplier
        var students = Stream.generate(() -> Student.getRandomStudent(java, python, web))
                .limit(1000)
                .toList();

        // how many male and female students
        System.out.println("=== Gender ===");
        long male = students.stream().filter(s -> s.getGender().equals("M")).count();
        System.out.println("Male:   " + male);
        System.out.println("Female: " + (students.size() - male));

        // age ranges
        System.out.println("\n=== Age Ranges ===");
        System.out.println("Under 30: " + students.stream().filter(s -> s.getAge() < 30).count());
        System.out.println("30-40:    " + students.stream().filter(s -> s.getAge() >= 30 && s.getAge() <= 40).count());
        System.out.println("Over 40:  " + students.stream().filter(s -> s.getAge() > 40).count());

        // age summary statistics
        System.out.println("\n=== Age Statistics ===");
        System.out.println(students.stream().mapToInt(Student::getAge).summaryStatistics());

        // distinct country codes
        System.out.println("\n=== Countries ===");
        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // any students still active and enrolled more than 7 years?
        boolean anyLongActive = students.stream()
                .anyMatch(s -> s.getYearsSinceEnrolled() > 7 && s.getMonthsSinceActive() < 12);
        System.out.println("\n=== Active & enrolled >7 years ===");
        System.out.println("Exists: " + anyLongActive);

        // print 5 such students
        System.out.println("\n5 students active & enrolled >7 years:");
        students.stream()
                .filter(s -> s.getYearsSinceEnrolled() > 7 && s.getMonthsSinceActive() < 12)
                .limit(5)
                .forEach(System.out::println);
    }
}
