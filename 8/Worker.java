import java.time.LocalDate;
import java.time.Period;

public class Worker {
    private String name;
    private String birthDate;
    private String endDate;

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        LocalDate birth = LocalDate.parse(birthDate);
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public double collectPay() {
        return 0;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() { return name; }
    public String getBirthDate() { return birthDate; }
    public String getEndDate() { return endDate; }

    @Override
    public String toString() {
        return name + " (born: " + birthDate + ")";
    }
}
