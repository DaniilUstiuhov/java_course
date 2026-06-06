public class Student implements Comparable<Student> {
    private int studentId;
    private String name;
    private String course;
    private int year;

    public Student(int studentId, String name, String course, int year) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    public int getStudentId() { return studentId; }
    public String getName()   { return name; }
    public String getCourse() { return course; }
    public int getYear()      { return year; }

    // returns true if the given field matches the given value
    public boolean matchFieldValue(String field, String value) {
        return switch (field.toLowerCase()) {
            case "course" -> course.equalsIgnoreCase(value);
            case "year"   -> year == Integer.parseInt(value);
            default       -> false;
        };
    }

    // natural order: by student id
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.studentId, other.studentId);
    }

    @Override
    public String toString() {
        return "Student[id=%d, name=%-10s, course=%-12s, year=%d]"
                .formatted(studentId, name, course, year);
    }
}
