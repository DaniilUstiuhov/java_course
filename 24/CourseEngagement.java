import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class CourseEngagement {
    private Course course;
    private LocalDate enrollmentDate;
    private String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    public CourseEngagement(Course course, LocalDate enrollmentDate, String engagementType) {
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.engagementType = engagementType;
        this.lastActivityDate = enrollmentDate;
        this.lastLecture = 0;
    }

    public String getCourseCode()    { return course.getCourseCode(); }
    public int getEnrollmentYear()   { return enrollmentDate.getYear(); }
    public int getLastActivityYear() { return lastActivityDate.getYear(); }

    public String getLastActivityMonth() {
        return lastActivityDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public int getMonthsSinceActive() {
        return (int) ChronoUnit.MONTHS.between(lastActivityDate, LocalDate.now());
    }

    public double getPercentComplete() {
        return (lastLecture * 100.0) / course.getLectureCount();
    }

    public void watchLecture(int lecture, LocalDate date) {
        if (lecture > lastLecture) lastLecture = lecture;
        if (date.isAfter(lastActivityDate)) lastActivityDate = date;
        engagementType = "Lecture";
    }

    public Course getCourse()              { return course; }
    public LocalDate getEnrollmentDate()   { return enrollmentDate; }
    public String getEngagementType()      { return engagementType; }
    public int getLastLecture()            { return lastLecture; }
    public LocalDate getLastActivityDate() { return lastActivityDate; }

    @Override
    public String toString() {
        return "%s: %s, enrolled %d, last %s %d (%.1f%% done)".formatted(
                getCourseCode(), engagementType, getEnrollmentYear(),
                getLastActivityMonth(), getLastActivityYear(), getPercentComplete());
    }
}
