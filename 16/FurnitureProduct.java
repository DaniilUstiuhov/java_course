public class FurnitureProduct extends ProductForSale {
    public FurnitureProduct(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This " + getType() + " was manufactured in Estonia");
        System.out.printf("The price of the piece is %.1f euro.%n", getPrice());
        System.out.println(getDescription());
    }
}
