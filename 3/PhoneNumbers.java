public class PhoneNumbers {
    public static void main(String[] args) {
        System.out.println(getCountry("+37212345678"));
        System.out.println(getCountry("+44207123456"));
        System.out.println(getCountry(37212345678L));
        System.out.println(getCountry(49301234567L));
    }

    // String version
    static String getCountry(String phoneNumber) {
        String normalized = phoneNumber.startsWith("+") ? phoneNumber.substring(1) : phoneNumber;
        String three = normalized.substring(0, Math.min(3, normalized.length()));
        String two = normalized.substring(0, Math.min(2, normalized.length()));
        String one = normalized.substring(0, Math.min(1, normalized.length()));

        return switch (three) {
            case "372" -> "Estonia";
            case "371" -> "Latvia";
            case "370" -> "Lithuania";
            case "358" -> "Finland";
            case "380" -> "Ukraine";
            default -> switch (two) {
                case "46" -> "Sweden";
                case "49" -> "Germany";
                case "48" -> "Poland";
                case "44" -> "United Kingdom";
                default -> switch (one) {
                    case "7" -> "Russia";
                    default -> "Unknown country";
                };
            };
        };
    }

    // Long version
    static String getCountry(Long phoneNumber) {
        return getCountry(String.valueOf(phoneNumber));
    }
}
