public class ElectricCar extends Car {
    private double batteryCapacity;
    private int chargeLevel;

    public ElectricCar(String description, double batteryCapacity, int chargeLevel) {
        super(description);
        this.batteryCapacity = batteryCapacity;
        this.chargeLevel = chargeLevel;
    }

    @Override
    public void startEngine() {
        System.out.println(getClass().getSimpleName() + ": activating electric motor...");
    }

    @Override
    public void drive() {
        runEngine();
        System.out.println(getClass().getSimpleName() + ": driving silently on battery");
    }

    @Override
    protected void runEngine() {
        System.out.println(getClass().getSimpleName() + ": using battery (" + chargeLevel + "% charge, " + batteryCapacity + " kWh)");
    }
}
