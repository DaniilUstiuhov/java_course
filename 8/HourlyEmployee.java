public class HourlyEmployee extends Employee {
    private double hourlyPayRate;

    public HourlyEmployee(String name, String birthDate, long employeeId,
                          String hireDate, double hourlyPayRate) {
        super(name, birthDate, employeeId, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getDoublePay() {
        return hourlyPayRate * 2;
    }

    @Override
    public double collectPay() {
        return hourlyPayRate * 40; // standard 40 hours per week
    }
}
