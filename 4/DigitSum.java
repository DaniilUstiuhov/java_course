public class DigitSum {
    public static void main(String[] args) {
        System.out.println(digitSum(125));
        System.out.println(digitSum(7));
        System.out.println(digitSum(-5));
    }

    static int digitSum(int number) {
        if (number < 0) return -1;
        if (number < 10) return number;
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
