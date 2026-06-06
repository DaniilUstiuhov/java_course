import java.util.ArrayList;
import java.util.List;

public class Meal {
    private Burger burger;

    public Meal(String burgerName, double burgerPrice) {
        this.burger = new Burger(burgerName, burgerPrice);
    }

    // delegate topping addition to the inner burger
    public void addToppings(String... toppings) {
        burger.addToppings(toppings);
    }

    public void printMeal() {
        burger.printBurger();
    }

    // Burger is a specialized Item that holds a list of toppings
    class Burger extends Item {
        private List<Item> toppings = new ArrayList<>();

        Burger(String name, double price) {
            super(name, "BURGER", price);
        }

        void addToppings(String... names) {
            for (String name : names) {
                toppings.add(new Item(name, "TOPPING", getToppingPrice(name)));
            }
        }

        // some toppings cost extra, rest are free
        private double getToppingPrice(String name) {
            return switch (name.toLowerCase()) {
                case "cheese"   -> 0.50;
                case "bacon"    -> 1.00;
                case "avocado"  -> 1.50;
                case "mushroom" -> 0.75;
                default         -> 0.0;
            };
        }

        void printBurger() {
            System.out.println(this);
            double toppingTotal = 0;
            for (Item topping : toppings) {
                System.out.println("  + " + topping);
                toppingTotal += topping.getPrice();
            }
            System.out.printf("  Toppings extra: $%.2f%n", toppingTotal);
            System.out.printf("  Total price:    $%.2f%n", getPrice() + toppingTotal);
        }
    }
}
