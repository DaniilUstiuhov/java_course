public class Course {
    private final String courseCode;
    private final String title;
    private final int lectureCount;

    public Course(String courseCode, String title, int lectureCount) {
        this.courseCode = courseCode;
        this.title = title;
        this.lectureCount = lectureCount;
    }

    // constructor without lecture count — defaults to 30
    public Course(String courseCode, String title) {
        this(courseCode, title, 30);
    }

    public String getCourseCode()  { return courseCode; }
    public String getTitle()       { return title; }
    public int getLectureCount()   { return lectureCount; }

    @Override
    public String toString() {
        return courseCode + ": " + title + " (" + lectureCount + " lectures)";
    }
}
