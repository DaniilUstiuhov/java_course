import java.time.LocalDate;
import java.util.*;

public class Student {
    private static long nextId = 1;
    private static final Random random = new Random();

    private static final String[] COUNTRIES = {"US", "AU", "GB", "CA", "IN", "DE", "EE", "LV", "BR", "FR"};
    private static final String[] GENDERS   = {"M", "F"};

    private long studentId;
    private String countryCode;
    private int yearEnrolled;
    private int ageEnrolled;
    private String gender;
    private boolean programmingExperience;
    private Map<String, CourseEngagement> engagementMap = new HashMap<>();

    public Student(long studentId, String countryCode, int yearEnrolled,
                   int ageEnrolled, String gender, boolean programmingExperience) {
        this.studentId = studentId;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;
    }

    public long getStudentId()                               { return studentId; }
    public String getCountryCode()                           { return countryCode; }
    public int getYearEnrolled()                             { return yearEnrolled; }
    public int getAgeEnrolled()                              { return ageEnrolled; }
    public String getGender()                                { return gender; }
    public boolean hasProgrammingExperience()                { return programmingExperience; }
    public Map<String, CourseEngagement> getEngagementMap()  { return engagementMap; }

    public int getAge()               { return ageEnrolled + getYearsSinceEnrolled(); }
    public int getYearsSinceEnrolled(){ return LocalDate.now().getYear() - yearEnrolled; }

    public int getMonthsSinceActive(String courseCode) {
        CourseEngagement ce = engagementMap.get(courseCode);
        return ce == null ? -1 : ce.getMonthsSinceActive();
    }

    // minimum months since active across all courses
    public int getMonthsSinceActive() {
        return engagementMap.values().stream()
                .mapToInt(CourseEngagement::getMonthsSinceActive)
                .min().orElse(-1);
    }

    public double getPercentComplete(String courseCode) {
        CourseEngagement ce = engagementMap.get(courseCode);
        return ce == null ? 0.0 : ce.getPercentComplete();
    }

    public void addCourse(Course course) {
        addCourse(course, LocalDate.now());
    }

    public void addCourse(Course course, LocalDate enrollDate) {
        engagementMap.putIfAbsent(course.getCourseCode(),
                new CourseEngagement(course, enrollDate, "Enrolled"));
    }

    public void watchLecture(String courseCode, int lectureNumber, int year, int month) {
        CourseEngagement ce = engagementMap.get(courseCode);
        if (ce != null) ce.watchLecture(lectureNumber, LocalDate.of(year, month, 1));
    }

    @Override
    public String toString() {
        return "Student[id=%d, %s, %s, age=%d, enrolled=%d, active=%d months ago, exp=%b]"
                .formatted(studentId, countryCode, gender, getAge(),
                           yearEnrolled, getMonthsSinceActive(), programmingExperience);
    }

    public static Student getRandomStudent(Course... courses) {
        long id        = nextId++;
        String country = COUNTRIES[random.nextInt(COUNTRIES.length)];
        int year       = 2015 + random.nextInt(9);   // 2015-2023
        int age        = 18   + random.nextInt(50);  // 18-67
        String gender  = GENDERS[random.nextInt(2)];
        boolean exp    = random.nextBoolean();

        Student student = new Student(id, country, year, age, gender, exp);

        for (Course course : courses) {
            int enrollYear  = 2015 + random.nextInt(9);
            int enrollMonth = 1 + random.nextInt(12);
            LocalDate enrollDate = LocalDate.of(enrollYear, enrollMonth, 1);
            student.addCourse(course, enrollDate);

            // activity date spread between enrollment and current year
            int yearRange    = Math.max(1, 2026 - enrollDate.getYear() + 1);
            int activityYear = enrollDate.getYear() + random.nextInt(yearRange);
            int activityMonth = 1 + random.nextInt(12);
            if (activityYear == enrollDate.getYear() && activityMonth < enrollDate.getMonthValue())
                activityMonth = enrollDate.getMonthValue();

            // cap activity date to current month
            LocalDate activityDate = LocalDate.of(activityYear, activityMonth, 1);
            if (activityDate.isAfter(LocalDate.now()))
                activityDate = LocalDate.now().withDayOfMonth(1);

            int lecture = 1 + random.nextInt(course.getLectureCount());
            student.watchLecture(course.getCourseCode(), lecture,
                    activityDate.getYear(), activityDate.getMonthValue());
        }

        return student;
    }
}
