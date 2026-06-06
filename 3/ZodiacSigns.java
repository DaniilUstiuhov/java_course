import java.time.LocalDate;

public class ZodiacSigns {
    public static void main(String[] args) {
        System.out.println(getZodiacSign(3, 25));
        System.out.println(getZodiacSign("25.03"));
        System.out.println(getZodiacSign(LocalDate.of(2000, 3, 25)));
    }

    // version 1: month and day as ints
    static String getZodiacSign(int month, int day) {
        return switch (month) {
            case 1  -> day <= 19 ? "Capricorn" : "Aquarius";
            case 2  -> day <= 18 ? "Aquarius"  : "Pisces";
            case 3  -> day <= 20 ? "Pisces"    : "Aries";
            case 4  -> day <= 19 ? "Aries"     : "Taurus";
            case 5  -> day <= 20 ? "Taurus"    : "Gemini";
            case 6  -> day <= 20 ? "Gemini"    : "Cancer";
            case 7  -> day <= 22 ? "Cancer"    : "Leo";
            case 8  -> day <= 22 ? "Leo"       : "Virgo";
            case 9  -> day <= 22 ? "Virgo"     : "Libra";
            case 10 -> day <= 22 ? "Libra"     : "Scorpio";
            case 11 -> day <= 21 ? "Scorpio"   : "Sagittarius";
            case 12 -> day <= 21 ? "Sagittarius" : "Capricorn";
            default -> "Invalid date";
        };
    }

    // version 2: date as String "DD.MM"
    static String getZodiacSign(String date) {
        String[] parts = date.split("\\.");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        return getZodiacSign(month, day);
    }

    // version 3: LocalDate
    static String getZodiacSign(LocalDate date) {
        return getZodiacSign(date.getMonthValue(), date.getDayOfMonth());
    }
}
