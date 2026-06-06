public class EstonianIdCode {
    public static void main(String[] args) {
        String idCode = "49403136515";
        if (isValidIdCode(idCode)) {
            System.out.println(idCode + " is valid");
        } else {
            System.out.println(idCode + " is not valid");
        }
    }

    static boolean isValidIdCode(String idCode) {
        // must be exactly 11 digits
        if (idCode == null || idCode.length() != 11) return false;
        if (!idCode.matches("\\d+")) return false;

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = idCode.charAt(i) - '0';
        }

        // first digit must be 1-6
        int g = digits[0];
        if (g < 1 || g > 6) return false;

        // validate date
        if (!isValidDate(digits)) return false;

        // validate checksum
        return isValidChecksum(digits);
    }

    static boolean isValidDate(int[] digits) {
        int g = digits[0];
        int year = digits[1] * 10 + digits[2];
        int month = digits[3] * 10 + digits[4];
        int day = digits[5] * 10 + digits[6];

        // determine full year based on gender/century digit
        int fullYear;
        if (g == 1 || g == 2) fullYear = 1800 + year;
        else if (g == 3 || g == 4) fullYear = 1900 + year;
        else fullYear = 2000 + year;

        if (month < 1 || month > 12) return false;

        // days in each month
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(fullYear)) daysInMonth[1] = 29;

        return day >= 1 && day <= daysInMonth[month - 1];
    }

    static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    static boolean isValidChecksum(int[] digits) {
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        int[] weights2 = {3, 4, 5, 6, 7, 8, 9, 1, 2, 3};

        // first round
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * weights1[i];
        }
        int checksum = sum % 11;

        if (checksum < 10) {
            return checksum == digits[10];
        }

        // second round
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * weights2[i];
        }
        checksum = sum % 11;

        if (checksum < 10) {
            return checksum == digits[10];
        }

        // if still >= 10, checksum is 0
        return digits[10] == 0;
    }
}
