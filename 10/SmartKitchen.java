public class SmartKitchen {
    private CoffeeMaker brewMaster = new CoffeeMaker();
    private DishWasher dishWasher = new DishWasher();
    private Refrigerator iceBox = new Refrigerator();

    public CoffeeMaker getBrewMaster() { return brewMaster; }
    public DishWasher getDishWasher() { return dishWasher; }
    public Refrigerator getIceBox() { return iceBox; }

    public void addWater() { brewMaster.setHasWorkToDo(true); }
    public void pourMilk() { iceBox.setHasWorkToDo(true); }
    public void loadDishwasher() { dishWasher.setHasWorkToDo(true); }

    public void setKitchenState(boolean coffeeMaker, boolean refrigerator, boolean dishWasher) {
        brewMaster.setHasWorkToDo(coffeeMaker);
        iceBox.setHasWorkToDo(refrigerator);
        this.dishWasher.setHasWorkToDo(dishWasher);
    }

    // delegates work to all appliances
    public void doKitchenWork() {
        brewMaster.brewCoffee();
        iceBox.orderFood();
        dishWasher.doDishes();
    }
}
