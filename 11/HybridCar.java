public class HybridCar extends Car {
    private String fuelType;
    private double batteryCapacity;

    public HybridCar(String description, String fuelType, double batteryCapacity) {
        super(description);
        this.fuelType = fuelType;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void startEngine() {
        System.out.println(getClass().getSimpleName() + ": starting hybrid system (" + fuelType + " + electric)...");
    }

    @Override
    public void drive() {
        runEngine();
        System.out.println(getClass().getSimpleName() + ": driving in hybrid mode");
    }

    @Override
    protected void runEngine() {
        System.out.println(getClass().getSimpleName() + ": switching between " + fuelType + " and " + batteryCapacity + " kWh battery");
    }
}
