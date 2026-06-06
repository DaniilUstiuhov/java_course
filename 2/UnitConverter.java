public class UnitConverter {
    public static void main(String[] args) {
        System.out.println(convertToCentimeters(68));
        System.out.println(convertToCentimeters(5, 8));
    }

    // convert inches to centimeters
    static double convertToCentimeters(int inches) {
        return inches * 2.54;
    }

    // convert feet and inches to centimeters
    static double convertToCentimeters(int feet, int inches) {
        int totalInches = feet * 12 + inches;
        return convertToCentimeters(totalInches);
    }
}
