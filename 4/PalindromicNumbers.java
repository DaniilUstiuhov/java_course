public class PalindromicNumbers {
    public static void main(String[] args) {
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(11212));
    }

    static boolean isPalindrome(int number) {
        if (number < 0) return false;
        int original = number;
        int reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return original == reversed;
    }
}
