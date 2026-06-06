public class CurrencyRates {
    public static void main(String[] args) {
        System.out.println(convertFromEuro(100.0, "GBP"));
        System.out.println(convertFromEuro(100.0, "PLN"));
        System.out.println(convertToEuro(100.0, "SEK"));
        System.out.println(convertToEuro(100.0, "CHF"));
    }

    // convert euros to another European currency
    static double convertFromEuro(double amount, String currency) {
        double rate = switch (currency.toUpperCase()) {
            case "GBP" -> 0.86;
            case "CHF" -> 0.96;
            case "SEK" -> 11.50;
            case "NOK" -> 11.80;
            case "DKK" -> 7.46;
            case "PLN" -> 4.27;
            case "HUF" -> 393.0;
            case "CZK" -> 25.30;
            case "RON" -> 4.97;
            default -> -1;
        };
        if (rate == -1) {
            System.out.println("Unknown currency: " + currency);
            return -1;
        }
        return amount * rate;
    }

    // convert another European currency to euros
    static double convertToEuro(double amount, String currency) {
        double rate = switch (currency.toUpperCase()) {
            case "GBP" -> 0.86;
            case "CHF" -> 0.96;
            case "SEK" -> 11.50;
            case "NOK" -> 11.80;
            case "DKK" -> 7.46;
            case "PLN" -> 4.27;
            case "HUF" -> 393.0;
            case "CZK" -> 25.30;
            case "RON" -> 4.97;
            default -> -1;
        };
        if (rate == -1) {
            System.out.println("Unknown currency: " + currency);
            return -1;
        }
        return amount / rate;
    }
}
