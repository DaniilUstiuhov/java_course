public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() { return real; }
    public double getImaginary() { return imaginary; }

    public void add(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    public void subtract(double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    // add two complex numbers and return result
    public static ComplexNumber addNumbers(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.real + b.real, a.imaginary + b.imaginary);
    }

    // subtract two complex numbers and return result
    public static ComplexNumber subtractNumbers(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.real - b.real, a.imaginary - b.imaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}
