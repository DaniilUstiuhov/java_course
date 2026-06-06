public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }

    public void startEngine() {
        // prints runtime type
        System.out.println(getClass().getSimpleName() + ": starting engine...");
    }

    public void drive() {
        runEngine();
        System.out.println(getClass().getSimpleName() + ": driving...");
    }

    protected void runEngine() {
        System.out.println(getClass().getSimpleName() + ": running generic engine");
    }
}
