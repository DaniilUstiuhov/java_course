public class ElectronicProduct extends ProductForSale {
    public ElectronicProduct(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This " + getType() + " is a modern computer");
        System.out.printf("The price of the piece is %.1f euro.%n", getPrice());
        System.out.println(getDescription());
    }
}
