public class FuelPoweredCar extends Car {
    private String fuelType;
    private double tankCapacity;

    public FuelPoweredCar(String description, String fuelType, double tankCapacity) {
        super(description);
        this.fuelType = fuelType;
        this.tankCapacity = tankCapacity;
    }

    @Override
    public void startEngine() {
        System.out.println(getClass().getSimpleName() + ": igniting " + fuelType + " engine...");
    }

    @Override
    public void drive() {
        runEngine();
        System.out.println(getClass().getSimpleName() + ": driving on " + fuelType);
    }

    @Override
    protected void runEngine() {
        System.out.println(getClass().getSimpleName() + ": burning " + fuelType + " (tank: " + tankCapacity + "L)");
    }
}
