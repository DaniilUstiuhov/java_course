public class Carpet {
    private double width;
    private double length;
    static double squareMeterCost = 8.0;

    public Carpet(double width, double length) {
        this.width = width < 0 ? 0 : width;
        this.length = length < 0 ? 0 : length;
    }

    public double getArea() {
        return width * length;
    }

    public double getTotalCost() {
        return getArea() * squareMeterCost;
    }
}
