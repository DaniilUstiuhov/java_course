import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<ProductForSale> products = new ArrayList<>();
    private static List<OrderItem> order = new ArrayList<>();

    public static void main(String[] args) {
        ProductForSale desktop = new ElectronicProduct("desktop", 700.0, "Desktop Computer");
        ProductForSale laptop  = new ElectronicProduct("laptop",  900.0, "Laptop");
        ProductForSale desk    = new FurnitureProduct("desk",     100.0, "Computer Desk");
        ProductForSale chair   = new FurnitureProduct("chair",    200.0, "Reading Chair");

        products.add(desktop);
        products.add(laptop);
        products.add(desk);
        products.add(chair);

        // show all product details
        for (ProductForSale p : products) {
            System.out.println("----------------------------------");
            p.showDetails();
            System.out.println();
        }

        // order 1
        System.out.println("Order 1");
        addItemToOrder(2, laptop);
        addItemToOrder(1, desktop);
        printOrder();
        clearOrder();

        System.out.println();

        // order 2
        System.out.println("Order 2");
        addItemToOrder(5, chair);
        addItemToOrder(1, desktop);
        addItemToOrder(1, desk);
        printOrder();
    }

    static void addItemToOrder(int quantity, ProductForSale product) {
        order.add(new OrderItem(quantity, product));
    }

    static void printOrder() {
        double total = 0;
        for (OrderItem item : order) {
            item.getProduct().printPricedItem(item.getQuantity());
            total += item.getProduct().getSalesPrice(item.getQuantity());
        }
        System.out.printf("Total sales: %.1f euro.%n", total);
    }

    static void clearOrder() {
        order.clear();
    }
}
