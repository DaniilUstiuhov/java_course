public class CarsMain {
    public static void main(String[] args) {
        FuelPoweredCar fuelCar    = new FuelPoweredCar("Toyota Corolla", "gasoline", 50.0);
        ElectricCar    electricCar = new ElectricCar("Tesla Model 3", 75.0, 80);
        HybridCar      hybridCar   = new HybridCar("Toyota Prius", "gasoline", 8.8);

        // polymorphic array - calls overridden methods on each object
        Car[] cars = {fuelCar, electricCar, hybridCar};
        for (Car car : cars) {
            System.out.println("\n" + car.getDescription());
            car.startEngine();
            car.drive();
        }
    }
}
