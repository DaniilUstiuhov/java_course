public class LeapYear {
    public static void main(String[] args) {
        int year = 2024;
        if (isLeapYear(year)) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
    }

    static boolean isLeapYear(int year) {
        // divisible by 400 is always a leap year
        if (year % 400 == 0) return true;
        // divisible by 100 is not a leap year
        if (year % 100 == 0) return false;
        // divisible by 4 is a leap year
        return year % 4 == 0;
    }
}
