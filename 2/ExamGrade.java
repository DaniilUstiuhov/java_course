public class ExamGrade {
    public static void main(String[] args) {
        System.out.println(getGrade(95));
        System.out.println(getGrade(82));
        System.out.println(getGrade(40));
    }

    static String getGrade(int score) {
        if (score < 0 || score > 100) return "Invalid score";
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        if (score >= 50) return "E";
        return "F";
    }
}
