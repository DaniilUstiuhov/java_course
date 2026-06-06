public class MealMain {
    public static void main(String[] args) {
        Meal meal1 = new Meal("Classic Burger", 8.50);
        meal1.addToppings("lettuce", "tomato", "cheese", "bacon");
        meal1.printMeal();

        System.out.println();

        Meal meal2 = new Meal("Deluxe Burger", 11.00);
        meal2.addToppings("lettuce", "onion", "avocado", "mushroom", "ketchup");
        meal2.printMeal();
    }
}
