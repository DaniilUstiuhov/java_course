public class CarpetMain {
    public static void main(String[] args) {
        Carpet c1 = new Carpet(12.0, 10.0);
        Carpet c2 = new Carpet(5.5, 4.0);
        Carpet c3 = new Carpet(-2.0, 8.0);

        System.out.println("Room 1: area=" + c1.getArea() + " m2, cost=" + c1.getTotalCost() + " EUR");
        System.out.println("Room 2: area=" + c2.getArea() + " m2, cost=" + c2.getTotalCost() + " EUR");
        System.out.println("Room 3: area=" + c3.getArea() + " m2, cost=" + c3.getTotalCost() + " EUR");
    }
}
