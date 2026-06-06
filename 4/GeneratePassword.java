public class GeneratePassword {
    public static void main(String[] args) {
        System.out.println(generatePassword(12));
        System.out.println(generatePassword(8));
        System.out.println(generatePassword(5));
    }

    static String generatePassword(int length) {
        if (length < 8) {
            System.out.println("Minimum length is 8");
            return null;
        }

        String digits  = "0123456789";
        String lower   = "abcdefghijklmnopqrstuvwxyz";
        String upper   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()_+-=";
        String all     = digits + lower + upper + special;

        char[] password = new char[length];

        // guarantee at least one of each type
        password[0] = digits.charAt((int) (Math.random() * digits.length()));
        password[1] = lower.charAt((int) (Math.random() * lower.length()));
        password[2] = upper.charAt((int) (Math.random() * upper.length()));
        password[3] = special.charAt((int) (Math.random() * special.length()));

        // fill the rest randomly
        for (int i = 4; i < length; i++) {
            password[i] = all.charAt((int) (Math.random() * all.length()));
        }

        // shuffle positions
        for (int i = length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            char temp = password[i];
            password[i] = password[j];
            password[j] = temp;
        }

        return new String(password);
    }
}
