import java.util.Comparator;

public class StudentMain {
    private static final String[] NAMES = {
        "Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Henry",
        "Iris", "Jack", "Kate", "Liam", "Mia", "Noah", "Olivia", "Paul",
        "Quinn", "Rose", "Sam", "Tina", "Uma", "Victor", "Wendy", "Xander", "Yara"
    };
    private static final String[] COURSES = {"Java", "Python", "C++", "Data Science", "Web Dev"};

    public static void main(String[] args) {
        QueryList<ScoredStudent> students = new QueryList<>();

        // generate 25 random students with unique shuffled ids
        int[] ids = new int[25];
        for (int i = 0; i < 25; i++) ids[i] = 1001 + i;
        for (int i = 24; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int tmp = ids[i]; ids[i] = ids[j]; ids[j] = tmp;
        }

        for (int i = 0; i < 25; i++) {
            String course  = COURSES[(int) (Math.random() * COURSES.length)];
            int year       = 1 + (int) (Math.random() * 4);
            double percent = Math.round(Math.random() * 100);
            students.add(new ScoredStudent(ids[i], NAMES[i], course, year, percent));
        }

        // select students with 50% or less complete
        QueryList<ScoredStudent> filtered = students.getStudentsByValue("percentComplete", "50");
        System.out.println("Students with <=50% complete: " + filtered.size());
        System.out.println();

        // sort 1: natural order (by student id)
        filtered.sort(Comparator.naturalOrder());
        System.out.println("--- Sorted by student id (natural order) ---");
        filtered.forEach(System.out::println);
        System.out.println();

        // sort 2: by course, then by student id
        filtered.sort(Comparator.comparing(Student::getCourse)
                                 .thenComparingInt(Student::getStudentId));
        System.out.println("--- Sorted by course, then student id ---");
        filtered.forEach(System.out::println);
    }
}
