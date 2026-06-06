public class SalariedEmployee extends Employee {
    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, long employeeId,
                            String hireDate, double annualSalary) {
        super(name, birthDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = false;
    }

    public void retire() {
        isRetired = true;
    }

    public boolean isRetired() { return isRetired; }

    @Override
    public double collectPay() {
        // retired gets full weekly salary, active gets 90%
        double rate = isRetired ? 1.0 : 0.9;
        return (annualSalary / 52) * rate;
    }
}
