public class ScoredStudent extends Student {
    private double percentComplete;

    public ScoredStudent(int studentId, String name, String course, int year, double percentComplete) {
        super(studentId, name, course, year);
        this.percentComplete = percentComplete;
    }

    public double getPercentComplete() { return percentComplete; }

    // percent field: match if student's percent <= submitted value
    @Override
    public boolean matchFieldValue(String field, String value) {
        if (field.equalsIgnoreCase("percentComplete")) {
            return percentComplete <= Double.parseDouble(value);
        }
        return super.matchFieldValue(field, value);
    }

    @Override
    public String toString() {
        return "ScoredStudent[id=%d, name=%-10s, course=%-12s, year=%d, percent=%5.1f%%]"
                .formatted(getStudentId(), getName(), getCourse(), getYear(), percentComplete);
    }
}
