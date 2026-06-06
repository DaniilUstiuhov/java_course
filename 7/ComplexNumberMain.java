public class ComplexNumberMain {
    public static void main(String[] args) {
        ComplexNumber n1 = new ComplexNumber(5, 3);
        ComplexNumber n2 = new ComplexNumber(4, 2);

        // instance methods
        n1.add(1, 1);
        System.out.println("After add: " + n1);
        n1.subtract(2, 0);
        System.out.println("After subtract: " + n1);

        // static methods
        ComplexNumber sum = ComplexNumber.addNumbers(n1, n2);
        System.out.println("Static add: " + sum);

        ComplexNumber diff = ComplexNumber.subtractNumbers(n1, n2);
        System.out.println("Static subtract: " + diff);
    }
}
