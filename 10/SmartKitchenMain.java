public class SmartKitchenMain {
    public static void main(String[] args) {
        SmartKitchen kitchen = new SmartKitchen();

        // way 1: set state individually and access appliances directly via getters
        System.out.println("--- Way 1: direct access via getters ---");
        kitchen.addWater();
        kitchen.pourMilk();
        kitchen.loadDishwasher();
        kitchen.getBrewMaster().brewCoffee();
        kitchen.getIceBox().orderFood();
        kitchen.getDishWasher().doDishes();

        // way 2: set state with one method and let kitchen delegate the work
        System.out.println("\n--- Way 2: doKitchenWork() delegates ---");
        kitchen.setKitchenState(true, false, true);
        kitchen.doKitchenWork();
    }
}
