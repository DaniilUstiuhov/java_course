public class OperatorsCalculations {
    public static void main(String[] args) {
        // Step 1
        double first = 20.00;

        // Step 2
        double second = 80.00;

        // Step 3: add both, then multiply by 100
        double result = (first + second) * 100.00;

        // Step 4: remainder when divided by 40
        double remainder = result % 40.00;

        // Step 5: true if remainder is zero
        boolean isZero = remainder == 0.00;

        // Step 6: print the boolean
        System.out.println(isZero);

        // Step 7: print message if not zero
        if (!isZero) {
            System.out.println("got some remainder");
        }
    }
}
