public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(isFibonacci(8));
        System.out.println(isFibonacci(10));
        System.out.println(isFibonacci(0));
    }

    static boolean isFibonacci(int n) {
        if (n < 0) return false;
        // n is Fibonacci if 5*n^2 + 4 or 5*n^2 - 4 is a perfect square
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }

    static boolean isPerfectSquare(int n) {
        if (n < 0) return false;
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
