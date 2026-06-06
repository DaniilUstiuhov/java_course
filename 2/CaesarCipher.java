public class CaesarCipher {
    public static void main(String[] args) {
        String message = "Hello World";
        System.out.println(encrypt(message, 3));
        System.out.println(encrypt(message));
    }

    // encrypt with a given shift
    static String encrypt(String message, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // encrypt with default shift of 13 (ROT13)
    static String encrypt(String message) {
        return encrypt(message, 13);
    }
}
