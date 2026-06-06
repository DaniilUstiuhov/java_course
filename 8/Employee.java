public class Employee extends Worker {
    private long employeeId;
    private String hireDate;

    public Employee(String name, String birthDate, long employeeId, String hireDate) {
        super(name, birthDate);
        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }

    public long getEmployeeId() { return employeeId; }
    public String getHireDate() { return hireDate; }

    @Override
    public String toString() {
        return "Employee #" + employeeId + " - " + super.toString() + ", hired: " + hireDate;
    }
}
